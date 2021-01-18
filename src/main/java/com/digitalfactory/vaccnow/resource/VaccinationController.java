package com.digitalfactory.vaccnow.resource;

import com.digitalfactory.vaccnow.bussiness.dto.VaccinationDTO;
import com.digitalfactory.vaccnow.bussiness.service.PaymentMethodService;
import com.digitalfactory.vaccnow.bussiness.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    private PaymentMethodService paymentMethodService;
    @Autowired
    private VaccinationService vaccinationService;

    @GetMapping("/payment-method")
    public ResponseEntity<?> getPaymentMethods() {
        return ResponseEntity.ok(paymentMethodService.getPaymentMethods());
    }

    @PostMapping("/schedule")
    public ResponseEntity<?> scheduleVaccination(@RequestBody VaccinationDTO vaccinationDTO) {
        return ResponseEntity.ok(this.vaccinationService.saveClientVaccinationSchedule(vaccinationDTO));
    }

    @PutMapping("/confirm/{vaccinationId}")
    public ResponseEntity<?> confirmSchedule(@PathVariable("vaccinationId") long vaccinationId) {
        this.vaccinationService.confirmVaccination(vaccinationId);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
