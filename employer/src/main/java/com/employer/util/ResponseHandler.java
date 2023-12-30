package com.employer.util;

import com.employer.model.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ResponseHandler {

    private ResponseHandler() {

    }

    public static ResponseEntity<ApiResponse> generateResponse(HttpStatus httpStatus,
                                                               String responseMessage,
                                                               String responseCode,
                                                               Object data) {

        return ResponseEntity
                .status(httpStatus)
                .body(new ApiResponse(
                        responseMessage,
                        responseCode,
                        data,
                        new ArrayList<>()));
    }
}
