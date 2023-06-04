/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ooseproject_business_logic;

import java.util.ArrayList;
import javax.swing.JLabel;
import ooseproject_model.Booking_Model;

/**
 *
 * @author KK
 */
public interface Booking_Provider {
    public void bookingDetails(int hosid,String hosname, String hosemail, int hosfee,int userid ,String username , String useremail, String usercnic);
    public ArrayList<Booking_Model> getallbooked(int userid);
    public void setFee(int hosid, JLabel j, String type);
    public void deletebooking(String hostelname);
    public void getFee(int id, String type);
}
