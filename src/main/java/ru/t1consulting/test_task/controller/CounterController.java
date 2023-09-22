package ru.t1consulting.test_task.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1consulting.test_task.service.CounterService;

@RestController
public class CounterController {

    private final CounterService counterService;
    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }


    /**
     * Method for processing requests, validation and sending to Service
     * @param stringToCount - is a string with any symbols. Spaces are not included in counting
     * @return ResponseEntity builder with body String
     */
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Counting symbols in a string"
        ),
            @ApiResponse(
                    responseCode = "400",
                    description = "String is blank"
            )
    })
    @GetMapping("count")
    public ResponseEntity<String> getStringCounting(@Parameter(description = "A string for counting symbols", example = "aaabbc") @RequestParam String stringToCount) {
        if (stringToCount == null || stringToCount.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(counterService.getStringCounting(stringToCount));
    }
}
