package com.digitalfactory.vaccnow.resourcse;

import com.digitalfactory.vaccnow.bussiness.dto.VaccinationDTO;
import com.digitalfactory.vaccnow.bussiness.service.PaymentMethodService;
import com.digitalfactory.vaccnow.bussiness.service.VaccinationService;
import com.digitalfactory.vaccnow.exception.TimeScheduleNotAvailableException;
import com.digitalfactory.vaccnow.resource.VaccinationController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.digitalfactory.vaccnow.util.JsonUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VaccinationController.class)
@AutoConfigureMockMvc
public class VaccinationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VaccinationService vaccinationService;
    @MockBean
    private PaymentMethodService paymentMethodService;

    @Before
    public void setup() throws Exception {
        VaccinationDTO vaccinationDTO431 = new VaccinationDTO(4, 3, 1);
        Mockito.when(vaccinationService.saveClientVaccinationSchedule(any(VaccinationDTO.class))).
                thenThrow(TimeScheduleNotAvailableException.class);
    }

    @Test
    public void testConfirmSchedule() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/vaccination/confirm/{vaccinationId}", 4))
                .andExpect(status().isOk());

    }

    @Test
    public void testScheduleVaccinationNotAvailable() throws Exception {
        VaccinationDTO vaccinationDTO431 = new VaccinationDTO(4, 3, 1);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/vaccination/schedule").
                        contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(vaccinationDTO431)))
                .andExpect(status().isConflict())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof TimeScheduleNotAvailableException));

    }



}
