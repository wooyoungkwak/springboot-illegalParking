package com.young.illegalparking.jpa;

import com.young.illegalparking.ApplicationTests;
import com.young.illegalparking.model.entity.lawdong.domain.LawDong;
import com.young.illegalparking.model.entity.lawdong.repository.LawDongRepository;
import com.young.illegalparking.model.entity.lawdong.service.LawDongService;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Date : 2022-09-14
 * Author : young
 * Editor :
 * Project : illegalParking
 * Description :
 */
@ActiveProfiles(value = "debug-illegal-parking")
@SpringBootTest(classes = ApplicationTests.class,
        properties = "spring.config.location=file:/C:/Users/user/application.yml")
@RunWith(SpringRunner.class)
@Transactional
public class SqlLawDong {

    @Value("${file.staticPath}")
    String staticPath;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    LawDongService lawDongService;

    @Autowired
    LawDongRepository lawDongRepository;

    private String getCellData(XSSFCell cell) {
        String value = "";
        switch (cell.getCellType()) {
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case NUMERIC:
                value = (long)cell.getNumericCellValue() + "";
                break;
            case STRING:
                value = cell.getStringCellValue() + "";
                break;
            case BLANK:
                value = cell.getBooleanCellValue() + "";
                break;
            case ERROR:
                value = cell.getErrorCellValue() + "";
                break;
        }

        return value;
    }


    @Test
    public void insert(){
        String fileName = "법정동코드_전체자료.xlsx";
        System.out.println(" staticPath = " + staticPath);
        try {
            Resource resource = resourceLoader.getResource(staticPath + fileName);

            FileInputStream fis = new FileInputStream(resource.getFile());
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);
            List<LawDong> lawDongs = Lists.newArrayList();

            // 행수
            int rows = sheet.getPhysicalNumberOfRows();

            for (int rowindex = 0; rowindex < rows; rowindex++) {

                // 0행은 1행부터 값들의 이름을 작성된 것으로 제외
                if (rowindex == 0) {
                    continue;
                }

                // 행을읽는다
                XSSFRow row = sheet.getRow(rowindex);
                LawDong lawDong = new LawDong();

                lawDong.setCode(getCellData(row.getCell(0)));
                lawDong.setName(getCellData(row.getCell(1)));
                lawDong.setIsDel(getCellData(row.getCell(2)).trim().equals("존재") ? false : true);
                lawDongs.add(lawDong);
            }

            System.out.println("law_dong size = " + lawDongs.size());
            lawDongService.sets(lawDongs);
//            lawDongService.set(lawDongs.get(0));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void select(){
        LawDong lawDong = lawDongService.get("5013032000");

        if (lawDong == null) {
            System.out.println(" =============> lawDong is null ");
        } else {
            System.out.println(lawDong.getName());
        }

        lawDongRepository.findByNameAndIsDel("", false);
    }

}
