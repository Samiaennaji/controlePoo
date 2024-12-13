package Ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Util.IdGenerator;
import Model.Membre;
import Dao.MembreDao;
import Dao.MembreDaoImpl;

public class AjouterMembreApp extends Application {

    private MembreDao membreDao = new MembreDaoImpl(); // DAO pour gérer les membres

    @Override
    public void start(Stage primaryStage) {
        Label labelNom = new Label("Nom :");
        TextField textNom = new TextField();

        Label labelPrenom = new Label("Prénom :");
        TextField textPrenom = new TextField();

        Label labelEmail = new Label("Email :");
        TextField textEmail = new TextField();

        Label labelTelephone = new Label("Téléphone :");
        TextField textTelephone = new TextField();

        Button boutonAjouter = new Button("Ajouter");

        // Gestion de l'événement clic sur le bouton "Ajouter"
        boutonAjouter.setOnAction(e -> {
            String id = IdGenerator.generateId();
            String nom = textNom.getText();
            String prenom = textPrenom.getText();
            String email = textEmail.getText();
            String telephone = textTelephone.getText();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || telephone.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Tous les champs sont obligatoires !");
            } else {
                Membre membre = new Membre(id, nom, prenom, email, telephone);
                membreDao.ajouterMembre(membre); // Ajouter à la liste des membres
                showAlert(Alert.AlertType.INFORMATION, "Succès", "Membre ajouté avec succès !");
                textNom.clear();
                textPrenom.clear();
                textEmail.clear();
                textTelephone.clear();
            }
        });

        VBox layout = new VBox(10, labelNom, textNom, labelPrenom, textPrenom, labelEmail, textEmail, labelTelephone, textTelephone, boutonAjouter);
        Scene scene = new Scene(layout, 400, 400);

        primaryStage.setTitle("Ajouter un nouveau membre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
