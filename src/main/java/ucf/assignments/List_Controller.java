package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class List_Controller extends Controller implements Initializable {

    private static final String FXML_address = "/fxml/List_UI.fxml";

    private static FileChooser explorer;

    private static final FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(".list (List File)", "*.list");

    @FXML private TableView table;

    @FXML private TableColumn<Item, String> description, due_date;

    @FXML private TableColumn<Item, Boolean> complete;

    public List_Controller() {

        super("List");

        explorer = new FileChooser();

        explorer.getExtensionFilters().add(filter);

        explorer.setSelectedExtensionFilter(filter);

    }

    public void initialize(URL location, ResourceBundle resources) {

        complete.setCellValueFactory(cellData -> cellData.getValue().get_Complete_Property());

        description.setCellValueFactory(cellData -> cellData.getValue().get_Description_Property());

        due_date.setCellValueFactory(cellData -> cellData.getValue().get_Due_Date_Property());

        table.setRowFactory( factory -> {

            TableRow<Item> item_row = new TableRow<>();

            item_row.setOnMouseClicked(e -> {

                if(item_row.isEmpty()){

                    return;

                }

                if(1 < e.getClickCount() && e.getButton() == MouseButton.PRIMARY){

                    edit_Item(item_row.getItem());

                }

                else if(e.getButton() == MouseButton.PRIMARY){

                    item_row.getItem().set_Complete(!item_row.getItem().get_Complete());

                    display_All();

                }

                else if(e.getButton() == MouseButton.SECONDARY){

                    delete_Item(item_row.getItem());

                }

            });

            return item_row;

        });

        if(Vehicle.get_List_Instance() != null){

            display_All();

        }

    }

    public void display_List(ArrayList<Item> list){

        ObservableList<Item> item_display_list = FXCollections.observableArrayList(list);

        table.getItems().clear();

        table.setItems(item_display_list);

    }

    @FXML
    private void blank_list(ActionEvent e){

        Vehicle.clear();

        display_All();

    }

    @FXML
    private void clear_list(ActionEvent e){

        Vehicle.get_List_Instance().clear();

        display_All();

    }

    @FXML
    private void display_All(){

       display_List(Vehicle.get_List_Instance().get_Item_List());

    }

    @FXML
    private void display_Complete(){

        display_List(Vehicle.get_List_Instance().get_Complete_Item_List());

    }

    @FXML
    private void display_Incomplete(){

        display_List(Vehicle.get_List_Instance().get_Incomplete_Item_List());

    }

    @FXML
    private void load_File_Explorer(ActionEvent e) throws FileNotFoundException {

        File selected = explorer.showOpenDialog(null);

        try {

            Vehicle.set_List_Instance(List_Translator.file_To_List(selected));

            display_All();

        }

        catch(FileNotFoundException ex){

            throw ex;

        }

    }

    @FXML
    private void save_list(ActionEvent e){

        if(Vehicle.get_List_Instance() == null){

            return;

        }

        if(Vehicle.get_List_Instance().get_Address() == null){

            save_File_Explorer(e);

            return;

        }

        try {

            List_Translator.list_To_File(Vehicle.get_List_Instance());

        }

        catch(Exception ex){

            System.out.print(ex.getStackTrace());

        }

    }

    @FXML
    private void save_File_Explorer(ActionEvent e){

        if(Vehicle.get_List_Instance() == null){

            return;

        }

        Vehicle.get_List_Instance().set_Address(explorer.showSaveDialog(null).toString());

        save_list(e);

    }

    @FXML
    private void create_Item(){

        super.change_Scene("/fxml/Create_Item.fxml");

    }

    private void edit_Item(Item i){

        Vehicle.set_Item_Instance(i);

        delete_Item(i);

        create_Item();

    }

    private void delete_Item(Item i){

        Vehicle.get_List_Instance().remove_Item(i);

    }

}
