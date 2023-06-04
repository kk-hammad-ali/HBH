/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ooseproject_business_logic;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import ooseproject_model.Hostel_Model;

/**
 *
 * @author KK
 */
public interface Hostel_Provider {
    public ArrayList<Hostel_Model> getHostel(String type);
    public Hostel_Model getOneHostel(String name);
    public ArrayList<Hostel_Model> getHostelCity(String city);
    public void setValues (ArrayList<Hostel_Model> values, JLabel j1, JLabel j2, JLabel j3, JLabel j4, JLabel j5, JLabel j6, JButton b1, JButton b2, JButton b3, JButton b4, JButton b5, JButton b6);
}
