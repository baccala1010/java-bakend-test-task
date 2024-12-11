package com.example.demo.controllers;

import com.example.demo.dto.MeasurementDTO;
import com.example.demo.models.Measurement;
import com.example.demo.models.Sensor;
import com.example.demo.services.MeasurementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MeasurementController.class)
class MeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MeasurementService measurementService;

    @Test
    public void MeasurementController_AddMeasurement_ReturnsResponseEntityString() throws Exception{

            MeasurementDTO measurementDTO = new MeasurementDTO(1.2 , false , new Sensor());
            doNothing().when(measurementService).addMeasurement(
                    measurementDTO.getValue(),
                    measurementDTO.getRaining(),
                    measurementDTO.getSensor().getName()
            );

            mockMvc.perform(post("/measurements/add")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"value\":1.2,\"raining\":false,\"sensor\":{\"name\":\"Sensor1\"}}")
                            .with(csrf())
                            .with(user("testUser").password("testPassword").roles("USER"))
                    )
                    .andExpect(status().isOk())
                    .andExpect(content().string("Measurement added successfully!"));
        }

    @Test
    public void MeasurementController_GetAllMeasurements_ReturnsResponseEntityListMeasurement() throws Exception{

        List<Measurement> measurementList = Arrays.asList(new Measurement());
        when(measurementService.getAllMeasurements()).thenReturn(measurementList);

        mockMvc.perform(get("/measurements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(user("testUser").password("testPassword").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}]"));

    }

    @Test
    public void MeasurementController_GetRainyDaysCount_ReturnsResponseEntityLong() throws Exception{

        long rainyDays = 3;
        when(measurementService.getRainyDaysCount()).thenReturn(rainyDays);

        mockMvc.perform(get("/measurements/rainyDaysCount")
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(user("testUser").password("testPassword").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));

    }


}