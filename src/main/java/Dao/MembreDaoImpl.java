package Dao;

import Model.Membre;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao {
    private List<Membre> membres = new ArrayList<>();

    @Override
    public void ajouterMembre(Membre membre) {
        membres.add(membre);
        System.out.println("Membre ajouté : " + membre);
    }

    @Override
    public List<Membre> getTousLesMembres() {
        return membres;
    }

    @Override
    public Membre chercherParId(String id) {
        return membres.stream()
                .filter(membre -> membre.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void supprimerMembre(String id) {
        membres.removeIf(membre -> membre.getId().equals(id));
        System.out.println("Membre supprimé avec ID : " + id);
    }
}
