package com.company;
/*
package com.company;

import java.io.FileReader;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Main {

	@SuppressWarnings("unchecked")
    public static void main(String[] args) {

    	//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("customer.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            // create parser
            JSONObject parser = (JSONObject)obj;

            parseAnnonceObject(parser);

            //close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Parse JSON Object
	private static void parseAnnonceObject(JSONObject parser)
    {
        Map<Object, Object> contacts = (Map<Object, Object>) parser.get("contacts");
        JSONObject phone1 = (JSONObject) contacts.get("phone1");
        String phoneValue = (String) phone1.get("value");
        contacts.put("phone1",phoneValue);

        contacts.forEach((key, value) ->
                System.out.println(key + ": " + value)
        );

        System.out.println("---------");

        // read out details
        String creationDate = (String) parser.get("creationDate");
        Long price = (Long) parser.get("price");
        String reference = (String) parser.get("reference");

        System.out.println(creationDate);
        System.out.println(price);
        System.out.println(reference);

        JSONArray publicationOptions = (JSONArray) parser.get("publicationOptions");
        publicationOptions.forEach(System.out::println);

        System.out.println("---------");

        // read vehicule details
        Map<Object, Object> vehicle = (Map<Object, Object>) parser.get("vehicle");
        vehicle.forEach((key, value) -> System.out.println(key + ": " + value));


    }

    private static void reglesDetails(){

    }

    private static void scamAnalyzer(){

    }

}


*/