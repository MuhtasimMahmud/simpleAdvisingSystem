package com.application.simpleAdvisingSystem.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class slot {

    @Id
    private String slotID;
    private String slotTime;
    private int totalRemainingSeat;


    public slot(){

    }

    public slot(String slotID, String slotTime, int totalRemainingSeat) {
        this.slotID = slotID;
        this.slotTime = slotTime;
        this.totalRemainingSeat = totalRemainingSeat;
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

    public int getTotalRemainingSeat() {
        return totalRemainingSeat;
    }

    public void setTotalRemainingSeat(int totalSeat) {
        this.totalRemainingSeat = totalSeat;
    }
}
