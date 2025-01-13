package com.young.illegalparking.model.dto.illegalzone.service;

import com.young.illegalparking.model.dto.illegalzone.domain.IllegalZoneDto;
import com.young.illegalparking.model.entity.illegalzone.domain.IllegalZone;

import java.util.List;

/**
 * Date : 2022-09-30
 * Author : young
 * Editor :
 * Project : illegalParking
 * Description :
 */
public interface IllegalZoneDtoService {
    IllegalZoneDto getToIllegalZoneDto(IllegalZone illegalZone);

    IllegalZone getToIllegalZone(IllegalZoneDto illegalZoneDto);

    List<IllegalZone> getsToIllegalZones(List<IllegalZoneDto> illegalZoneDto);


}
