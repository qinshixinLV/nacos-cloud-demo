package com.example.gatewaydemo.Response;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CommonResult {

    private Integer code;

    private String msg;

}
