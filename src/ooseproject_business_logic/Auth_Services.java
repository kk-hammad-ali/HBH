/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooseproject_business_logic;

import core.ConectionC;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ooseproject_model.User_Model;
import ooseproject_pages_views.Login_Screen;

/**
 *
 * @author KK
 */
public class Auth_Services implements Auth_Provider {

    private String datauname;
    private String datapass;
    private String datacnic;
    private String dataemail;
    private String datausername;
    private String dataUname;
    private final ConectionC connection = new ConectionC();

    @Override
    public User_Model login(String f_username, String f_password) {
        User_Model userModel = null;
        String query = "SELECT * FROM users WHERE username='" + f_username + "' && pass= '" + f_password + "'";
        try {
            ResultSet result = connection.result(query);
            while (result.next()) {
                datauname = result.getString("username");
                datapass = result.getString("pass");
                if (f_username.equals(datauname) && f_password.equals(datapass)) {
                    userModel = new User_Model(
                            result.getString("iduser"),
                            result.getString("f_name"),
                            result.getString("email"),
                            result.getString("username"),
                            result.getString("pass"),
                            result.getString("cnic")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userModel;
    }

    @Override
    public boolean userExist(String username) {
        String query = "SELECT username FROM users";
        try {
            ResultSet result = connection.result(query);
            while (result.next()) {
                datausername = result.getString("username");
                if (datausername.equals(username)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean cnicExist(String cnic) {
        String query = "SELECT cnic FROM users";
        try {
            ResultSet result = connection.result(query);
            while (result.next()) {
                datacnic = result.getString("cnic");
                if (datacnic.equals(cnic)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean emailExist(String email) {
        String query = "SELECT email FROM users";
        try {
            ResultSet result = connection.result(query);
            while (result.next()) {
                dataemail = result.getString("email");
                if (dataemail.equals(email)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    @Override
    public boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";

        Pattern pat = Pattern.compile(passwordRegex);
        if (password == null) {
            return false;
        }
        return pat.matcher(password).matches();
    }

    @Override
    public boolean isValidUsername(String username) {
        String regex = "^[a-z]\\w{8,29}$";
        Pattern p = Pattern.compile(regex);
        if (username == null) {
            return false;
        }
        Matcher m = p.matcher(username);
        return m.matches();
    }

    @Override
    public void signup(String email, String o_name, String cnic, String username, String password) {
        String query = "INSERT INTO users (email,f_name,cnic,username,pass)" + "VALUES ('" + email + "','" + o_name + "','" + cnic + "','" + username + "','" + password + "')";
        try {
            if (userExist(username) == true) {
                JOptionPane.showMessageDialog(null, "Username Exists");
            } else if (cnicExist(cnic) == true) {
                JOptionPane.showMessageDialog(null, "CNIC Exists");
            } else if (emailExist(email) == true) {
                JOptionPane.showMessageDialog(null, "Email Exists");
            } else {
                if (isValidEmail(email) == true) {
                    if (isValidUsername(username) == true) {
                        if (isValidPassword(password) == true) {
                            connection.insert(query);
                            JOptionPane.showMessageDialog(null, "You have Sucessfully created account!\nLogin Now");
                        } else {
                            JOptionPane.showMessageDialog(null, "Password must contains \n'A' & 'a' \n'@' & '1' \n'8-20' ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Username msut contains \n'a' \n'1' & '_' \n'8-20'");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Email must contains '@' & '.'");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void forgetPassword(String usern, String newPassword, String confirmPassword) {
        try {
            String query = "SELECT * FROM users";
            String query1 = "update users set pass = '" + newPassword + "' where username = '" + usern + "'";
            ResultSet result = connection.result(query);
            if (result.next()) {
                if (isValidPassword(newPassword) == true) {
                    if (newPassword.equals(confirmPassword)) {
                        connection.insert(query1);
                        JOptionPane.showMessageDialog(null, "Password Changed");
                    } else {
                        JOptionPane.showMessageDialog(null, "Password does not match");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password must contains \n'A' & 'a' \n'@' & '1' \n'8-20' ");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auth_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
