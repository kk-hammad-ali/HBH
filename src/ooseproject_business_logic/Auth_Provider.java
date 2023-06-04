/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ooseproject_business_logic;

import ooseproject_model.User_Model;


/**
 *
 * @author KK
 */
public interface Auth_Provider {
    public User_Model login(String username , String Password);
    public void signup(String o_name , String email, String cnic , String password, String username);
    public boolean userExist(String username);
    public boolean cnicExist(String cnic);
    public boolean emailExist(String email);
    public void forgetPassword(String usern, String newPassword, String confirmPassword);
    public boolean isValidEmail(String email);
    public boolean isValidPassword(String password);
    public boolean isValidUsername(String username);
}
