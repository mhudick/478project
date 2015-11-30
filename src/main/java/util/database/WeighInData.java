package util.database;

import javafx.collections.ObservableList;
import models.WeighIn;

import java.util.List;

/**
 * Created by Phil on 11/24/2015.
 */
public interface WeighInData {
    boolean saveNewWeighIn(int userId, int weight, String date);
    boolean deleteWeighIn(int weighId);
    ObservableList<WeighIn> getListOfWeighIns(int userId);
}
