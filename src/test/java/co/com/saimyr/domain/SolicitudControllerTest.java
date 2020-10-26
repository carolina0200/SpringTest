package co.com.saimyr.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SolicitudControllerTest {
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new SolicitudController()).build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Solicitud solicitud;

    @BeforeEach
    void setUp() {
        Integrante integrante = new Integrante("Julian", "Jefe", 2280500);
        Integrante integrante1 = new Integrante("Maria", "Primo", 1580500);
        ArrayList<Integrante> integrantes = new ArrayList<>();
        integrantes.add(integrante);
        integrantes.add(integrante1);
        solicitud = new Solicitud("6", 57, integrantes);
    }

    @Test
    void esRespuesta200() throws Exception {
        mockMvc.perform(get("/get/all")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void esError404() throws Exception {
        mockMvc.perform(get("/get/all-solicitudes")
                .contentType("application/json"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void guardarSolicitud() throws Exception {
        mockMvc.perform(post("/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk());
    }

    @Test
    void esError400() throws Exception {
        mockMvc.perform(post("/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString("Mal")))
                .andExpect(status().isBadRequest());
    }

    @Test
    void esIgualObjeto() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(solicitud)))
                .andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(), objectMapper.writeValueAsString(solicitud));
    }
}