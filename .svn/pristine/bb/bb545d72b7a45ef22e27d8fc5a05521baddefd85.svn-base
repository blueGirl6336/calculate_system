package com.cesystem.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * PushNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PushNews"
    ,schema="dbo"
    ,catalog="ce_system"
)

public class PushNews  implements java.io.Serializable {


    // Fields    

     private Integer newsId;
     private Student student;
     private String newsTitle;
     private String newsContent;
     private Timestamp sendTime;
     private String newsStatus;
     private Boolean isStudentRole;


    // Constructors

    /** default constructor */
    public PushNews() {
    }

	/** minimal constructor */
    public PushNews(Integer newsId) {
        this.newsId = newsId;
    }
    
    /** full constructor */
    public PushNews(Integer newsId, Student student, String newsTitle, String newsContent, Timestamp sendTime, String newsStatus, Boolean isStudentRole) {
        this.newsId = newsId;
        this.student = student;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.sendTime = sendTime;
        this.newsStatus = newsStatus;
        this.isStudentRole = isStudentRole;
    }

   
    // Property accessors
    @Id 
    @GeneratedValue
    @Column(name="news_id", unique=true, nullable=false)

    public Integer getNewsId() {
        return this.newsId;
    }
    
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="student_id")

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Column(name="news_title")

    public String getNewsTitle() {
        return this.newsTitle;
    }
    
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    
    @Column(name="news_content")

    public String getNewsContent() {
        return this.newsContent;
    }
    
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
    
    @Column(name="send_time", length=23)

    public Timestamp getSendTime() {
        return this.sendTime;
    }
    
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
    
    @Column(name="news_status")

    public String getNewsStatus() {
        return this.newsStatus;
    }
    
    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus;
    }
    
    @Column(name="is_student_role")

    public Boolean getIsStudentRole() {
        return this.isStudentRole;
    }
    
    public void setIsStudentRole(Boolean isStudentRole) {
        this.isStudentRole = isStudentRole;
    }
   








}