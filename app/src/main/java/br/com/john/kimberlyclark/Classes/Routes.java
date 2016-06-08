package br.com.john.kimberlyclark.Classes;

/**
 * Created by Jonathan on 18/05/16.
 */
public class Routes {
    String id;
    String date;
    String process;
    String system;
    String machine;
    String group;
    String status;

    public Routes(){

    }

    public Routes(String id, String date, String process, String machine, String system, String group, String status){
        this.id = id;
        this.date = date;
        this.process = process;
        this.machine = machine;
        this.system = system;
        this.group = group;
        this.status = status;
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

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStatus(){
        return status;

    }
    public void setStatus(String status){
        this.status = status;
    }
}
