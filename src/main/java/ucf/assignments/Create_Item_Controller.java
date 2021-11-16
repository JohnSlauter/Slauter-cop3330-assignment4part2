package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Create_Item_Controller extends Controller implements Initializable {

    private static final String FXML_address = "/fxml/Create_Item.fxml";

    @FXML private TextField description_field;

    @FXML private DatePicker due_date_field;

    public Create_Item_Controller() {

        super("Create Item");

    }

    public void initialize(URL location, ResourceBundle resources) {

        if(Vehicle.get_Item_Instance().get_Description() != null) {

            description_field.setText(Vehicle.get_Item_Instance().get_Description());

        }

        if(Vehicle.get_Item_Instance().get_Due_Date() != null){

            due_date_field.setValue(LocalDate.parse(Vehicle.get_Item_Instance().get_Due_Date(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        }

    }

    @FXML
    private void create_Item(ActionEvent e){

        String temp_description = description_field.getText();

        if(temp_description.isEmpty() || due_date_field.getValue() == null || temp_description.length() > 256){

            return;

        }

        String temp_date = due_date_field.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Vehicle.get_List_Instance().add_Item(new Item(temp_description, temp_date));

        Vehicle.get_List_Instance().remove_Item(Vehicle.get_Item_Instance());

        super.change_Scene("/fxml/List_UI.fxml");

    }

    @FXML
    private void cancel(ActionEvent e){

        super.change_Scene("/fxml/List_UI.fxml");

    }

}
