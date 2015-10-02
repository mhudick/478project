package CalorieCounter.Java.Model.WebObjects;

/**
 * Created by Philip on 9/25/2015.
 */
public class SearchResponseItem {
    private String ndbno;
    private String name;
    private String foodGroup;

    public String getNdbno() {
        return ndbno;
    }

    public void setNdbno(String ndbno) {
        this.ndbno = ndbno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(String foodGroup) {
        this.foodGroup = foodGroup;
    }

    @Override
    public String toString(){
        return "NDB no: "+getNdbno()+"\nName: "+getName()+"\nFood Group: "+getFoodGroup();
    }
}
