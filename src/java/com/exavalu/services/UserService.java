/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class UserService {
    
    public static UserService userService = null;
    
    private UserService(){}
    
    public static UserService getInstance()
    {
        if(userService==null)
        {
            return new UserService();
        }
        else
        {
            return userService;
        }
    }
    
    public  boolean doSignUp(User emp) {
        boolean success=false;
        
        Connection con=JDBCConnectionManager.getConnection();
         String sql = "INSERT INTO employeedb.users (emailAddress, password, firstName, lastName, status,countryId,stateId,districtId) VALUES (?, ?, ?, ?, ?,?,?,?);";

        try {
            //System.out.println("entering try block");
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getEmail());
            preparedStatement.setString(2, emp.getPassword());
            preparedStatement.setString(3, emp.getFirstName());
            preparedStatement.setString(4, emp.getLastName());
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, emp.getCountryId());
            preparedStatement.setInt(7, emp.getStateId());
            preparedStatement.setInt(8, emp.getDistrictId());
            

            preparedStatement.executeUpdate();
             System.out.println("LoginService :: "+preparedStatement);

           
                success=true;
            
            //con.close();


        } catch (SQLException ex) {

            Logger log = Logger.getLogger(UserService.class.getName());

            if (ex.getErrorCode() == 1062) {
                log.error("The email Id is already registered with us. Please register with a different email");
            }
            ex.printStackTrace();
}


        return success;
}
}
    
    