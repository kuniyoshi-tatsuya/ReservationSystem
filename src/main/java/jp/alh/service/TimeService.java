package jp.alh.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.alh.dto.TimeDto;
import jp.alh.entity.TimeEntity;
import jp.alh.mapper.TimeMapper;

@Service
public class TimeService {
	
	@Autowired
	private TimeMapper timeMapper;
	
	public List<TimeDto> getAllTime(){
		
		List<TimeEntity> entityList = timeMapper.getAllTime();
		List<TimeDto> dtoList = convertToDto(entityList);
		List<TimeDto> dtoFormatList = setTimeFormat(dtoList);
		return dtoFormatList;
	}
	
	private List<TimeDto> convertToDto(List<TimeEntity> entityList) {
		
		List<TimeDto> resultList = new LinkedList<>();
		for(TimeEntity entity : entityList){
			TimeDto dto = new TimeDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
	
	private List<TimeDto> setTimeFormat(List<TimeDto> dtoList){
		
		List<TimeDto> dtoFormatList = new LinkedList<>();
		for(TimeDto dto : dtoList){
			TimeDto dtoFormat = new TimeDto();
			dto.setMinutes(dto.getMinutes().substring(11));
			dto.setMinutes(dto.getMinutes().substring(0, 5));
			BeanUtils.copyProperties(dto, dtoFormat);
			dtoFormatList.add(dtoFormat);
		}
		return dtoFormatList;
	}
}
