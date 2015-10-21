package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Philip on 10/6/2015.
 */
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
