/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooseproject_model;

/**
 *
 * @author KK
 */
public class Hostel_Model {
    private int hostel_id;

    private String hostel_name;
    private String hostel_address;
    private String hostel_email;
    private int hostel_total_rooms;
    private int hostel_fees;
    private String hostel_type;
    private String isMess;
    private String small_url;
    private String big_url;

    public Hostel_Model(){
        
    }
    public Hostel_Model(int hostel_id, String hostel_name, String hostel_address, String hostel_email, int hostel_total_rooms, int hostel_fees, String hostel_type,String isMess, String smallurl, String bigurl) {
        this.hostel_id = hostel_id;
        this.hostel_name = hostel_name;
        this.hostel_address = hostel_address;
        this.hostel_email = hostel_email;
        this.hostel_total_rooms = hostel_total_rooms;
        this.hostel_fees = hostel_fees;
        this.hostel_type = hostel_type;
        this.isMess = isMess;
        this.small_url = smallurl;
        this.big_url = bigurl;
    }
    public String getHostel_type() {
        return hostel_type;
    }

    public void setHostel_type(String hostel_type) {
        this.hostel_type = hostel_type;
    }
    
    public int getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(int hostel_id) {
        this.hostel_id = hostel_id;
    }

    public String getHostel_name() {
        return hostel_name;
    }

    public void setHostel_name(String hostel_name) {
        this.hostel_name = hostel_name;
    }

    public String getHostel_address() {
        return hostel_address;
    }

    public void setHostel_address(String hostel_address) {
        this.hostel_address = hostel_address;
    }

    public String getHostel_email() {
        return hostel_email;
    }

    public void setHostel_email(String hostel_email) {
        this.hostel_email = hostel_email;
    }
    public int getHostel_total_rooms() {
        return hostel_total_rooms;
    }

    public void setHostel_total_rooms(int hostel_total_rooms) {
        this.hostel_total_rooms = hostel_total_rooms;
    }

    public int getHostel_fees() {
        return hostel_fees;
    }

    public void setHostel_fees(int hostel_fees) {
        this.hostel_fees = hostel_fees;
    }

    public String getSmall_url() {
        return small_url;
    }

    public void setSmall_url(String small_url) {
        this.small_url = small_url;
    }

    public String getBig_url() {
        return big_url;
    }

    public void setBig_url(String big_url) {
        this.big_url = big_url;
    }
    
    public String getIsMess() {
        return isMess;
    }

    public void setIsMess(String isMess) {
        this.isMess = isMess;
    }
    
}