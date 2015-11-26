/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

public enum Screen {

    CREATE_USER("/views/app_user_create_screen.fxml"),
    HOME("/views/home_screen.fxml"),
    FOODS("/views/food_screen.fxml"),
    USER_LOG_IN("/views/app_login_screen.fxml"),
    USER_SUMMARY("/views/summary_screen.fxml");

    private String resourcePath;

    //constructor
    Screen(String resourcePath){
        this.resourcePath = resourcePath;
    }

    //methods
    public String getResourcePath(){
        return resourcePath;
    }

}
