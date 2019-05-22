package com.botanik.model;

/**
 *
 * @author teyyub Aug 2, 2016 11:17:45 AM
 */
public class User  {

    private Number user_id;
    private String username;
    private String password;
    private String status;
    private int user_type;    
    private String daoStatus;
    
//    private Date insert_date;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Number id, String username, String status) {
        this.user_id = id;
        this.username = username;
        this.status = status;
    }

    public User(Number id, String username, String password, int user_type) {
        this.user_id = id;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
    }

     
    
    
    public User() {
    }

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Number getUser_id() {
        return user_id;
    }

    public void setUser_id(Number user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return username +" " +password;
    }
    
    
}
