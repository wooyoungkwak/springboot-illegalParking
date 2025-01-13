package com.young.illegalparking.model.dto.illegalzone.service;

import com.young.illegalparking.model.dto.illegalzone.domain.PointDto;
import com.young.illegalparking.model.entity.point.domain.Point;

import java.util.List;

/**
 * Date : 2022-10-10
 * Author : zilet
 * Project : illegalParking
 * Description :
 */
public interface PointDtoService {
    List<PointDto> gets(Integer groupSeq);
    PointDto get(Point point);
    PointDto getByPointSeq(Integer pointSeq);
}
