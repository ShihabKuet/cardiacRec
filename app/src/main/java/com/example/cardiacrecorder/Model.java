package com.example.cardiacrecorder;

public class Model {
    private int id;
    private String date;
    private String time;
    private int systolic;
    private int diastolic;
    private int pulse;
    private String extrimity;
    private String position;
    private String comment;
    private String verdict;

    public Model(int id, String date, String time, int systolic, int diastolic, int pulse, String extrimity, String position, String comment, String verdict) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pulse = pulse;
        this.extrimity = extrimity;
        this.position = position;
        this.comment = comment;
        this.verdict = verdict;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public int getPulse() {
        return pulse;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getSystolic() {
        return systolic;
    }


    public String getExtrimity() {
        return extrimity;
    }

    public void setExtrimity(String extrimity) {
        this.extrimity = extrimity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }
}
