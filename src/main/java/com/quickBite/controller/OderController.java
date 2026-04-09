package com.quickBite.controller;

import com.quickBite.dtos.ApiResponse;
import com.quickBite.dtos.requests.OrderRequest;
import com.quickBite.producer.OderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oders")
public class OderController {
    private final OderService oderService;

    public OderController(OderService oderService) {
        this.oderService = oderService;
    }
    @PostMapping("/place")
    public ResponseEntity<?> oder(@RequestBody OrderRequest request){
        try {
            oderService.placeOder(request);
            return new ResponseEntity<>(new ApiResponse("Oder placed, you will receive a notification", true),HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(new ApiResponse("Something went wrong",false),HttpStatus.BAD_REQUEST);
        }
    }
}
