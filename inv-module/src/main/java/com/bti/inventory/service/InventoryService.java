package com.bti.inventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.inventory.dto.BinDto;
import com.bti.inventory.dto.SiteDto;
import com.bti.inventory.entity.BinEntity;
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
		List<BinDto> binDtos = new ArrayList();
		/*if(siteDto!=null){
			binDtos = siteDto.getBins();
		}
		*/
		SiteEntity siteEntity = convertToEntity(siteDto);
		
		/*List<BinEntity> binEntities = new ArrayList();
		if(binDtos!=null){
			for(BinDto binDto : binDtos){
				binEntities.add(convertToEntity(binDto));
			}
			siteEntity.setBins(binEntities);
		}*/
		
		inventoryRepository.save(siteEntity);
	}
	
	public List<SiteDto> getAllSite() {
		List<SiteEntity> siteEntities = new ArrayList();
		siteEntities = (List<SiteEntity>) inventoryRepository.findAll();
		List<SiteDto> siteDtos = new ArrayList();
		if(siteEntities!=null){
			for(SiteEntity siteEntity: siteEntities){
				SiteDto siteDto = convertToDto(siteEntity);
				siteDtos.add(siteDto);
			}
		}
		return siteDtos;
	}
	public List<BinDto> getAllBins() {
		
		return null;
	}
	public void updateSite(SiteDto siteDto) {
		siteDto.setModifiedDate(new Date());
		siteDto.setChangedBy("DUMMY-test");
		SiteEntity siteEntity = convertToEntity(siteDto);
		inventoryRepository.save(siteEntity);
	}
	public void deleteSite(Long siteId){
		inventoryRepository.deleteById(siteId);
	}

	/**
	 * @param siteDto
	 * @return
	 */
	private SiteEntity convertToEntity(SiteDto siteDto) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SiteEntity entity = mapper.map(siteDto, SiteEntity.class);
		entity.setCreationDate(new Date());
		return entity;
	}
	private BinEntity convertToEntity(BinDto siteDto) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		BinEntity entity = mapper.map(siteDto, BinEntity.class);
		return entity;
	}
	private SiteDto convertToDto(SiteEntity siteEntity) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SiteDto dto = mapper.map(siteEntity, SiteDto.class);
		return dto;
	}

}
