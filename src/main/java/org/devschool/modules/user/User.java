package org.devschool.modules.user;

public class User {

    private String name;

    private String description;

    private int IQ;

    public User(String name, String description, int IQ) {
        this.name = name;
        this.description = description;
        this.IQ = IQ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }
}
