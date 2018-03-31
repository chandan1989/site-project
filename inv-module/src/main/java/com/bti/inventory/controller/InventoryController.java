package com.bti.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bti.inventory.dto.BinDto;
import com.bti.inventory.dto.SiteDto;
import com.bti.inventory.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/sites")
	public ResponseEntity<String> createSite( @Valid @RequestBody SiteDto Site) {
		inventoryService.createSite(Site);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/sites")
	public ResponseEntity<String> createSite1() {
		return new ResponseEntity<String>("hellllo",HttpStatus.OK);

	}
	@GetMapping("/getAllSites")
	public List<SiteDto> getAllSite() {
		return inventoryService.getAllSite();

	}
	
	@PostMapping("/updateSite")
	public ResponseEntity<String> updateSite( @Valid @RequestBody SiteDto Site) {
		inventoryService.updateSite(Site);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PostMapping("/deleteSite")
	public ResponseEntity<String> updateSite( @Valid @RequestBody Long siteId) {
		inventoryService.deleteSite(siteId);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	/*@PostMapping("/bin")
	public ResponseEntity<String> createBin(SiteDto site) {
		inventoryService.createSite( site);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	@GetMapping("/getAllBins")
	public List<BinDto> getAllBins() {
		return inventoryService.getAllBins();

	}*/
}
