package com.axpe.prueba.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axpe.prueba.exception.PricesException;
import com.axpe.prueba.service.PricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {

	@Autowired
	PricesService service;

	@GetMapping
	public ResponseEntity<?> getPrice(@RequestParam("date") String date,
			@RequestParam("product") Long productId, @RequestParam("brand") Long brandId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getPrice(date, productId, brandId));
		} catch (PricesException e) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("timestamp", new Date());
			response.put("status", 409);
			response.put("error", "Conflict");
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		} catch (ParseException e) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("timestamp", new Date());
			response.put("status", 400);
			response.put("error", "Bad Request");
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
