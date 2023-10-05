package com.example.eventmanagement;

public class Event {
    private String eId;
    private String selectedServices;
    private String uid;
    private String eventName;
    private String numberOfGuests;
    private String entryDate;
    private String exitDate;
    private String vId;


    public Event(String eId, String selectedServices, String uid, String eventName, String numberOfGuests, String entryDate, String exitDate, String vId) {
        this.eId = eId;
        this.selectedServices = selectedServices;
        this.uid = uid;
        this.eventName = eventName;
        this.numberOfGuests = numberOfGuests;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.vId = vId;
    }

    public String geteId() {
        return eId;
    }

    public String getSelectedServices() {
        return selectedServices;
    }

    public String getUid() {
        return uid;
    }

    public String getEventName() {
        return eventName;
    }

    public String getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public String getvId() {
        return vId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public void setSelectedServices(String selectedServices) {
        this.selectedServices = selectedServices;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setNumberOfGuests(String numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }
}

