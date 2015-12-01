package util.web;

/* Developer: Philip Churchill
** Date: 2015.10.18
** Configuration Version: 1.0.0
*/

/**
 * This interface provides a clear was to insure that the necessary methods are implement
 * for the WebAccessImpl Class.
 */

import models.Food;
import java.util.HashMap;

public interface WebAccess {
    HashMap<String,String> searchForFood(String term);
    Food getFood(String ndbno);
}
