package br.com.john.kimberlyclark.AdpterLists;

/**
 * Created by Jonathan on 19/05/16.
 */
public class ItemListUploads {
    String id;
    String status;
    String details;

    public ItemListUploads(){

    }
    public ItemListUploads(String id, String status, String details){
        this.id = id;
        this.status = status;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
