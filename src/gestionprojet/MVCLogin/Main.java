/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionprojet.MVCLogin;
import gestionprojet.MVCLogin.LoginController;
/**
 *
 * @author User
 */
public class Main {
    

    public static void main(String[] args) {
        // Création d'une instance de la classe LoginVue
        
       CompteModel utilisateurDAO = new CompteModel();
        
        // Création de l'instance du contrôleur
        LoginController controller = new LoginController(utilisateurDAO);
        
        // Création de la vue de connexion
        LoginVue loginVue = new LoginVue(controller);
        
        // Mettre à jour le contrôleur dans la vue
        controller.setLoginVue(loginVue);
        
        // Affichage de la vue de connexion
        loginVue.setVisible(true);
    }

}
