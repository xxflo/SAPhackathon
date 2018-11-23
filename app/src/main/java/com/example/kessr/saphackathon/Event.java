package com.example.kessr.saphackathon;

import java.sql.Time;

public class Event {
    private String title;
    private Time start;
    private Time  end;
    private String type;



    private int currAttendee;
    private int maxAttendee;

    private String hostName;
    //private Image imageSrc;


    public Event(String title, Time start, Time end, String type, String hostName) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.type = type;
        this.hostName = hostName;
     //   this.imageSrc = imageSrc;
    }

    public void setHostName(String name){
        this.hostName = name;
    }

//    public void setImageSrc(Image imageSrc) {
//        this.imageSrc = imageSrc;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public String getHostName() {
        return hostName;
    }

    public int getCurrAttendee() {
        return currAttendee;
    }

    public void setCurrAttendee(int currAttendee) {
        this.currAttendee = currAttendee;
    }

    public int getMaxAttendee() {
        return maxAttendee;
    }

    public void setMaxAttendee(int maxAttendee) {
        this.maxAttendee = maxAttendee;
    }


}
