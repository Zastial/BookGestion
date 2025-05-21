import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFunctionnalTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943);
        book2 = new Book("1984", "George Orwell", 1949);
        book3 = new Book("L'Étranger", "Albert Camus", 1942);
    }

    @Test
    void scenarioComplet() {
        // On vient ajouter 3 livres dans notre bibliothèque
        library.ajouterLivre(book1);
        library.ajouterLivre(book2);
        library.ajouterLivre(book3);

        // On vient supprimer un livre
        assertTrue(library.supprimerLivre(book2));

        // On vient vérifier que le livre a bien été supprimé
        assertNull(library.rechercherLivre("1984"));

        // On vient vérifier que les autres livres sont toujours présents
        assertNotNull(library.rechercherLivre("Le Petit Prince"));
        assertNotNull(library.rechercherLivre("L'Étranger"));

        // On vient afficher les livres restants
        List<Book> books = library.afficherLivres();
        assertNotNull(books);
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book3));
        assertFalse(books.contains(book2));
    }
}