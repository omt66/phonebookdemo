package omt.midtermsolution20210215;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class for the PhoneBook
 *
 * @author omt
 */
public class PhonebookController  {
    static ObservableList<PhonebookEntry> entries;
    
    @FXML 
    private TableView<PhonebookEntry> tableView1;
    
    /**
     * Initializes the controller class.
     */
    // @Override
    //public void initialize(URL url, ResourceBundle rb) {
    public void initialize() {
        List<PhonebookEntry> initialList = new ArrayList<>();
        initialList.add(new PhonebookEntry("Jane", "Walker", "619-555-1234", "619-555-4444", "858-555-5555"));
        initialList.add(new PhonebookEntry("Abc", "XYZ", "555-123-4567", "999-555-4444", "111-222-3456"));
        
        // Tables are tightly coupled with the data model so we need to map 
        // the attributes to the columns.
        TableColumn col;
        col = tableView1.getColumns().get(0);
        col.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col = tableView1.getColumns().get(1);
        col.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col = tableView1.getColumns().get(2);
        col.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
        col = tableView1.getColumns().get(3);
        col.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
        col = tableView1.getColumns().get(4);
        col.setCellValueFactory(new PropertyValueFactory<>("mobilePhone"));
       
        // Populate the initial data
        entries = FXCollections.observableList(initialList);
        tableView1.setItems(PhonebookController.entries);
    }
    
    static void addEntry(PhonebookEntry entry) {
        entries.add(entry);
    }

    @FXML
    void handleMenuItemNew(ActionEvent event) throws IOException {
        Scene scene = new Scene(App.loadFXML("phoneentry"));
        Stage popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Phonebook Entry");
        popupWindow.setScene(scene);
        popupWindow.showAndWait();
    }
    
    @FXML
    void handleMenuItemDelete(ActionEvent event) {
        PhonebookEntry item = tableView1.getSelectionModel().getSelectedItem();
        entries.remove(item);
    }
    
    @FXML
    void handleMenuItemExit(ActionEvent event) {
        System.exit(0);
    }
}
