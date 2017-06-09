package jp.alh.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.alh.dto.UserDto;
import jp.alh.entity.UserEntity;
import jp.alh.form.UserForm;
import jp.alh.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserDto getLoginUser(UserForm userForm){
		UserDto dto = new UserDto();
		UserEntity entity = userMapper.getLoginUser(userForm);
		if(entity == null) return null;
		else BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}
}
