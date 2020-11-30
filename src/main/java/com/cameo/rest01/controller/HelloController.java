package com.cameo.rest01.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags="hello测试")
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation("测试返回hello")
    public String hello() {
        return "hello";
    }
}
