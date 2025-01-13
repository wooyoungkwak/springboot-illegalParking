package com.young.illegalparking.local;

import com.young.illegalparking.encrypt.YoungEncoder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * package name : com.young.illegalparking.local
 * Date : 2024-05-22
 * Author : USER
 * Project : illegalParking
 * Description :
 */

@RunWith(SpringRunner.class)
public class encyptTest {


    @Test
    public void encryptTest(){

        System.out.println(" ============================================ ");
        System.out.println(YoungEncoder.encrypt("admin1234"));
        System.out.println(" ============================================ ");

    }

}
