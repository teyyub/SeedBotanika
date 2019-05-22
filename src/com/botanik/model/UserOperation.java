 

package com.botanik.model;

import java.util.Date;

/**
 *
 * @author teyyub , Mar 15, 2018 ,  3:32:42 PM 
 */
public class UserOperation {

    private Number user_id;
    private String tableName;
    private Number tableId;
    private String opertationStatus;
    private String note;
    private Date create_date;

    public UserOperation(Number user_id, String tableName, Number tableId, String opertationStatus, String note, Date create_date) {
        this.user_id = user_id;
        this.tableName = tableName;
        this.tableId = tableId;
        this.opertationStatus = opertationStatus;
        this.note = note;
        this.create_date = create_date;
    }

    public Number getUser_id() {
        return user_id;
    }

    public void setUser_id(Number user_id) {
        this.user_id = user_id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Number getTableId() {
        return tableId;
    }

    public void setTableId(Number tableId) {
        this.tableId = tableId;
    }

    public String getOpertationStatus() {
        return opertationStatus;
    }

    public void setOpertationStatus(String opertationStatus) {
        this.opertationStatus = opertationStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
    
    
    
    
    
    
}
