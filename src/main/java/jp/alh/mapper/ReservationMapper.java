package jp.alh.mapper;

import java.util.List;

import jp.alh.dto.ReservationDto;
import jp.alh.entity.ReservationEntity;

public interface ReservationMapper {
	void registerReservation(ReservationDto dto);
	List<ReservationEntity> getAllReservation();
}
