package jp.alh.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.alh.dto.LocationDto;
import jp.alh.entity.LocationEntity;
import jp.alh.mapper.LocationMapper;

@Service
public class LocationService {
	
	@Autowired
	private LocationMapper locationMapper;
	
	public List<LocationDto> getAllLocation(){
		
		List<LocationEntity> entityList = locationMapper.getAllLocation();
		List<LocationDto> dtoList = convertToDto(entityList);
		return dtoList;
	}
	
	public LocationDto getSelectedLocation(int id){
		
		LocationEntity entity = locationMapper.getSelectedLocation(id);

		LocationDto dto = new LocationDto();
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}
	
	private List<LocationDto> convertToDto(List<LocationEntity> entityList) {
		
		List<LocationDto> resultList = new LinkedList<>();
		for(LocationEntity entity : entityList){
			LocationDto dto = new LocationDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
	
	
}