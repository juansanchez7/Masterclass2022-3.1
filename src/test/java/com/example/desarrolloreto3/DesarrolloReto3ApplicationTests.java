package com.example.desarrolloreto3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EntityScan(basePackages = {"com.example.desarrolloreto3"})
@SpringBootApplication
class DesarrolloReto3ApplicationTests {

    @Test
    void contextLoads() {
    }

}
