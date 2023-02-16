/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.services;

import com.exavalu.models.Country;
import com.exavalu.models.District;
import com.exavalu.models.State;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author iamsu
 */
public class LocationService {
    public static ArrayList getAllCountries() {

        ArrayList countryList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Select * from countries";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Country country = new Country();
                
                country.setCountryId(rs.getInt("countryId"));
                country.setCountryName(rs.getString("countryName"));
                
                countryList.add(country);
                
            }

        } catch (SQLException ex) {
          Logger log = Logger.getLogger(EmployeeService.class.getName());
            log.error("Error Message:" +ex.getMessage());
        }

        return countryList;
    
    }
     public static ArrayList getAllStates(int countryId) {

        ArrayList stateList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();
            

            String sql = "Select * from states where countryId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,countryId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                State state = new State();
                
                state.setCountryId(rs.getInt("countryId"));
                state.setStateId(rs.getInt("stateId"));
                state.setStateName(rs.getString("stateName"));
                
                stateList.add(state);
                
            }

        } catch (SQLException ex) {
           Logger log = Logger.getLogger(EmployeeService.class.getName());
            log.error("Error Message:" +ex.getMessage());
        }

        return stateList;
    
    }
      public static ArrayList getAllDistricts(int stateId) {

        ArrayList districtList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Select * from districts where stateId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,stateId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                District district = new District();
                
                district.setDistrictId(rs.getInt("districtId"));
                district.setStateId(rs.getInt("stateId"));
                district.setDistrictName(rs.getString("districtName"));
                
                districtList.add(district);
                
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(EmployeeService.class.getName());
            log.error("Error Message:" +ex.getMessage());
        }

        return districtList;
    
    }
    
    
}