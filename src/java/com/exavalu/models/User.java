/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.EmployeeService;
import com.exavalu.services.LocationService;
import com.exavalu.services.LoginService;
import com.exavalu.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int status;
     private int countryId;
    private String countryName;
    private int stateId;
    private String stateName;
    private int districtId;
    private String districtName;
    private String phoneNumber;
    private String adaddressLine1;
    private String addressLine2;


    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doLogin(this);

        if (success) {
            System.out.println("returning Success from doLogin method");
            getSessionMap().put("Loggedin",this);
                   // ArrayList emplist=EmployeeService.getInstance().getAllEmployees();
        
            //getSessionMap().put("EmpList", emplist);
                    
                    result = "SUCCESS";
        } else {
            String errorMsg ="Either Email Address or Password is Wrong";
            sessionMap.put("ErrorMsg", errorMsg);
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(errorMsg);
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }
    public String doSignUp() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.getInstance().doSignUp(this);

        if (success) {
            System.out.println("returning Success from doSignUp method");
            result = "SUCCESS";
        } else {
          
            System.out.println("returning Failure from doSignUp method");
            
            
        }

        return result;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the countryId
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the countryId to set
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the stateId
     */
    public int getStateId() {
        return stateId;
    }

    /**
     * @param stateId the stateId to set
     */
    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    /**
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @return the districtId
     */
    public int getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId the districtId to set
     */
    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    /**
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the adaddressLine1
     */
    public String getAdaddressLine1() {
        return adaddressLine1;
    }

    /**
     * @param adaddressLine1 the adaddressLine1 to set
     */
    public void setAdaddressLine1(String adaddressLine1) {
        this.adaddressLine1 = adaddressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param addressLine2 the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the map
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }
    
public String doPreSignUp() throws Exception {
        String result = "FAILURE";
        ArrayList countryList = LocationService.getAllCountries();
           sessionMap.put("CountryList", countryList);
           sessionMap.put("User", this); 
           
           
         if(this.stateId!=0)
        {
//            ArrayList stateList =  LocationService. getAllStates(this.countryId);
            ArrayList districtList =  LocationService. getAllDistricts(this.stateId);
            sessionMap.put("DistrictList", districtList);
            sessionMap.put("User", this); 
//            sessionMap.put("StateList",stateList );
          result="DISTRICT";
             
        }             
         if(this.countryId !=0)
        {
            ArrayList stateList =  LocationService. getAllStates(this.countryId);
             sessionMap.put("StateList",stateList );
             sessionMap.put("User", this); 
          result="STATELIST";   
        }
         
        if ( this.countryId!=0 && this.stateId != 0 && this.districtId!=0) 
        {
            
            boolean success = UserService.getInstance().doSignUp(this);

        if (success) {
            System.out.println("returning Success from doSignUp method");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from doSignUp method");
        }
             
         }

        return result;
    }
    /**
     * @return the employeeId
     */
    
}
