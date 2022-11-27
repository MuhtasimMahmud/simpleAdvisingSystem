package com.application.simpleAdvisingSystem.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class slotRegisteredStudents {

    @Id
    private String SID;
    private String fName;
    private String lName;
    private String email;
    private String slot;

    public slotRegisteredStudents(){

    }

    public slotRegisteredStudents(String SID, String fName, String lName, String email, String slot) {
        this.SID = SID;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.slot = slot;
    }


    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
