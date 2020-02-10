package com.example.finartz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "airports")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updateAt"},
 allowGetters= true)
public class Airport implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1977677802625591557L;

@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   @NotBlank
   private String airport_name;
   
   @NotBlank
   private String airline_name;
   
   @NotBlank
   private String from;
   
   @NotBlank
   private String to;
   
   @NotBlank
   private String fligh_number;
   
   

   @Column(nullable = false, updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
   @CreatedDate
   private Date createdAt;
   
   @Column(nullable=false)
   @Temporal(TemporalType.TIMESTAMP)
   @LastModifiedDate
   private Date updateAt;
   

   public long getId() {
	 return id;
   }

   public void setId(long id) {
	 this.id = id;
   }

   public String getAirport_name() {
	 return airport_name;
   }

   public void setAirport_name(String airport_name) {
	 this.airport_name = airport_name;
   }

   public String getAirline_name() {
	 return airline_name;
   }

   public void setAirline_name(String airline_name) {
	 this.airline_name = airline_name;
   }

   public String getFrom() {
	 return from;
   }

   public void setFrom(String from) {
	 this.from = from;
   }

   public String getTo() {
	 return to;
   }

   public void setTo(String to) {
	 this.to = to;
   }

   public String getFligh_number() {
	 return fligh_number;
   }

   public void setFligh_number(String fligh_number) {
	 this.fligh_number = fligh_number;
   }

   public Date getCreatedAt() {
	 return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
	 this.createdAt = createdAt;
   }

   public Date getUpdateAt() {
	 return updateAt;
   }

   public void setUpdateAt(Date updateAt) {
	 this.updateAt = updateAt;
   }

 

   public Object getTitle() {
	// TODO Auto-generated method stub
	 return null;
   }

   public Object getContent() {
	// TODO Auto-generated method stub
	 return null;
   }

   public void setTitle(Object title) {
	// TODO Auto-generated method stub
	
   }

   public void setContent(Object content) {
	// TODO Auto-generated method stub
	
   }
   
}
