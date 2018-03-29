package com.bti.inventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bti.inventory.dto.SiteDto;
import com.bti.inventory.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/sites")
	public ResponseEntity<String> createSite( @Valid @RequestBody SiteDto Site) {
		inventoryService.createSite(Site);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@GetMapping("/sites")
	public ResponseEntity<String> createSite1() {
		return new ResponseEntity<>("hellllo",HttpStatus.OK);

	}

	@PostMapping("/bin")
	public ResponseEntity<String> createBin( SiteDto Site) {
		inventoryService.createSite( Site);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
