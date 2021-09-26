package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s = "https://raw.githubusercontent.com/LearnWebCode/json-example/master/pets-data.json";

        try {
            String json = IO.readHTTP(s);
            ArrayList<Pet> pets = new ArrayList<>();

            JSONParser parser = new JSONParser();

            JSONObject petsObject = (JSONObject) parser.parse(json);

            JSONArray petsArray = (JSONArray) petsObject.get("pets");

            for (int i = 0; i < petsArray.size(); i++) {
                JSONObject petObject = (JSONObject) petsArray.get(i);

                String name = (String) petObject.get("name");
                String photo = (String) petObject.get("photo");
                Long birthYear = (Long) petObject.get("birthYear");
                String species = (String) petObject.get("species");


                JSONArray favFoods = (JSONArray) petObject.get("favFoods");
                String[] foodArray = {};
                if (favFoods != null) {
                    foodArray = new String[favFoods.size()];
                    for (int j = 0; j < favFoods.size(); j++) {
                        String food = (String) favFoods.get(j);
                        foodArray[j] = food;
                    }
                }

                pets.add(new Pet(name, species, foodArray, birthYear.intValue(), photo));
                System.out.println(petObject);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



        //ReadJsonFromUrl();
     /*   String s = "https://raw.githubusercontent.com/LearnWebCode/json-example/master/pets-data.json";
        try {
            InputStream in = IO.getHTTP(s);
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        // short way get json from url
       /* try {
            String json = IO.readHTTP(s);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        //read json from url
      /*  try {
            InputStream in = IO.getHTTP(s);
            String json = IO.read(in);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

*/
    }



    /*private static void ReadJsonFromUrl() {
        String s = "https://raw.githubusercontent.com/LearnWebCode/json-example/master/pets-data.json";
        try {
            URL url = new URL(s);
            URLConnection con  = url.openConnection();
            //  InputStream - String of butes 0 and 1 Binary InputStream
            InputStream in  = con.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bf = new BufferedReader(reader);
            //String line = bf.readLine(); read only one raw
           // System.out.println(line); read only one raw
            String line = null;
            while ((line = bf.readLine()) != null){
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
