package models;

/* Developer: Philip Churchill
** Date: 2015.9.25
** Configuration Version: 1.0.0
*/

/**
 * This Class is the data model for the SearchResponse object. This object is used
 * to capture the data returned from the USDA database. It contains a list of the
 * SearchItems. This object is not saved to the local database.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchResponse {
    private String q,group, sort;
    private List<SearchItem> item = new ArrayList<>();

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<SearchItem> getItem() {
        return item;
    }

    public void setItem(List<SearchItem> item) {
        this.item = item;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Search Term: "+getQ()+"\nGroup: "+getGroup()+"\nSort: "+getSort()+"\nItems Returned:\n");
        Iterator<SearchItem> iterator = getItem().iterator();
        while(iterator.hasNext()){
            sb.append(iterator.next().toString()+"\n");
        }
        return sb.toString();
    }
}
