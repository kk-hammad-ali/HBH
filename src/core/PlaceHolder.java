/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

/**
 *
 * @author KK
 */
public class PlaceHolder {
        public void addPlaceHolder(JTextField textfeild){
        Font f = textfeild.getFont();
        f = f.deriveFont(Font.ITALIC);
        textfeild.setFont(f);
        textfeild.setForeground(new Color(1,215,194));
    }
    public void removePlaceHolder(JTextField textfeild){
        Font f = textfeild.getFont();
        f = f.deriveFont(Font.PLAIN|Font.BOLD);
        textfeild.setFont(f);
        textfeild.setForeground(Color.BLACK);
    }
}
