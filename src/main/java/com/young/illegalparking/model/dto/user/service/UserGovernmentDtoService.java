package com.young.illegalparking.model.dto.user.service;

import com.young.illegalparking.exception.TeraException;
import com.young.illegalparking.model.dto.user.domain.UserGovernmentDto;
import com.young.illegalparking.model.dto.user.enums.UserGovernmentFilterColumn;
import com.young.illegalparking.model.entity.illegalGroup.domain.IllegalGroup;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Date : 2022-10-11
 * Author : young
 * Editor :
 * Project : illegalParking
 * Description :
 */
public interface UserGovernmentDtoService {

    Page<UserGovernmentDto> gets(int pageNumber, int pageSize, UserGovernmentFilterColumn userGovernmentFilterColumn, String search) throws TeraException;

    List<IllegalGroup> gets(Integer userSeq);

}
