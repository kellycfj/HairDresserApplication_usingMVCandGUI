/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ClientAndHairdresserMakeBookingController;
import controller.ReviewPageController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Kelly
 */
public class ClientAndHairdresserMakeBookingModel {   
    // link to the database
    private String dbServer = "jdbc:mysql://apontejaj.com:3306/Ingrid_2019411?useSSL=false";
    // user to query DB to insert, delete and update
    private String user = "Ingrid_2019411";
    private String password = "2019411";
    
    public ClientAndHairdresserMakeBookingModel() {
        
    }
     
    // create an user in the database, return a string null if there are no error, otherwise return
    // the message from database
    public Boolean bookingClient(BookAppointment booking) {
        
        //java.sql.Date date = java.sql.Date.valueOf(booking.getDate());
        //java.sql.Time time = java.sql.Time.valueOf(booking.getTime());
        
        String sql = "INSERT INTO bookingAppointment (location, service, day, month, year, time, first_name, phone_number) "
                     + "VALUES ('" + booking.getNearByLocation() + "','" + booking.getlService() 
                     + "','" + booking.getDay() + "','" + booking.getMonth() + "','" + booking.getYear() + "','" + booking.getTime()+ "','" + booking.getClientFirstName()
                     + "','" + booking.getClientPhoneNumber()+ "')";
        
      
        Boolean result = false;
        
        try {
                    
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);
            
            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            int i = stmt.executeUpdate(sql);
                       
            if(i > 0)
            {
                result = true;
            }
            // Close the result set, statement and the connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return result;
        } 
        
    }
    
}
       
        
class booking1 { 
  
    public static void main(String[] args) throws Exception 
    { 
        ClientAndHairdresserMakeBookingController booking = new ClientAndHairdresserMakeBookingController(); 
    }
}
