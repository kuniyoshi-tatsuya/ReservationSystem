package jp.alh.mapper;

import java.util.List;

import jp.alh.entity.LocationEntity;

public interface LocationMapper {
	List<LocationEntity> getAllLocation();
	LocationEntity getSelectedLocation(int id);
}
