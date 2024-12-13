package Util;

import Model.Membre;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CsvUtils {
    public static Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] details = ligne.split(",");
                if (details.length == 4) {
                    String id = IdGenerator.generateId();
                    String nom = details[0].trim();
                    String prenom = details[1].trim();
                    String email = details[2].trim();
                    String telephone = details[3].trim();
                    Membre membre = new Membre(id, nom, prenom, email, telephone);
                    membres.add(membre); // Les doublons sont éliminés grâce à HashSet
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return membres;
    }
}
