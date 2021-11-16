package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 John Slauter
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class List_Translator {

    public List_Translator(){}

    public static List file_To_List(File f) throws FileNotFoundException {

        if(!(f.exists())){

            throw new FileNotFoundException(String.format("Failed to load \"%s\".", f.toString()));

        }

        List list_load = new List(f.toString());

        Scanner reader = new Scanner(f);

        reader.useDelimiter("\n|,");

        String temp_description = null, temp_date = null, temp_complete;

        int counter = 0;

        while(reader.hasNext()){

            switch(counter){

                case 0:{

                    temp_description = reader.next();

                    break;

                }

                case 1:{

                    temp_date = reader.next();

                    break;

                }

                case 2:{

                    temp_complete = reader.next();

                    list_load.add_Item(new Item(temp_description, temp_date, Boolean.parseBoolean(temp_complete)));

                    counter = -1;

                    break;

                }

            }

            counter++;

        }

        return list_load;

    }

    public static void list_To_File(List source) throws Exception{

        if(source.get_Address() == null){

            throw new Exception("File has an unspecified address.");

        }

        File storage = new File(source.get_Address());

        BufferedWriter write = new BufferedWriter(new FileWriter(storage));

        for(Item i : source.get_Item_List()){

            write.append(String.format("%s,%s,%s\n", i.get_Description(), i.get_Due_Date(), Boolean.toString(i.get_Complete())));

        }

        write.close();

    }

}
