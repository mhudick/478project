/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

public enum Screen {

    CREATE_USER("/views/create_user.fxml"),
    HOME("/views/home.fxml"),
    USER_LOG_IN("/views/user_log_in.fxml");

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
