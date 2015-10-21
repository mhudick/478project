package util.web;

import models.Food;
import models.SearchItem;

import java.util.List;

/**
 * Created by Philip on 10/18/2015.
 */
public interface WebAccess {
    List<SearchItem> searchForFood(String term);
    Food getFood(String ndbno);
}
