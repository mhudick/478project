package util.database;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This class implements the interface for the WeighInData Class. The main
 * functionality of this class is meant to save and retrieve information
 * on the database specifically for the WeighIn object.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.WeighIn;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeighInImpl implements WeighInData{

    /**
     *  Weigh-in objects can be saved to the database
     * (Requirement 4.1.0)
     */
    @Override
    public boolean saveNewWeighIn(int userId, int weight, String date) {
        String sql = "INSERT INTO weigh_in(userId, weight, date) VALUES("+userId+","+weight+",\'"+date+"\');";
        return DatabaseManager.executeStatement(sql);
    }

    /**
     *  Weigh-in objects can be deleted from the database
     * (Requirement 4.3.0)
     */
    @Override
    public boolean deleteWeighIn(int weighId) {
        String sql = "DELETE FROM weigh_in WHERE weighId = "+weighId+";";
        return DatabaseManager.executeStatement(sql);
    }

    /**
     *  Weigh-in objects can be retrieved from the database
     * (Requirement 4.2.0)
     */
    @Override
    public ObservableList<WeighIn> getListOfWeighIns(int userId) {
        String sql = "SELECT * FROM weigh_in WHERE userId = "+userId+";";
        ObservableList<WeighIn> weighInList = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = DatabaseManager.getResultSet(sql);
            resultSet.next();
            while(!resultSet.isAfterLast()){
                WeighIn weighIn = new WeighIn();
                weighIn.setUserId(resultSet.getInt("userId"));
                weighIn.setWeighId(resultSet.getInt("weighId"));
                weighIn.setDate(resultSet.getString("date"));
                weighIn.setWeight(resultSet.getDouble("weight"));
                weighInList.add(weighIn);
                resultSet.next();
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weighInList;
    }
}
