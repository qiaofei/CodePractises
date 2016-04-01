package com._08vip.www.user;

import java.sql.Timestamp;


/**
 * entity entity. @author MyEclipse Persistence Tools
 */

public class entity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String title;
     private String content;
     private Integer userId;
     private Timestamp time;


    // Constructors

    /** default constructor */
    public entity() {
    }

    
    /** full constructor */
    public entity(String title, String content, Integer userId, Timestamp time) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.time = time;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return this.time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }
   








}