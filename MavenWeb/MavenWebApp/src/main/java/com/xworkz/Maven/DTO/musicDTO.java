package com.xworkz.Maven.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="music")
public class musicDTO implements Serializable {
@Id
@GenericGenerator(name="auto",strategy="increment")
@GeneratedValue(generator = "auto")

@Column(name="musicid")
	private int musicid;
@Column(name="musicalbum")
	private String  musicalbum;
@Column(name="singer")
	private String singer;
@Column(name="company")
private String company;
@Column(name="year")
	private int year;


public musicDTO() {
	System.out.println("created musicDTO");
}


public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getMusicid() {
	return musicid;
}
public void setMusicid(int musicid) {
	this.musicid = musicid;
}
public String getMusicalbum() {
	return musicalbum;
}
public void setMusicalbum(String musicalbum) {
	this.musicalbum = musicalbum;
}
public String getSinger() {
	return singer;
}
public void setSinger(String singer) {
	this.singer = singer;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

@Override
public String toString() {
	return "musicDTO [musicid=" + musicid + ", musicalbum=" + musicalbum + ", singer=" + singer + ", year=" + year
			+ "]";
}



	
}
