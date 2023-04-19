package com.gmail.kss95kss.CrudService.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.kss95kss.CrudService.controller.CrudServiceController;
import com.gmail.kss95kss.CrudService.controller.domain.dto.ServiceOperationResponse;
import com.gmail.kss95kss.CrudService.utilities.TestData;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Set;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class CrudServiceApiTest extends AbstractRestControllerTest {
    @Autowired
    private CrudServiceController controller;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    @SneakyThrows
    void ifFindAllCarThenSuccess() {
        var cars = TestData.getCars();
        var response =objectMapper.writeValueAsString(new ServiceOperationResponse(cars));
        when(carService.findAllCar()).thenReturn(cars);

        mockMvc.perform(get("/api/allCars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    @SneakyThrows
    void ifFindCarByIdThenSuccess() {
        var cars = TestData.getCars();
        var response =objectMapper.writeValueAsString(new ServiceOperationResponse(cars));
        when(carService.findAllCar()).thenReturn(cars);

        mockMvc.perform(get("/api/allCars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }




    private String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/testRequests/" + fileName)), StandardCharsets.UTF_8);
    }
    private String getAllCarsResponse() throws IOException {
        return readFile("payment-request-missing-fields.json");
    }
}
