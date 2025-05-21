import model.Book;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> livres = new ArrayList<>();

    public void ajouterLivre(Book book) {
        livres.add(book);
    }

    public boolean supprimerLivre(Book book) {
        return livres.remove(book);
    }

    public Book rechercherLivre(String titre) {
        for (Book livre : livres) {
            if (livre.getTitre().toLowerCase().contains(titre.toLowerCase())) {
                return livre;
            }
        }
        return null;
    }

    public List<Book> afficherLivres() {
        return livres;
    }

    public List<Book> getLivresSorted() {
        livres.sort((b1, b2) -> b1.getTitre().compareToIgnoreCase(b2.getTitre()));
        return livres;
    }

    public void exportLibraryToTxt() {
        try (PrintWriter pw = new PrintWriter("export.txt")) {
            for (Book livre : livres) {
                pw.println(livre.getTitre() + " - " + livre.getAuteur() + " - " + livre.getAnneePublication());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}