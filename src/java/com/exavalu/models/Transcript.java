package com.exavalu.models;

import com.exavalu.services.JsonDataToDBService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class Transcript extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();
    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;

    }

    public String doFetchUrl() throws Exception {
        String result = "FAILURE";
        boolean dataEntry = false;

        if (this.url != null) {

            HttpRequest postRequest = HttpRequest.newBuilder().uri(new URI(this.url)).build();

            //creating client object to send request
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
            //to get body of response
            // System.out.println(postResponse.body());
            String textArea = postResponse.body();
            sessionMap.put("TextArea", textArea);

            Gson gson = new Gson();
            if ("1".equals(this.sizeOfData)) {
                Transcript transcript = gson.fromJson(postResponse.body(), Transcript.class);
                dataEntry = JsonDataToDBService.InsertJsonData(transcript);
            }
            
            if (!"1".equals(this.sizeOfData) && !"0".equals(this.sizeOfData)) {
                Transcript[] transcript = gson.fromJson(postResponse.body(), Transcript[].class);
                JsonDataToDBService.InsertJsonData(transcript);
            
            }
            // String jsonString = gson.toJson(transcript);
            // System.out.println("printing jsonString ="+jsonString);

//            dataEntry = JsonDataToDBService.InsertJsonData(transcript);
//            System.out.println("dataEntrySuccessful = " + dataEntry);
        }

        if (dataEntry) {
            
            result = "SUCCESS";
        }

        return result;
    }

    private String url;
    private String sizeOfData;

    public String getSizeOfData() {
        return sizeOfData;
    }

    public void setSizeOfData(String sizeOfData) {
        this.sizeOfData = sizeOfData;
    }
    private String userId;
    private String id;
    private String title;
    private String completed;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}