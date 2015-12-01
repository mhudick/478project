package controllers;

/* Developer: Philip Churchill
** Date: 2015.10.09
** Configuration Version: 1.0.0
*/

/**
 * This is the interface for the HomeScreen. The classes that implement this interface
 * will provide a reference to the homeScreen to allow for passing of data, and other
 * user activities.
 */

public interface HomeControl {
    void setHomeScreen(HomeScreen homeScreen);
}
