import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943);
        book2 = new Book("1984", "George Orwell", 1949);
        library.ajouterLivre(book1);
        library.ajouterLivre(book2);
    }

    @Test
    void ajouterLivre() {
        Book newBook = new Book("Fahrenheit 451", "Ray Bradbury", 1953);
        library.ajouterLivre(newBook);
        assertEquals(newBook, library.rechercherLivre("Fahrenheit 451"));
    }

    @Test
    void supprimerLivre() {
        assertTrue(library.supprimerLivre(book1));
        assertNull(library.rechercherLivre("Le Petit Prince"));
    }

    @Test
    void rechercherLivre() {
        Book found = library.rechercherLivre("1984");
        assertNotNull(found);
        assertEquals("George Orwell", found.getAuteur());
    }

    @Test
    void rechercherLivrePartial() {
        Book found = library.rechercherLivre("petit");
        assertNotNull(found);
        assertEquals("Le Petit Prince", found.getTitre());
    }

    @Test
    void afficherLivres() {
        List<Book> books = library.afficherLivres();
        assertNotNull(books);
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void getLivresSorted() {
        Book book3 = new Book("Animal Farm", "George Orwell", 1945);
        library.ajouterLivre(book3);
        Book book4 = new Book("Brave New World", "Aldous Huxley", 1932);
        library.ajouterLivre(book4);

        List<Book> sortedBooks = library.getLivresSorted();
        assertNotNull(sortedBooks);
        assertEquals(4, sortedBooks.size());
        assertEquals("1984", sortedBooks.get(0).getTitre());
        assertEquals("Animal Farm", sortedBooks.get(1).getTitre());
        assertEquals("Brave New World", sortedBooks.get(2).getTitre());
        assertEquals("Le Petit Prince", sortedBooks.get(3).getTitre());
    }

    @Test
    void exportLibraryToTxt() {
        library.exportLibraryToTxt();
        File exportFile = new File("export.txt");
        assertTrue(exportFile.exists());
        assertTrue(exportFile.delete());
    }
}