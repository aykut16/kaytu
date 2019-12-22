package com.javahelps.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="foods")
public class User {

	@Id
	private String yemek;
	private String protein;
	private String yag;
	private String karbon;

	public String getYemek() {
		return yemek;
	}

	public void setYemek(String yemek) {
		this.yemek = yemek;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getYag() {
		return yag;
	}

	public void setYag(String yag) {
		this.yag = yag;
	}

	public String getKarbon() {
		return karbon;
	}

	public void setKarbon(String karbon) {
		this.karbon = karbon;
	}

	@Override
	public String toString() {
		return "User{" + "='" + yemek + '\'' + ", protein='" + protein + '\'' + ", yag='" + yag + '\''
				+ ", karbon='" + karbon + '\'' + '}';
	}
}
