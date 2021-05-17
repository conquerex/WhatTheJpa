package what.the.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatTheJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhatTheJpaApplication.class, args);
        Hello hello = new Hello();
        hello.setHello("hello~~");
        String data = hello.getHello();
        System.out.println("data = " + data);
    }

}
