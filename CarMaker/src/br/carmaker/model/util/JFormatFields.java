/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author felipe
 */
public class JFormatFields {

    private static final String MONEY = "#,###,###.00";

    public static DefaultFormatterFactory getMoneyFormat() {
        DecimalFormat decimal = new DecimalFormat(MONEY);
        NumberFormatter numFormatter = new NumberFormatter(decimal);
        numFormatter.setFormat(decimal);
        numFormatter.setAllowsInvalid(false);
        return new DefaultFormatterFactory(numFormatter);
    }
    
    public static MaskFormatter getPhoneFormat(){
        MaskFormatter maskFormat = new MaskFormatter();
        String mask = "(##) #####-####";

        try{
            maskFormat.setMask(mask);
            maskFormat.setPlaceholderCharacter(' ');
            
            return maskFormat;
        }catch(ParseException ex){
        }
        return null;
    }
}
