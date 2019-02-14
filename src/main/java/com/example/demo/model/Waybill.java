package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Waybill")
public class Waybill {
	private String _id;
	private String flightId;
	private String customerId;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
}
