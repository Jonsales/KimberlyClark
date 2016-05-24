package br.com.john.kimberlyclark.AdpterLists;

/**
 * Created by Jonathan on 19/05/16.
 */
public class ItemListHistoric {
    String id;
    String date;
    String historic;

    public ItemListHistoric(){

    }

    public ItemListHistoric(String id, String date, String historic){
        this.id = id;
        this.date = date;
        this.historic = historic;
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

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }
}
