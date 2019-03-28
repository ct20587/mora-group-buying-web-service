package org.cynerds.mgb.controller;

import org.cynerds.mgb.model.Greeting;
import org.cynerds.mgb.model.Test;
import org.cynerds.mgb.mybatis.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private DataSource dataSource;
    private TestMapper testMapper;
    private static final String template = "Hello, %s!";
    private static final Logger LOG = LoggerFactory.getLogger(GreetingController.class);
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public GreetingController(DataSource dataSource, TestMapper testMapper) {
        this.dataSource = dataSource;
        this.testMapper = testMapper;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/dbCheck")
    public Test dbCheck(@RequestParam(value = "id", defaultValue = "1") int id) throws SQLException {
        LOG.warn("DS = {}", dataSource);
        LOG.warn("conn = {}", dataSource.getConnection());
        LOG.warn("mapper = {}", testMapper);

        Test t = testMapper.queryTestRecord(id);
        LOG.warn("t = {}", t);

        return t;
    }

}
