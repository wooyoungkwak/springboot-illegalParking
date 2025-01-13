package com.young.illegalparking.model.dto.report.service;

import com.young.illegalparking.exception.TeraException;
import com.young.illegalparking.model.dto.report.domain.ReceiptDetailDto;
import com.young.illegalparking.model.dto.report.domain.ReceiptDto;
import com.young.illegalparking.model.dto.report.domain.ReportDto;
import com.young.illegalparking.model.dto.report.domain.ReportDetailDto;
import com.young.illegalparking.model.entity.receipt.domain.Receipt;
import com.young.illegalparking.model.entity.receipt.enums.ReceiptFilterColumn;
import com.young.illegalparking.model.entity.receipt.enums.ReceiptStateType;
import com.young.illegalparking.model.entity.report.domain.Report;
import com.young.illegalparking.model.entity.report.enums.ReportFilterColumn;
import com.young.illegalparking.model.entity.report.enums.ReportStateType;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Date : 2022-09-28
 * Author : young
 * Editor :
 * Project : illegalParking
 * Description :
 */
public interface ReportDtoService {

    ReportDto get(Report report);

    List<ReportDto> gets(List<Report> reports);

    Page<ReceiptDto> getsFromReceipt(int pageNumber, int pageSize, ReceiptStateType receiptStateType, ReceiptFilterColumn filterColumn, String search);

    ReceiptDetailDto getFromReceiptDetailDto(Integer receiptSeq) throws TeraException;

    Page<ReportDto> getsFromReport(int pageNumber, int pageSize, ReportStateType reportStateType, ReportFilterColumn filterColumn, String search, List<Integer> zoneSeqs) throws TeraException;

    ReportDetailDto getFromReportDetailDto(int reportSeq) throws TeraException;

}
