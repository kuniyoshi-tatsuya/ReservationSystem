package jp.alh.mapper;

import jp.alh.entity.UserEntity;
import jp.alh.form.UserForm;

public interface UserMapper {
	UserEntity getLoginUser(UserForm userForm);
}
