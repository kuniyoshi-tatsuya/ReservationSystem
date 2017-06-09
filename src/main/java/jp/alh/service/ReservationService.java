package jp.alh.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.alh.dto.ReservationDto;
import jp.alh.entity.ReservationEntity;
import jp.alh.form.ReservationForm;
import jp.alh.mapper.ReservationMapper;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	public void registerReservation(ReservationForm form){
		
		ReservationDto dto = new ReservationDto();
		BeanUtils.copyProperties(form, dto);
		ReservationDto dtoFormat = setDateFormatYYYYMMDD(dto);
		reservationMapper.registerReservation(dtoFormat);
	}
	
	public List<ReservationDto> getAllReservation(){
		
		List<ReservationEntity> entityList = reservationMapper.getAllReservation();
		List<ReservationDto> dtoList = convertToDto(entityList);
		List<ReservationDto> dtoFormatList = setDateFormatHHmmss(dtoList);
		
		return dtoFormatList;
	}
	
	public List<ReservationDto> setDateFormatHHmmss(List<ReservationDto> dtoList){
		
		List<ReservationDto> dtoFormatList = new LinkedList<>();
		for(ReservationDto dto : dtoList){
			ReservationDto dtoFormat = new ReservationDto();
			dto.setReservedStart(dto.getReservedStart().substring(11));
			dto.setReservedStart(dto.getReservedStart().substring(0, 5));
			dto.setReservedEnd(dto.getReservedEnd().substring(11));
			dto.setReservedEnd(dto.getReservedEnd().substring(0, 5));
			BeanUtils.copyProperties(dto, dtoFormat);
			dtoFormatList.add(dtoFormat);
		}
		return dtoFormatList;
	}
	
	public ReservationDto setDateFormatYYYYMMDD(ReservationDto dto){
		
		ReservationDto dtoFormat = new ReservationDto();
		dto.setReservedStart("2017/06/01 " + dto.getReservedStart());
		dto.setReservedEnd("2017/06/01 " + dto.getReservedEnd());
		BeanUtils.copyProperties(dto, dtoFormat);
		return dtoFormat;
	}
	
	private List<ReservationDto> convertToDto(List<ReservationEntity> entityList) {
		
		List<ReservationDto> resultList = new LinkedList<>();
		for(ReservationEntity entity : entityList){
			ReservationDto dto = new ReservationDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
}
