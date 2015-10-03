package CalorieCounter.Java.Controllers;

/**
 * Created by Philip on 9/24/2015.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServicer {
    //Key
    private static final String API_KEY = "dSfyYD6mmXK7hybh0Vvoj6VGrH28ZTVrscMvuOE2";

    public String search(String term) {
        String jsonResult = null;
        try {
            jsonResult = sendGet("http://api.nal.usda.gov/ndb/search/?format=json&q=" + term + "&sort=n&max=25&offset=0&api_key=" + API_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
    public String foodReport(String ndb){
        ndb = "01009";
        String jsonResult = null;
        try {
            jsonResult = sendGet("http://api.nal.usda.gov/ndb/reports/?ndbno="+ndb+"&type=f&format=json&api_key=" + API_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
    // HTTP GET request
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
