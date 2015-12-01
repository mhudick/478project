package util.web;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This class implements the interface for the WebAccess Class. The main
 * functionality of this class is meant to query the USDA database and
 * return the search results a POJOs(Plain ol java objects). This is done
 * using Gson, which takes in the json result and converts it into a
 * POJOs.
 */

import models.Food;
import models.SearchItem;
import models.SearchResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class WebAccessImpl implements WebAccess{
    //API Key as constant
    private static final String API_KEY = "dSfyYD6mmXK7hybh0Vvoj6VGrH28ZTVrscMvuOE2";

    //This methods handles searching for the foods it returns the Search response as an object.
    @Override
    public HashMap<String,String> searchForFood(String term) {
        term = term.replaceAll(" ","+");
        HashMap<String,String> itemMap = new HashMap<>();
        System.out.println(term);
        String jsonResult = null;
        try {
            //This is where the url gets sent with the parameters to search for. It comes back as a Json string
            jsonResult = sendGet("http://api.nal.usda.gov/ndb/search/?format=json&q=" + term + "&sort=r&max=40&offset=0&api_key=" + API_KEY);
        } catch (Exception e) {
            System.out.println("Could not find file");
            itemMap.put("Please be more specific with you search.","");
            return itemMap;
        }
        Gson gson = new Gson();//This object handles converting Json to POJOs.
        JsonObject jsonObject = gson.fromJson(jsonResult,JsonObject.class);//JsonObject is easier to create the object with
        System.out.println(jsonObject.toString());
        SearchResponse searchResponse = gson.fromJson(jsonObject.get("list"),SearchResponse.class);//This is where the jsonObject gets converted to the SearchResponse and returned.

        Iterator<SearchItem> iterator = searchResponse.getItem().iterator();
        while (iterator.hasNext()){
            SearchItem searchItem = iterator.next();
            System.out.println(searchItem.getName() + " " + searchItem.getNdbno());
            itemMap.put(searchItem.getName(),searchItem.getNdbno());
        }
        return itemMap;
    }

    //This is the method used to retrieve a Food object from the webserver.
    @Override
    public Food getFood(String ndbno){
        String jsonResult = null;
        try {
            jsonResult = sendGet("http://api.nal.usda.gov/ndb/reports/?ndbno="+ndbno+"&type=f&format=json&api_key=" + API_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResult,JsonObject.class);
        jsonObject = gson.fromJson(jsonObject.get("report"),JsonObject.class);//Get ride of outer data that we do not need.
        Food food = gson.fromJson(jsonObject.get("food"), Food.class);//Converts JsonObject to Food object
        food.setkCalFromList();
        return food;
    }

    //This is a private method that the other methods call once the url is created. It returns the response as a string to the methods above.
    private String sendGet(String url) throws Exception {
        System.out.println("Starting http");
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine+"\n");
        }
        in.close();
        //return result
        return response.toString();
    }
}
