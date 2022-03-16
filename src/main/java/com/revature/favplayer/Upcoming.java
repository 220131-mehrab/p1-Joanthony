package com.revature.favplayer;

public class Upcoming {
    private Integer eventID;
    private String city;
    private String state;
    private String eventDate;

    public Upcoming (int eventID, String city, String state, String eventDate) {
        this.eventID = eventID;
        this.city = city;
        this.state = state;
        this.eventDate = eventDate;
    }
    public Integer getEventID(){
        return eventID;
    }
    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate ) {
        this.eventDate = eventDate;}

    @Override
    public String toString() {
        return "Upcoming [Event ID=" + eventID + ", City =" + city + ", State=" + state + ", Event Date=" + eventDate + "]";
    }
}
