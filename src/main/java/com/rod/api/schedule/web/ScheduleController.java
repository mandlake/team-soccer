package com.rod.api.schedule.web;


import com.rod.api.schedule.model.ScheduleDTO;
import com.rod.api.schedule.service.ScheduleService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@ApiResponses(value = {
    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
    @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("/api/schedules")
@Log4j2
@RestController
public class ScheduleController {
    private final ScheduleService service;
    private final ScheduleRouter router;

    @GetMapping("/problem23")
    private List<String> problem23(@RequestParam("date1") String date1,
                                        @RequestParam("date2") String date2){
        return service.problem23(date1, date2);
    }

    @GetMapping("/findAll")
    private List<?> getAllSchedules(){
        return service.getAllSchedules();
    }

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchPlayer(@RequestParam("q") String q,
                                          @RequestParam(value = "startDate", required = false) String startDate,
                                          @RequestParam(value = "endDate", required = false) String endDate) {
        List<?> o = router.execute(q, startDate, endDate);
        return ResponseEntity.ok(o);
    }
}
