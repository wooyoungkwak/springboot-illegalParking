package com.young.illegalparking.model.dto.user.service;

import com.young.illegalparking.model.dto.user.domain.UserDto;
import com.young.illegalparking.model.entity.user.domain.User;

/**
 * Date : 2022-09-30
 * Author : young
 * Editor :
 * Project : illegalParking
 * Description :
 */
public interface UserDtoService {

    UserDto get(User user);

}
