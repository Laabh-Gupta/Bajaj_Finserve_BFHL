package com.example.bajaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @PostMapping("/bfhl") // [cite: 30]
    public ResponseEntity<DataResponse> processData(@RequestBody DataRequest request) {
        try {
            DataResponse response = dataProcessingService.process(request);
            return new ResponseEntity<>(response, HttpStatus.OK); // [cite: 31]
        } catch (Exception e) {
            DataResponse errorResponse = new DataResponse();
            errorResponse.setSuccess(false); // [cite: 26]
            errorResponse.setUserId("your_full_name_ddmmyyyy"); // Must be present
            // Populate other fields with empty/default values if needed
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}