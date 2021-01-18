package com.digitalfactory.vaccnow.resource;

import com.digitalfactory.vaccnow.bussiness.service.BranchService;
import com.digitalfactory.vaccnow.bussiness.service.TimeScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
@CrossOrigin(origins = "http://localhost:4200")
public class AvailabilityController {

    private BranchService branchService;
    private TimeScheduleService timeScheduleService;

    @Autowired
    public AvailabilityController(BranchService branchService, TimeScheduleService timeScheduleService) {
        this.branchService = branchService;
        this.timeScheduleService = timeScheduleService;
    }

    @GetMapping(path = "")
    public ResponseEntity<?> getAllBranchesNames() {
        return ResponseEntity.ok(branchService.getAllBranchesNames());
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @GetMapping(path = "/available-times/{branchId}")
    public ResponseEntity<?> getAvailableTimeForBranch(@PathVariable("branchId") long branchId,
                                                       @RequestParam Optional<Long> from,
                                                       @RequestParam Optional<Long> to) {
        return ResponseEntity.ok(timeScheduleService.getAvailableTimeForBranch(branchId, from, to));
    }
}
