/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.models;

import com.exavalu.services.LocationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author iamsu
 */
public class Location extends ActionSupport implements ApplicationAware, SessionAware, Serializable{

    private int countryId;
    private String countryName;
    private int stateId;
    private String stateName;
    private int districtId;
    private String districtName;

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


    /**
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
     public String getLocation() throws Exception {
        String result = "SUCCESS";
        ArrayList countryList = LocationService.getAllCountries();
           sessionMap.put("CountryList", countryList);  
           
           
         if(this.stateId!=0)
        {
            ArrayList stateList =  LocationService. getAllStates(this.countryId);
            ArrayList districtList =  LocationService. getAllDistricts(this.stateId);
            sessionMap.put("DistrictList", districtList);
            sessionMap.put("User", this); 
            sessionMap.put("StateList",stateList );
                result="STATELIST";

             
        }   
            
         if(this.countryId !=0)
        {
            ArrayList stateList =  LocationService. getAllStates(this.countryId);
             sessionMap.put("StateList",stateList );
             sessionMap.put("User", this); 
             result="STATELIST";
        }

        return result;
    }
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


}