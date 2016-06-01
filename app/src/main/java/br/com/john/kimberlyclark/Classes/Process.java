package br.com.john.kimberlyclark.Classes;

/**
 * Created by Jonathan on 18/05/16.
 */
public class Process {
    String id;
    String date;
    String process;
    String system;
    String machine;
    String group;

    public Process(){

    }

    public Process(String id, String date, String process, String machine, String system, String group){
        this.id = id;
        this.date = date;
        this.process = process;
        this.machine = machine;
        this.system = system;
        this.group = group;
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
}
