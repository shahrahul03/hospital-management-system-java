package com.model;

public class Doctor {
	private int id;
    private String name;
    private String email;
    private String specialization;
    private String address;
    private String mobile;
    private String gender;
    
    public Doctor() {
    	
    }

	public Doctor(int id, String name, String email, String specialization, String address, String mobile,
			String gender) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.specialization = specialization;
		this.address = address;
		this.mobile = mobile;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", email=" + email + ", specialization=" + specialization
				+ ", address=" + address + ", mobile=" + mobile + ", gender=" + gender + "]";
	}
	
    
}
