/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.controller;

import br.carmaker.model.connection.ConnectionFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author rafam
 */
public class relatorio {
    
public static void geraRelatorioRecebidos(String start_date, String end_date) throws JRException, SQLException {
        
        Map<String, Object> map;
        map = new HashMap<>();
        
        map.put("start_date", start_date);
        map.put("end_date", end_date);
        
        Connection connection = ConnectionFactory.getConnection();
        
        JasperReport report = JasperCompileManager.compileReport("src/Relatorio/relatorioRecebidos.jrxml");
        
        JasperPrint print = JasperFillManager.fillReport(report, map, connection);
        
        JasperExportManager.exportReportToPdfFile(print,
                "C:/pdf/pdf.pdf");
    
        System.out.println("Relatorio Criado!");
        
    }

public static void geraRelatorioRealizados(String start_date, String end_date) throws JRException, SQLException {
        
        Map<String, Object> map;
        map = new HashMap<>();
        
        map.put("start_date", start_date);
        map.put("end_date", end_date);
        
        Connection connection = ConnectionFactory.getConnection();
        
        JasperReport report = JasperCompileManager.compileReport("src/Relatorio/relatorioRealizados.jrxml");
        
        JasperPrint print = JasperFillManager.fillReport(report, map, connection);
        
        JasperExportManager.exportReportToPdfFile(print,
                "C:/pdf/pdf.pdf");
    
        System.out.println("Relatorio Criado!");
        
    }
        
    public static void Email(String email) {
        SMTPAuthenticator smtp = new SMTPAuthenticator();
        smtp.getPasswordAuthentication();
        ArrayList<String> lista = new ArrayList<>();
        lista.add(email);
        sendAttachEmail(lista, "Email", "Estou lhe enviando este email via java com anexo", "C:/pdf/pdf.pdf");
    }
    
    public static void sendAttachEmail(List<String> to, String subject, String body, String attach)
    {
            Properties p = getProps();
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(p, auth);
            MimeMessage msg = new MimeMessage(session);
            MimeBodyPart mbp = new MimeBodyPart();
            try
            {
                    // "de" e "para"!!
                    msg.setFrom(new InternetAddress("carmaker.ec206@gmail.com"));
                    InternetAddress [] emails = new InternetAddress[to.size()];
                    int i = 0;
                    for (Iterator iterator = to.iterator(); iterator.hasNext();) 
                    {
                            String toAddr = (String) iterator.next();
                            emails[i] = new InternetAddress(toAddr);
                            i++;
                    }
                    msg.setRecipients(Message.RecipientType.TO, emails);
                    msg.setSentDate(new Date());
                    msg.setSubject(subject);
                    msg.setText(body);
                    //enviando anexo
                    DataSource fds = new FileDataSource(attach);
                    mbp.setDisposition(Part.ATTACHMENT);
                    mbp.setDataHandler(new DataHandler(fds));
                    mbp.setFileName(fds.getName());
                    Multipart mp = new MimeMultipart();   
                    mp.addBodyPart(mbp);
                    msg.setContent(mp);
                    // enviando mensagem
                    Transport.send(msg);
            } 
            catch (AddressException e) 
            {
                    e.printStackTrace();
            } 
            catch (MessagingException e) 
            {
                    e.printStackTrace();
            }
            System.out.println("Enviado com sucesso!");
    }
    private static Properties getProps() 
    {
            Properties p = new Properties();		
            p.put("mail.transport.protocol", "smtp");
            p.put("mail.smtp.starttls.enable","true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.auth", "true");
            return p;
    }
}
class SMTPAuthenticator extends javax.mail.Authenticator 
{
        @Override
	public PasswordAuthentication getPasswordAuthentication() 
        {
            return new PasswordAuthentication ("carmaker.ec206@gmail.com", "carmaker123");
	}
}

