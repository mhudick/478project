package controllers;

/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

/**
 * This is the interface used to insure that classes that implement this interface
 * maintain a reference to the AppManager Class. This will allow other classes to
 * pass data to and from the AppManager.
 */

public interface AppControl {
    void setAppManager(AppManager appManager);
}
