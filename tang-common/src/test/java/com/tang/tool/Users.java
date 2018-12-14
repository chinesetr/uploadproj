package com.tang.tool;

public class Users {

    private String name;
    private String id;
    private int sge;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getSge() {
        return sge;
    }
    public void setSge(int sge) {
        this.sge = sge;
    }
    public Users() {
	super();
    }
    public Users(String name, String id, int sge) {
	super();
	this.name = name;
	this.id = id;
	this.sge = sge;
    }
    
}
