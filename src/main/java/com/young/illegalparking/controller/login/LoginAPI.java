package com.young.illegalparking.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.young.illegalparking.exception.TeraException;
import com.young.illegalparking.exception.enums.TeraExceptionCode;
import com.young.illegalparking.model.dto.user.domain.UserDto;
import com.young.illegalparking.model.dto.user.service.UserDtoService;
import com.young.illegalparking.model.entity.user.domain.User;
import com.young.illegalparking.model.entity.user.enums.Role;
import com.young.illegalparking.model.entity.user.service.UserService;
import com.young.illegalparking.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Date : 2022-10-06
 * Author : young
 * Editor :
 * Project : illegalParking
 * Description :
 */

@RequiredArgsConstructor
//@Controller
public class LoginAPI {

}
