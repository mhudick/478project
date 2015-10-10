package CalorieCounter.Java.Controllers;

/**
 * Created by Philip on 9/24/2015.
 */

import CalorieCounter.Java.Model.Food;
import CalorieCounter.Java.Model.SearchResponse;
import CalorieCounter.Java.Model.SearchResponseItem;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WebManager {
    //API Key as constant
    private static final String API_KEY = "dSfyYD6mmXK7hybh0Vvoj6VGrH28ZTVrscMvuOE2";

    //This methods handles searching for the foods it returns the Search response as an object.
    public SearchResponse webSearchFoods(String term) {
        String jsonResult = null;
        try {
            //This is where the url gets sent with the parameters to search for. It comes back as a Json string
            jsonResult = sendGet("http://api.nal.usda.gov/ndb/search/?format=json&q=" + term + "&sort=n&max=25&offset=0&api_key=" + API_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();//This object handles converting Json to POJOs.
        JsonObject jsonObject = gson.fromJson(jsonResult,JsonObject.class);//JsonObject is easier to create the object with
        System.out.println(jsonObject.toString());
        SearchResponse searchResponse = gson.fromJson(jsonObject.get("list"),SearchResponse.class);//This is where the jsonObject gets converted to the SearchResponse and returned.
        return searchResponse;
    }
    //This is the method used to retrieve a Food object from the webserver.
    public Food webFoodDetails(String ndbno){
        String jsonResult = null;
        try {
            jsonResult = sendGet("http://api.nal.usda.gov/ndb/reports/?ndbno="+ndbno+"&type=f&format=json&api_key=" + API_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResult,JsonObject.class);
        jsonObject = gson.fromJson(jsonObject.get("report"),JsonObject.class);//Get ride of outer data that we do not need.
        Food food = gson.fromJson(jsonObject.get("food"),Food.class);//Converts JsonObject to Food object
        System.out.println(jsonObject.toString());
        return food;//Returns Food Object
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
