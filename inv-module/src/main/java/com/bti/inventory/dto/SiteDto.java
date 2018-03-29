package com.bti.inventory.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class SiteDto {

	@NotEmpty
	private String siteID;
	
	@NotEmpty
	private String description;
	private String arabicDesc;
	private String adressLineOne;
	private String adressLineTwo;
	private String city;
	private String country;
	private String phone;
	private String fax;
	private Integer financialDimension;
	private String scheduledSalesTaxID;
	private String scheduledPurchaseTaxID;
	private Date creationDate;

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArabicDesc() {
		return arabicDesc;
	}

	public void setArabicDesc(String arabicDesc) {
		this.arabicDesc = arabicDesc;
	}

	public String getAdressLineOne() {
		return adressLineOne;
	}

	public void setAdressLineOne(String adressLineOne) {
		this.adressLineOne = adressLineOne;
	}

	public String getAdressLineTwo() {
		return adressLineTwo;
	}

	public void setAdressLineTwo(String adressLineTwo) {
		this.adressLineTwo = adressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getFinancialDimension() {
		return financialDimension;
	}

	public void setFinancialDimension(Integer financialDimension) {
		this.financialDimension = financialDimension;
	}

	public String getScheduledSalesTaxID() {
		return scheduledSalesTaxID;
	}

	public void setScheduledSalesTaxID(String scheduledSalesTaxID) {
		this.scheduledSalesTaxID = scheduledSalesTaxID;
	}

	public String getScheduledPurchaseTaxID() {
		return scheduledPurchaseTaxID;
	}

	public void setScheduledPurchaseTaxID(String scheduledPurchaseTaxID) {
		this.scheduledPurchaseTaxID = scheduledPurchaseTaxID;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
