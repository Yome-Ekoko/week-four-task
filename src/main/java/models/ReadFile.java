package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadFile {
    public static List<Products> readFile(String Filepath) {
        Store store = new Store();
        List<Products> prodList = new ArrayList<>();

        String line = "";
        try{
            FileReader file = new FileReader(Filepath);

            BufferedReader read = new BufferedReader(file);

            while((line = read.readLine()) != null){
                String[] value = line.split(",");

                String id = value[0];
                String name = value[1];
                String category = value[2];
                Float price = Float.valueOf(value[3]);
                Integer qty = Integer.valueOf(value[4]);
                String status = value[5];

                prodList.add(new Products(name, id, price, qty, category, status));


            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            return Collections.emptyList();
        }catch(IOException ex){
            System.out.println("There was an error reading this file");
            Collections.emptyList();
        }

        store.setAllProducts(prodList);

        return store.getAllProducts();

    }
}
