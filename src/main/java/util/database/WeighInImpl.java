package util.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.WeighIn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Phil on 11/24/2015.
 */
public class WeighInImpl implements WeighInData{


    @Override
    public boolean saveNewWeighIn(int userId, int weight, String date) {
        String sql = "INSERT INTO weigh_in(userId, weight, date) VALUES("+userId+","+weight+",\'"+date+"\');";
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Save weigh in failed.");
            return false;
        }
        System.out.println("Save weigh in complete.");
        return true;
    }

    @Override
    public boolean deleteWeighIn(int weighId) {
        String sql = "DELETE FROM weigh_in WHERE weighId = "+weighId+";";
        try {
            DatabaseManager.executeStatment(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

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
