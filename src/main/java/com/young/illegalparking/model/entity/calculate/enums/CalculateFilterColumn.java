package com.young.illegalparking.model.entity.calculate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Date : 2022-09-19
 * Author : young
 * Project : illegalParking
 * Description :
 */

@AllArgsConstructor
@Getter
public enum CalculateFilterColumn {
    user("사용자"), 
//    currentPoint("현재포인트"),
    product("제품"),
    regDt("일자")
    ;

    private String value;

}
