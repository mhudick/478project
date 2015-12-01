package models;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This Class is the data model for the SearchItem object. The initial query
 * of the USDA database returns a list of possible foods. The SearchItem
 * represents a single item in that list. This object is not saved to the
 * local database.
 */

public class SearchItem {
    private String ndbno;
    private String name;
    private String group;

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString(){
        return "NDB no: "+getNdbno()+"\nName: "+getName()+"\nFood Group: "+getGroup();
    }
}
