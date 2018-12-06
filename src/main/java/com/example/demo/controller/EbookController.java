package com.example.demo.controller;

import com.example.demo.service.SqlScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping(value = "/ebooks")
public class EbookController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private EntityManager entityManager;

    private SqlScript sqlScript;

    @RequestMapping(value = "/{tablesNames}")
    public String show(@PathVariable("tablesNames") List<String> tablesNames) {
        sqlScript = SqlScript.getBuilder(ctx, entityManager).withIgnoreTables(tablesNames).addIgnoreTable("trzecia").build();
        return sqlScript.showInfo();
    }
}
