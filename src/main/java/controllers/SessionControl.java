package controllers;

/* Developer: Philip Churchill
** Date: 2015.11.5
** Configuration Version: 1.0.0
*/

/**
 * This is the interface that provides a reference to the current session the
 * user is logged into. The controllers that implement this interface will be
 * able to access the current session's data.
 */


public interface SessionControl {
    void setSessionManager(SessionManager sessionManager);
}
