package com.example.demo.web;

import com.example.demo.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class DemoContrrollerImpl implements DemoController{
    @Autowired
    private DemoServiceImpl service;

    @GetMapping("/{codigo}")
    public boolean verificar(@PathVariable String codigo) {
        return service.verificar(codigo);
    }
}
