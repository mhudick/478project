package util.web;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import models.Food;
import models.SearchItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Philip on 10/18/2015.
 */
public interface WebAccess {
    ObservableList<String> searchForFood(String term);
    Food getFood(String ndbno);
}
