package com.hello.quickstart.controller;

import com.fasterxml.jackson.databind.ObjectReader;
import com.hello.quickstart.dto.ItemDto;
import com.hello.quickstart.dto.ResponseDto;
import com.hello.quickstart.repository.ItemRepository;
import com.hello.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {


    private final QuickService quickService;

    @Autowired
    public QuickController(QuickService quickService) {
        this.quickService = quickService;
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("test");
        return "hello";
    }

    @GetMapping("/member")
    public String Member(@RequestParam("empNo") String empNo, @RequestParam("age") int age) {
        log.info("empNo: " + empNo);
        log.info("age: " + age);
        return "ok";
    }

    @GetMapping("/company/{id}")
    public String Company(@PathVariable("id") String id) {
        log.info("id: " + id);
        return "ok";
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        return quickService.getItemById(id);
    }

    @PostMapping("/item")
    public ResponseDto ItemForm(@RequestBody ItemDto item) {
        log.info("item: {}", item);

        boolean result = quickService.ItemFrom(item);
        ResponseDto responseDto = new ResponseDto();
        if (result) {
            responseDto.setMessage("ok");
        } else {
            responseDto.setMessage("error");
        }
        return responseDto;
    }


}

