package com.skcx.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplication {


    @Test
    public void test() {
        String originalFilename = "test.jpg";
        int indexOf = originalFilename.lastIndexOf(".");

        System.out.println("indexOf = " + indexOf);

        String s = originalFilename.substring(indexOf);

        System.out.println(s);
    }
}
