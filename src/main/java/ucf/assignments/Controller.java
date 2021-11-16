package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

public class Controller {

    private static Scene_Selector select;

    private static String title;

    public Controller(String title){

        this.title = title;

    }

    protected String get_Title(){

        return this.title;

    }

    protected void set_Scene_Selector(Scene_Selector select){

        this.select = select;

    }

    protected void change_Scene(String FXML_address){

        select.change_Scene(FXML_address);

    }

}
