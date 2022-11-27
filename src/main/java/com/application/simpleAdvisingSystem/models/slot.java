package com.application.simpleAdvisingSystem.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class slot {

    @Id
    private String slotID;
    private String slotTime;
    private int remainingSeat;


    public slot(){

    }

    public slot(String slotID, String slotTime, int remainingSeat) {
        this.slotID = slotID;
        this.slotTime = slotTime;
        this.remainingSeat = remainingSeat;
    }


    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public int getRemainingSeat() {
        return remainingSeat;
    }

    public void setRemainingSeat(int remainingSeat) {
        this.remainingSeat = remainingSeat;
    }
}
