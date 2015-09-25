package CalorieCounter.Java;

/**
 * Created by Philip on 9/25/2015.
 */
public class UrlHandler {
    private static final String API_KEY = "dSfyYD6mmXK7hybh0Vvoj6VGrH28ZTVrscMvuOE2";

    HttpHandler httpHandler = new HttpHandler();
    String jsonResult;

    public String search(String term){
        try {
            jsonResult= httpHandler.sendGet("http://api.nal.usda.gov/ndb/search/?format=json&q="+term+"&sort=n&max=25&offset=0&api_key="+API_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
}
