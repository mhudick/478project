/* Developer: Mark Donile
** Date: 2015.10.18
** Configuration Version: 1.0.0
*/

package controllers;

public enum Screen {
    HOME("Home"),
    FOODS("Foods"),
    RECIPES("Recipes"),
    DAILY_TRACKER("Daily Tracker"),
    EXERCISE("Exercise"),
    WEIGH_IN("Weigh-in"),
    CHANGE_USER("Change User");

    private String name;

    private Screen(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
