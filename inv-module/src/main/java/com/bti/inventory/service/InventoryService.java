package com.bti.inventory.service;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.inventory.dto.SiteDto;
import com.bti.inventory.entity.SiteEntity;
import com.bti.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private ModelMapper mapper;

	/**
	 * @param siteDto
	 */
	public void createSite( SiteDto siteDto) {
		SiteEntity siteEntity = convertToEntity(siteDto);
		inventoryRepository.save(siteEntity);
	}

	

	/**
	 * @param siteDto
	 * @return
	 */
	private SiteEntity convertToEntity(SiteDto siteDto) {
		SiteEntity entity = mapper.map(siteDto, SiteEntity.class);
		entity.setCreationDate(new Date());
		return entity;
	}

}
