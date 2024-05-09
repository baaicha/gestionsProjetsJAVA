package gestionprojet.MVCLogin;


import gestionprojet.MVCRegister.*;
import javax.swing.JOptionPane;
import com.raven.form.Form_Home;
import com.raven.main.Main2;


public class LoginController {
    private CompteModel utilisateurDAO;
    private LoginVue loginVue;

    public LoginController(CompteModel utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    public void setLoginVue(LoginVue loginVue) {
        this.loginVue = loginVue;
        this.loginVue.setController(this); // Mettre à jour la référence du contrôleur dans la vue
    }
 
    public void authenticateUser() {
        String email = loginVue.getEmail();
        String password = loginVue.getPassword();

        if ("".equals(email)) {
            JOptionPane.showMessageDialog(loginVue, "Email Address is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(password)) {
            JOptionPane.showMessageDialog(loginVue, "Password is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean utilisateurValide = utilisateurDAO.verifierUtilisateur(email, password);
            if (utilisateurValide) {
                // Redirection vers la vue suivante
                 Main2 HomeFrame = new Main2();
                 HomeFrame.setVisible(true);
               //  Main2 m=new Main2();

//                  HomeFrame.pack();
//                  HomeFrame.setLocationRelativeTo(null); 
//                  HomeFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(loginVue, "Incorrect email or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
            loginVue.clearPassword();
        }
    }

    public void showSignUpForm() {
       EmployeeModel employeeModel = new EmployeeModel();
        
        // Création de l'instance du contrôleur
        RegisterController controller = new RegisterController(employeeModel);
        
        // Création de la vue de connexion
        RegisterVue registerVue = new RegisterVue(controller);
        controller.setRegisterVue(registerVue);
        
        // Affichage de la vue de connexion
        registerVue.setVisible(true);
    }
}
