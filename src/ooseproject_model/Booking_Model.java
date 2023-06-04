/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooseproject_model;

/**
 *
 * @author KK
 */
public class Booking_Model {
    private int id;
    private int userid;
    private String username;
    private String useremail;
    private String usercnic;
    private int hosid;
    private String hosname;
    private String hosemail;
    private int hosfee;

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
    private String date;
    private String time;

    public Booking_Model(int id,int hosid, String hosname, String hosemail, int hosfee, int userid, String username, String useremail, String usercnic, String date, String time) {
        this.id = id;
        this.hosid = hosid;
        this.hosname = hosname;
        this.hosemail = hosemail;
        this.hosfee = hosfee;
        this.userid = userid;
        this.username = username;
        this.useremail = useremail;
        this.usercnic = usercnic;
        this.date = date;
        this.time = time;
    }

    public Booking_Model() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsercnic() {
        return usercnic;
    }

    public void setUsercnic(String usercnic) {
        this.usercnic = usercnic;
    }

    public int getHosid() {
        return hosid;
    }

    public void setHosid(int hosid) {
        this.hosid = hosid;
    }

    public String getHosname() {
        return hosname;
    }

    public void setHosname(String hosname) {
        this.hosname = hosname;
    }

    public String getHosemail() {
        return hosemail;
    }

    public void setHosemail(String hosemail) {
        this.hosemail = hosemail;
    }

    public int getHosfee() {
        return hosfee;
    }

    public void setHosfee(int hosfee) {
        this.hosfee = hosfee;
    }
}
