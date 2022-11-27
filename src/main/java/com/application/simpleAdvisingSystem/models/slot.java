package com.application.simpleAdvisingSystem.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class slot {

    @Id
    private String slotID;
    private String slotTime;
    private int totalSeat;


    public slot(){

    }

    public slot(String slotID, String slotTime, int totalSeat) {
        this.slotID = slotID;
        this.slotTime = slotTime;
        this.totalSeat = totalSeat;
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

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }
}
