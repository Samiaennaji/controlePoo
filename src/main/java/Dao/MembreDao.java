package Dao;
import Model.Membre;
import java.util.List;

public interface MembreDao {
    void ajouterMembre(Membre membre);
    List<Membre> getTousLesMembres();
    Membre chercherParId(String id);
    void supprimerMembre(String id);
}
