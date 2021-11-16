package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

public class Vehicle {

    private static List listInstance = new List();

    private static Item itemInstance = new Item();

    public static void clear(){

        itemInstance = new Item();

        listInstance = new List();

    }

    public static List get_List_Instance(){

        return listInstance;

    }

    public static void set_List_Instance(List set){

        listInstance = set;

    }

    public static Item get_Item_Instance(){

        return itemInstance;

    }

    public static void set_Item_Instance(Item set){

        itemInstance = set;

    }

}
