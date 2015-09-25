package CalorieCounter.Java;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Philip on 9/24/2015.
 */
public class SearchResponse {
    /*A Search will return a list of items. This object holds information
    about the list and contains a LinkedList of the items as well.
     */
    private String searchTerm;//Search term used.
    private String foodGroup;//Food Group or Food Category
    private String sort;//Sorted as r=relevance or n=name
    private String standardRelease;//The current released version of NDB site.
    private int startIndex;
    private int endIndex;
    private int total;

    private LinkedList<FoodItem> itemList;//List of food items.

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(String foodGroup) {
        this.foodGroup = foodGroup;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStandardRelease() {
        return standardRelease;
    }

    public void setStandardRelease(String standardRelease) {
        this.standardRelease = standardRelease;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LinkedList getItemList(){
        return itemList;
    }

    public void addItem(FoodItem item){
        itemList.add(item);
    }
    //The first argument in this method will take three arguments "ndbno,name,foodGroup"
    public FoodItem getItem(String searchBy, String value){
        Iterator <FoodItem> iterator = itemList.iterator();

        while (iterator.hasNext()){
            FoodItem temp = iterator.next();
            switch (searchBy) {
                case "ndbno":
                    if (temp.getNdbno().equalsIgnoreCase(value)){
                        return temp;
                    }
                    break;
                case "name":
                    if (temp.getName().equalsIgnoreCase(value)){
                        return temp;
                    }
                    break;
                case "foodGroup":
                    if (temp.getFoodGroup().equalsIgnoreCase(value)){
                        return temp;
                    }
                    break;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
