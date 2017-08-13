package com.dfbz.bean;

public class CarInfo {

	private int id;
	private String car_name;
	private String brand_name;
	private String car_model;
	private Double price;
	private String year;
	private String drive_system;
	private String gear_box_name;
	private String front_type;

	public String getDrive_system() {
		return drive_system;
	}
	public void setDrive_system(String drive_system) {
		this.drive_system = drive_system;
	}
	public String getGear_box_name() {
		return gear_box_name;
	}
	public void setGear_box_name(String gear_box_name) {
		this.gear_box_name = gear_box_name;
	}
	public String getFront_type() {
		return front_type;
	}
	public void setFront_type(String front_type) {
		this.front_type = front_type;
	}
	private int output;
	private int horsepower;
	private String air_admission;
	private String condition;
	private String image_url;
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getOutput() {
		return output;
	}
	public void setOutput(int output) {
		this.output = output;
	}
	public int getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	public String getAir_admission() {
		return air_admission;
	}
	public void setAir_admission(String air_admission) {
		this.air_admission = air_admission;
	}

	

}
