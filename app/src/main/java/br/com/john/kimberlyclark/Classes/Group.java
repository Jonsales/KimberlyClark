package br.com.john.kimberlyclark.Classes;

/**
 * Created by Jonathan on 07/06/16.
 */
public class Group {
    String id;
    String group;
    String cod;

    public Group(){

    }

    public Group(String id, String cod, String group) {
        this.id = id;
        this.cod = cod;
        this.group = group;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


}
