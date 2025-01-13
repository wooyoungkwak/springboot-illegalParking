package com.young.illegalparking.model.dto.report.domain;

import com.young.illegalparking.model.entity.illegalEvent.enums.IllegalType;
import com.young.illegalparking.model.entity.illegalzone.enums.LocationType;
import com.young.illegalparking.model.entity.report.enums.ReportStateType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Date : 2022-10-08
 * Author : zilet
 * Project : illegalParking
 * Description :
 */

@Getter
@Setter
public class ReportDetailDto {

    Integer reportSeq;              // 신고 접수 키
    String name;                    // 사용자 이름
    String carNum;                  // 차량 번호
    Integer overlapCount;           // 중복 횟수
    LocalDateTime regDt;            // 신고 접수 일자
    String GovernmentOfficeName;    // 신고 기관 ( 처리 기관 )
    String addr;                    // 위치
    String note;                    // 처리 결과 내용
    ReportStateType reportStateType;      // 신고 접수

    String firstFileName = "";          // 1차 사진 파일 이름
    LocalDateTime firstRegDt;           // 1차 신고 접수 시간
    String firstAddr;                   // 1차 신고 접수 위치
    IllegalType firstIllegalType;       // 1차 위치 분석

    String secondFileName;              // 2차 사진 파일 이름
    LocalDateTime secondRegDt;          // 2차 신고 접수 시간
    String secondAddr;                  // 2차 신고 접수 위치
    IllegalType secondIllegalType;      // 2차 위치 분석

    List<String> comments;              // 댓글
}

