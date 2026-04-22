package com.model;

public class Patient {
	   private int id;
	    private String firstName;
	    private String lastName;
	    private String gender;
	    private String phone;
	    private String dateOfBirth;
	    private String address;
	    public Patient() {
	    	
	    }
		public Patient(int id, String firstName, String lastName, String gender, String phone, String dateOfBirth,
				String address) {
			
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.phone = phone;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
					+ ", phone=" + phone + ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
		}
		
	    

}
