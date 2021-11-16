package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

import java.util.ArrayList;

public class List {

    private ArrayList<Item> item_list;

    private String address;

    public List(String address){

        item_list = new ArrayList<>();

        this.address = address;

    }

    public List(){

        this(null);

    }

    public ArrayList<Item> get_Item_List(){

        return item_list;

    }

    public ArrayList<Item> get_Complete_Item_List(){

        ArrayList<Item> complete_item_list = new ArrayList<>();

        for(Item i : item_list){

            if(i.get_Complete()){

                complete_item_list.add(i);

            }

        }

        return complete_item_list;

    }

    public ArrayList<Item> get_Incomplete_Item_List(){

        ArrayList<Item> incomplete_item_list = new ArrayList<>();

        for(Item i : item_list){

            if(!i.get_Complete()){

                incomplete_item_list.add(i);

            }

        }

        return incomplete_item_list;

    }

    public String get_Address(){

        return address;

    }

    public void add_Item(Item i){

        item_list.add(i);

    }

    public void remove_Item(Item i){

        for(Item it : item_list){

            if(it.compare(i)){

                item_list.remove(it);

                return;

            }

        }

    }

    public void clear(){

        item_list.clear();

    }

    public void set_Address(String address){

        this.address = address;

    }

}
