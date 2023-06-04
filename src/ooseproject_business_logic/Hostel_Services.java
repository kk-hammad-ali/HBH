/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooseproject_business_logic;

import core.ConectionC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import ooseproject_model.Hostel_Model;

/**
 *
 * @author KK
 */

public class Hostel_Services implements Hostel_Provider {
    
    private String datacity;
    private String dataname;
    private final ConectionC connection = new ConectionC();

    @Override
    public ArrayList<Hostel_Model> getHostel(String type) {
        ArrayList<Hostel_Model> all = new ArrayList<>();
        String query = "SELECT * FROM hostel WHERE hostel_type='" + type + "'";
        Hostel_Model hostelModel;
        try {
            ResultSet result = connection.result(query);
            while (result.next()) {
                hostelModel = new Hostel_Model(
                        result.getInt("idhostel"),
                        result.getString("hostel_name"),
                        result.getString("hostel_address"),
                        result.getString("hostel_email"),
                        result.getInt("hostel_rooms"),
                        result.getInt("hostel_fee"),
                        result.getString("hostel_type"),
                        result.getString("mess"),
                        result.getString("small_url"),
                        result.getString("large_url")
                );
                all.add(hostelModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hostel_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }

    

    @Override
    public ArrayList<Hostel_Model> getHostelCity(String city) {
        ArrayList<Hostel_Model> allcity = new ArrayList<>();
        String query = "SELECT * FROM hostel WHERE hostel_address='" + city + "'";
        Hostel_Model hostelModel;
        try {
            ResultSet result = connection.result(query);
            while (result.next()) {
                datacity = result.getString("hostel_address");
                if (datacity == null ? city == null : datacity.equals(city)) {
                    hostelModel = new Hostel_Model(
                            result.getInt("idhostel"),
                            result.getString("hostel_name"),
                            result.getString("hostel_address"),
                            result.getString("hostel_email"),
                            result.getInt("hostel_rooms"),
                            result.getInt("hostel_fee"),
                            result.getString("hostel_type"),
                            result.getString("mess"),
                            result.getString("small_url"),
                            result.getString("large_url")
                    );
                    allcity.add(hostelModel);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hostel_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allcity;
    }

    @Override
    public Hostel_Model getOneHostel(String name) {
        Hostel_Model hostelModel = null;
        String query = "SELECT * FROM hostel WHERE hostel_name='" + name + "'";
        try {
            ResultSet result = connection.result(query);
            while (result.next()) {
                dataname = result.getString("hostel_name");
                if (dataname == null ? name == null : dataname.equals(name)) {
                    hostelModel = new Hostel_Model(
                            result.getInt("idhostel"),
                            result.getString("hostel_name"),
                            result.getString("hostel_address"),
                            result.getString("hostel_email"),
                            result.getInt("hostel_rooms"),
                            result.getInt("hostel_fee"),
                            result.getString("hostel_type"),
                            result.getString("mess"),
                            result.getString("small_url"),
                            result.getString("large_url")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hostel_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hostelModel;
    }

    @Override
    public void setValues(ArrayList<Hostel_Model> values, JLabel j1, JLabel j2, JLabel j3, JLabel j4, JLabel j5, JLabel j6, JButton b1, JButton b2, JButton b3, JButton b4, JButton b5, JButton b6) {
        for (int i = 0; i < 1; i++) {
            j1.setText(values.get(i).getHostel_name());
            j2.setText(values.get(i + 1).getHostel_name());
            j3.setText(values.get(i + 2).getHostel_name());
            j4.setText(values.get(i + 3).getHostel_name());
            j5.setText(values.get(i + 4).getHostel_name());
            j6.setText(values.get(i + 5).getHostel_name());
            b1.setIcon(new ImageIcon(values.get(i).getSmall_url()));
            b2.setIcon(new ImageIcon(values.get(i + 1).getSmall_url()));
            b3.setIcon(new ImageIcon(values.get(i + 2).getSmall_url()));
            b4.setIcon(new ImageIcon(values.get(i + 3).getSmall_url()));
            b5.setIcon(new ImageIcon(values.get(i + 4).getSmall_url()));
            b6.setIcon(new ImageIcon(values.get(i + 5).getSmall_url()));
        }
    }
}
