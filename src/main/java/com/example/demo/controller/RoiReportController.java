package com.example.demo.controller;

import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roi")
public class RoiReportController {
    public RoiReportController(RoiService service) {}
}
