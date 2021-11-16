package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Scene_Selector extends Application {

    private static final String primary_Scene = "/fxml/List_UI.fxml";

    private Stage primaryStage;

    public void start(Stage primaryStage) {

        Controller c = new Controller("");

        c.set_Scene_Selector(this);

        this.primaryStage = primaryStage;

        change_Scene(primary_Scene);

        primaryStage.show();

    }

    protected void change_Scene(String FXML_address){

        URL source = getClass().getResource(FXML_address);

        try {

            FXMLLoader load = new FXMLLoader();

            load.setLocation(source);

            Parent root = load.load();

            Scene s = new Scene(root);

            primaryStage.setScene(s);

            Controller c = load.getController();

            primaryStage.setTitle(c.get_Title());

        }

        catch(Exception e){

            System.out.print(e.getStackTrace() + e.getMessage() + e.getCause());

        }

    }

}
