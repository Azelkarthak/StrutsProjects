package com.exavalu.services;

import com.exavalu.models.Transcript;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author Lenovo
 */
public class JsonDataToDBService {

    public static boolean InsertJsonData(Transcript[] transcript) {

        boolean result = true;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO json (userId,id,title,completed) VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            for (Transcript data : transcript) {

                preparedStatement.setString(1, data.getUserId());
                preparedStatement.setString(2, data.getId());
                preparedStatement.setString(3, data.getTitle());
                preparedStatement.setString(4, data.getCompleted());
                //System.out.println("preparedstatement= " + preparedStatement);

                preparedStatement.executeUpdate();
            }

//            if (row == 1) {
//                result = true;
//            }
        } catch (SQLException ex) {
           Logger log = Logger.getLogger(EmployeeService.class.getName());
            log.error("Error Message:" +ex.getMessage());
        }

        return result;
    }

    public static boolean InsertJsonData(Transcript transcript) {

        boolean result = false;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO json (userId,id,title,body) VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, transcript.getUserId());
            preparedStatement.setString(2, transcript.getId());
            preparedStatement.setString(3, transcript.getTitle());
            preparedStatement.setString(4, transcript.getCompleted());
            System.out.println("preparedstatement= " + preparedStatement);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
          Logger log = Logger.getLogger(EmployeeService.class.getName());
            log.error("Error Message:" +ex.getMessage());
        }

        return result;
    }

}