package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {

    private String description, due_date;

    private boolean complete;

    public Item(String description, String due_date, boolean complete){

        this.description = description;

        this.due_date = due_date;

        this.complete = complete;

    }

    public Item(String description, String due_date){

        this(description, due_date, false);

    }

    public Item(){

        this(null, null, false);

    }

    public String get_Description(){

        return description;

    }

    public SimpleStringProperty get_Description_Property(){

        return new SimpleStringProperty(description);

    }

    public String get_Due_Date(){

        return due_date;

    }

    public SimpleStringProperty get_Due_Date_Property(){

        return new SimpleStringProperty(due_date);

    }

    public boolean get_Complete(){

        return complete;

    }

    public SimpleBooleanProperty get_Complete_Property(){

        return new SimpleBooleanProperty(complete);

    }

    public boolean compare(Item i){

        if(!description.equals(i.get_Description())){

            return false;

        }

        if(!due_date.equals(i.get_Due_Date())){

            return false;

        }

        if(!complete == i.get_Complete()){

            return false;

        }

        return true;

    }

    public void set_Description(String description){

        this.description = description;

    }

    public void set_Due_Date(String due_date){

        this.due_date = due_date;

    }

    public void set_Complete(boolean complete){

        this.complete = complete;

    }

}
