package models;

/**
 * Created by Philip on 9/25/2015.
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
