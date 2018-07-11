package org.cynerds.mgb.controller;

import org.cynerds.mgb.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final Logger LOG = LoggerFactory.getLogger(GreetingController.class);
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private DataSource dataSource;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws SQLException {
        LOG.warn("DS = {}", dataSource);
        LOG.warn("conn = {}", dataSource.getConnection());
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
