package com.company;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.company.models.Annonce;
import com.company.models.Loggerr;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;



public class Main {

	@SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException, IOException {

    	//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        ObjectMapper objectMapper = new ObjectMapper();
        Annonce annonce = new Annonce();

        try (FileReader reader = new FileReader("annonce.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            String s = obj.toString();
            annonce = objectMapper.readValue(s, Annonce.class);

            //close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        generateLogs(annonce);

    }

    /**
     * Which allows us to see the rules that weren't respected
     * @param annonce
     * @return list of rules
     */
    private static String[] reglesAnnonce(Annonce annonce) throws InterruptedException {
	    List<String> rules = new ArrayList<>();

        if (annonce.getContacts().getFirstName().length()<=2){
            rules.add("Firstname Rule Not respected");
        }
        if (annonce.getContacts().getLastName().length()<=2){
            rules.add("Lastname Rule Not respected");
        }
        if(blacklistService(annonce.getVehicle().getRegisterNumber())){
            rules.add("Immatriculation blacklistée");
        }

	    return rules.toArray((new String[rules.size()]));
    }

    private static Long quotationServer(Annonce annonce) throws InterruptedException {
        Thread.sleep(50);
        return annonce.getPrice();
    }

    private static Boolean blacklistService(String registerNumber) throws InterruptedException {
        Thread.sleep(50);
        return Objects.equals(registerNumber, "AA123AA");
    }

    private static void generateLogs(Annonce annonce) throws InterruptedException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String[] retour = reglesAnnonce(annonce);
        Loggerr loggerr = new Loggerr().builder().rules(retour).reference(annonce.getReference()).build();
        ObjectMapper loggerObject = new ObjectMapper();

        if ((retour.length > 0)) {
            loggerr.setScam(true);
        } else {
            loggerr.setScam(false);
        }
        // If you want to generate logs file
        //loggerObject.writeValue(new File("loggerr.json"), loggerr);
        String loggerAsString = objectMapper.writeValueAsString(loggerr);

        System.out.println(loggerAsString);
    }

}
