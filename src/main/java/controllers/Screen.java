/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

public enum Screen {

    HOME("/views/home.fxml");

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
