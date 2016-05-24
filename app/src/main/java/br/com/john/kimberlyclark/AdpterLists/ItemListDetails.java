package br.com.john.kimberlyclark.AdpterLists;

/**
 * Created by Jonathan on 24/05/16.
 */
public class ItemListDetails {
    String id;
    String activity;
    String date;
    String number;

    public ItemListDetails(){

    }

    public ItemListDetails(String id, String date, String activity, String number){
        this.id = id;
        this.date = date;
        this.activity = activity;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
