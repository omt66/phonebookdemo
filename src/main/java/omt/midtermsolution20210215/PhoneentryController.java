package omt.midtermsolution20210215;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author omt
 */
public class PhoneentryController {
    @FXML
    public void initialize() {
        // Init code here if needed!
    }   
    
    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhoneHome;

    @FXML
    private TextField txtPhoneWork;

    @FXML
    private TextField txtPhoneMobile;

    @FXML
    private AnchorPane rootPane;
   
    @FXML
    void handleOK(ActionEvent event) {
        Stage stage = (Stage)rootPane.getScene().getWindow();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String homePhone = txtPhoneHome.getText();
        String workPhone = txtPhoneWork.getText();
        String mobilePhone = txtPhoneMobile.getText();
        
        PhonebookEntry entry = new PhonebookEntry(firstName, lastName, homePhone, workPhone, mobilePhone);
        // Save this entry in the phonebook
        PhonebookController.addEntry(entry);
        
        System.out.println("Phone info: " + entry);
        stage.close();
    }
    
    @FXML
    void handleCancel(ActionEvent event) {
        Stage stage = (Stage)rootPane.getScene().getWindow();
        stage.close();
    }

}
