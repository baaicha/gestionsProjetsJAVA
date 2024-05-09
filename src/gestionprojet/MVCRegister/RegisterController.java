package gestionprojet.MVCRegister;
import gestionprojet.MVCLogin.*;
/*cette classe est controller*/


public class RegisterController {
 /**/
    private RegisterVue view;
    private EmployeeModel employeeModel;

 
    public RegisterController(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public void setRegisterVue(RegisterVue registerVue) {
        this.view = registerVue;
        this.view.setController(this); // Mettre à jour la référence du contrôleur dans la vue
    }
    public boolean register(String matricule, String prenom, String nom, String email, String motDePasse) {
        // Appel de la méthode registerEmployee du modèle pour enregistrer l'employé
        return employeeModel.registerEmployee(matricule, prenom, nom, email, motDePasse);
    }

    public void showLoginForm() {
        // Méthode pour afficher le formulaire de connexion
        CompteModel utilisateurDAO = new CompteModel();
        
        // Création de l'instance du contrôleur
        LoginController controller = new LoginController(utilisateurDAO);
        
        // Création de la vue de connexion
        LoginVue loginVue = new LoginVue(controller);
        view.dispose(); // Fermer la vue d'enregistrement
    }
}
