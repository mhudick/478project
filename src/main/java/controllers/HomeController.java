/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

public class HomeController implements ManagedScreen{

    private ScreenManager screenManager;

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
}
