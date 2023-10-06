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


    private String status;

    private String venueName;
    private String username;


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
    public Event(String eventName, String numberOfGuests, String entryDate, String exitDate, String selectedServices,String venueName, String username){
        this.eventName= eventName;
        this.numberOfGuests = numberOfGuests;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.selectedServices = selectedServices;
        this.venueName = venueName;
        this.username = username;
    }
    public Event(String eId, String selectedServices, String uid, String eventName, String numberOfGuests, String entryDate, String exitDate, String vId, String status) {
        this.eId = eId;
        this.selectedServices = selectedServices;
        this.uid = uid;
        this.eventName = eventName;
        this.numberOfGuests = numberOfGuests;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.vId = vId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getVenueName() {
        return venueName;
    }

    public String getUsername() {
        return username;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

