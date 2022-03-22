package com.aim.questionnaire.dao.entity;

import java.util.Date;

public class UserEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.start_time
     *
     * @mbg.generated
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.stop_time
     *
     * @mbg.generated
     */
    private Date stopTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.created_by
     *
     * @mbg.generated
     */
    private String createdBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.creation_date
     *
     * @mbg.generated
     */
    private Date creationDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.last_updated_by
     *
     * @mbg.generated
     */
    private String lastUpdatedBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.last_update_date
     *
     * @mbg.generated
     */
    private Date lastUpdateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.username
     *
     * @return the value of user_info.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.username
     *
     * @param username the value for user_info.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.password
     *
     * @return the value of user_info.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.password
     *
     * @param password the value for user_info.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.start_time
     *
     * @return the value of user_info.start_time
     *
     * @mbg.generated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.start_time
     *
     * @param startTime the value for user_info.start_time
     *
     * @mbg.generated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.stop_time
     *
     * @return the value of user_info.stop_time
     *
     * @mbg.generated
     */
    public Date getStopTime() {
        return stopTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.stop_time
     *
     * @param stopTime the value for user_info.stop_time
     *
     * @mbg.generated
     */
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.status
     *
     * @return the value of user_info.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.status
     *
     * @param status the value for user_info.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.created_by
     *
     * @return the value of user_info.created_by
     *
     * @mbg.generated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.created_by
     *
     * @param createdBy the value for user_info.created_by
     *
     * @mbg.generated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.creation_date
     *
     * @return the value of user_info.creation_date
     *
     * @mbg.generated
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.creation_date
     *
     * @param creationDate the value for user_info.creation_date
     *
     * @mbg.generated
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.last_updated_by
     *
     * @return the value of user_info.last_updated_by
     *
     * @mbg.generated
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.last_updated_by
     *
     * @param lastUpdatedBy the value for user_info.last_updated_by
     *
     * @mbg.generated
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.last_update_date
     *
     * @return the value of user_info.last_update_date
     *
     * @mbg.generated
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.last_update_date
     *
     * @param lastUpdateDate the value for user_info.last_update_date
     *
     * @mbg.generated
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}