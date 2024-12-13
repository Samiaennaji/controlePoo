package org.example;

import Util.CsvUtils;
import Model.Membre;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Exemple d'importation depuis un fichier CSV
        String fichierCsv = "membres.csv";
        Set<Membre> membres = CsvUtils.chargerListeMembre(fichierCsv);
        System.out.println("Membres importés :");
        membres.forEach(System.out::println);

        // Lancer l'IHM
        Ui.AjouterMembreApp.main(args);
    }
}
