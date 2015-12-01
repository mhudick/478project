package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This interface provides an easy to insure that the implementing class
 * provides the necessary methods.
 */

import javafx.collections.ObservableList;
import models.WeighIn;

public interface WeighInData {
    boolean saveNewWeighIn(int userId, int weight, String date);
    boolean deleteWeighIn(int weighId);
    ObservableList<WeighIn> getListOfWeighIns(int userId);
}
