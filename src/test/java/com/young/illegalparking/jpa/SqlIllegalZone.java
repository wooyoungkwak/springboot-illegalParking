package com.young.illegalparking.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.illegalparking.ApplicationTests;
import com.young.illegalparking.model.entity.illegalEvent.domain.IllegalEvent;
import com.young.illegalparking.model.entity.illegalEvent.service.IllegalEventService;
import com.young.illegalparking.model.entity.illegalGroup.domain.IllegalGroup;
import com.young.illegalparking.model.entity.illegalEvent.enums.IllegalType;
import com.young.illegalparking.model.entity.illegalzone.enums.LocationType;
import com.young.illegalparking.model.entity.illegalzone.repository.IllegalZoneRepository;
import com.young.illegalparking.model.entity.illegalGroup.service.IllegalGroupServcie;
import com.young.illegalparking.model.entity.illegalzone.service.IllegalZoneService;
import org.apache.commons.compress.utils.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Date : 2022-09-21
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
public class SqlIllegalZone {

    @Autowired
    IllegalZoneService illegalZoneService;

    @Autowired
    IllegalZoneRepository repository;

    @Autowired
    IllegalEventService illegalEventService;

    @Autowired
    IllegalGroupServcie illegalGroupServcie;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void insert(){
        insertByIllegalGroup();
        insertByEvent();
    }


    @Test
    public void insertByEvent() {

        IllegalEvent illegalEvent = new IllegalEvent();
        illegalEvent.setUsedFirst(false);
        illegalEvent.setUsedSecond(false);
        illegalEvent.setFirstStartTime("12:00");
        illegalEvent.setFirstEndTime("13:00");
        illegalEvent.setSecondStartTime("18:00");
        illegalEvent.setSecondEndTime("20:00");
        illegalEvent.setIllegalType(IllegalType.ILLEGAL);
        illegalEvent.setGroupSeq(1);
        illegalEvent.setName("샘플1");

        IllegalEvent illegalEvent2 = new IllegalEvent();
        illegalEvent2.setUsedFirst(false);
        illegalEvent2.setUsedSecond(false);
        illegalEvent2.setFirstStartTime("12:30");
        illegalEvent2.setFirstEndTime("13:30");
        illegalEvent2.setSecondStartTime("18:30");
        illegalEvent2.setSecondEndTime("20:30");
        illegalEvent2.setIllegalType(IllegalType.FIVE_MINUTE);
        illegalEvent2.setGroupSeq(2);
        illegalEvent2.setName("샘플2");

        List<IllegalEvent> illegalEvents = Lists.newArrayList();
        illegalEvents.add(illegalEvent);
        illegalEvents.add(illegalEvent2);

        System.out.println("illegalEvents size = " + illegalEvents.size());
        List<IllegalEvent> illegalEventList = illegalEventService.sets(illegalEvents);
        System.out.println("illegalEventList size = " + illegalEventList.size());
    }

    @Test
    public void insertByIllegalGroup(){
        IllegalGroup illegalGroup = new IllegalGroup();
        illegalGroup.setLocationType(LocationType.JEONNAM);
        illegalGroup.setName("차량신고과1");
        illegalGroupServcie.set(illegalGroup);
    }

    @Test
    public void select() {
        IllegalEvent illegalEvent = illegalEventService.get(1);
        try {
            System.out.println(objectMapper.writeValueAsString(illegalEvent));
        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

}
