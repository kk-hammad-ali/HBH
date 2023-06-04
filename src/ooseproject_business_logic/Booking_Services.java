/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooseproject_business_logic;

import core.ConectionC;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import ooseproject_model.Booking_Model;
import ooseproject_pages_views.Booking_Screen;
import ooseproject_pages_views.Login_Screen;

/**
 *
 * @author KK
 */
public class Booking_Services implements Booking_Provider {
    Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
    
    
    private int dataid;
    private int datahosid;
    private final ConectionC connection = new ConectionC();
    
    
    @Override
    public void bookingDetails(int hosid, String hosname, String hosemail, int hosfee, int userid, String username, String useremail, String usercnic) {
        String query = "INSERT INTO booking (hid,hname,hemail,hfee,uid,uname,uemail,ucnic,date,time)" + "VALUES ('" + hosid + "','" + hosname + "', '" + hosemail + "', '" + hosfee + "','" + userid + "','" + username + "','" + useremail + "','" + usercnic + "','" + sqlDate + "','"+ sqlTime +"')";
        try {
            connection.insert(query);
        } catch (SQLException ex) {
            Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<Booking_Model> getallbooked(int userid) {
        ArrayList<Booking_Model> all = new ArrayList<>();
        String query = "SELECT * FROM booking WHERE uid='" + userid + "'";
        Booking_Model bookingModel;
        try {
            ResultSet result = connection.result(query);
                while (result.next()) {
                    dataid = result.getInt("uid");
                    if (userid == dataid) {
                        bookingModel = new Booking_Model(
                            Integer.parseInt(result.getString("idbooking")),
                            Integer.parseInt(result.getString("hid")),
                            result.getString("hname"),
                            result.getString("hemail"),
                            Integer.parseInt(result.getString("hfee")),
                            Integer.parseInt(result.getString("uid")),
                            result.getString("uname"),
                            result.getString("uemail"),
                            result.getString("ucnic"),
                            result.getString("date"),
                            result.getString("time")
                    );
                    all.add(bookingModel);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hostel_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    
    @Override
    public void deletebooking(String hostelname){
        String query = "DELETE FROM booking WHERE hname ='" + hostelname + "'";
        try {
            connection.insert(query);
        } catch (SQLException ex) {
            Logger.getLogger(Booking_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void getFee(int id, String type){
        String query = "SELCCT * FROM rooms_fees idrooms_fees='" + id + "'";
        try {
            ResultSet result = connection.result(query);
            while(result.next()){
                datahosid = result.getInt("idrooms_fees");
                if(datahosid == id){
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void setFee(int hosid , JLabel j, String type) {
        String query = "SELECT * FROM rooms_fees WHERE idrooms_fees='" + hosid + "'";
        try {
            ResultSet result = connection.result(query);
            while(result.next()){
                    String feeget = Integer.toString(result.getInt(type));
                    j.setText(feeget);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

