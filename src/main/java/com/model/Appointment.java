package com.model;

public class Appointment {
	 private int id;
	    private String doctor;
	    private String date;
	    private String slot;
	    private String details;
	    
	    public Appointment() {
	    	
	    }
		public Appointment(int id, String doctor, String date, String slot, String details) {
			super();
			this.id = id;
			this.doctor = doctor;
			this.date = date;
			this.slot = slot;
			this.details = details;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDoctor() {
			return doctor;
		}
		public void setDoctor(String doctor) {
			this.doctor = doctor;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getSlot() {
			return slot;
		}
		public void setSlot(String slot) {
			this.slot = slot;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		@Override
		public String toString() {
			return "Appointment [id=" + id + ", doctor=" + doctor + ", date=" + date + ", slot=" + slot + ", details="
					+ details + "]";
		}
		
	    
	    

}
