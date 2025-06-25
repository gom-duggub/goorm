package com.codestates.kim.domain.bears.controller;

import com.codestates.kim.domain.bears.dto.BearsResDto;
import com.codestates.kim.domain.bears.service.BearsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BearsController {
    private final BearsService bearsService;
    public BearsController(BearsService bearsService) {
        this.bearsService = bearsService;
    }
    @GetMapping("/bears/{bearsId}")
    public ResponseEntity<BearsResDto> getCrops(@PathVariable Integer bearsId) {
        BearsResDto bearsResDto = bearsService.showBears(bearsId);

        return new ResponseEntity<>(bearsResDto, HttpStatus.OK);
    }
    @GetMapping("/bears")
    public ResponseEntity<List<BearsResDto>> getBears() {
        List<BearsResDto> bearList = bearsService.showAllBears();
        return new ResponseEntity<>(bearList, HttpStatus.OK);
    }
}
