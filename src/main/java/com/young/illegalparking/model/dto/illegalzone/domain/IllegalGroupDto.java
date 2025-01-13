package com.young.illegalparking.model.dto.illegalzone.domain;

import com.young.illegalparking.model.entity.illegalzone.enums.LocationType;
import lombok.Getter;
import lombok.Setter;

/**
 * Date : 2022-10-09
 * Author : zilet
 * Project : illegalParking
 * Description :
 */

@Getter
@Setter
public class IllegalGroupDto {
    Integer groupSeq;
    String name;
    LocationType locationType;
    long groupSize;
    String note;
}
