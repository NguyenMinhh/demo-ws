package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BarcodeScannersDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.BarcodeScannerService;


@RestController
public class BarcodeScannerController {

	@Autowired
	BarcodeScannerService barcodeScannerService;
	
	@RequestMapping(value = "/create-flight-id", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody HashMap<String, String> info, HttpServletResponse response) {
		
		String flightId = barcodeScannerService.createFlightId(info.get("data"));
		return new ResponseEntity<String>(flightId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/scan", method = RequestMethod.POST)
	public ResponseEntity<?> barcodeScan(@RequestBody HashMap<String, BarcodeScannersDTO> info, HttpServletResponse response) {
		
		BarcodeScannersDTO scan = info.get("data");
		String track = barcodeScannerService.createWaybill(scan);
		
		return new ResponseEntity<String>(track, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get-customer", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer() {
		
		List<Customer> lstCustomer = barcodeScannerService.getCustomerData();
		
		return new ResponseEntity<List<Customer>>(lstCustomer, HttpStatus.OK);
	}
}
