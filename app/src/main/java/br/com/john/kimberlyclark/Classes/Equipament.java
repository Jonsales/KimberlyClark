package br.com.john.kimberlyclark.Classes;

/**
 * Created by Jonathan on 08/06/16.
 */
public class Equipament {
    String id;
    String codEquipament;
    String type;

    public Equipament(){

    }
    public Equipament(String id, String type, String codEquipament) {
        this.id = id;
        this.type = type;
        this.codEquipament = codEquipament;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodEquipament() {
        return codEquipament;
    }

    public void setCodEquipament(String codEquipament) {
        this.codEquipament = codEquipament;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
