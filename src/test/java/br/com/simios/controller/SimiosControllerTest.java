package br.com.simios.controller;

import br.com.simios.dto.DnaDTO;
import br.com.simios.dto.StatsDTO;
import br.com.simios.service.SimiosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(SimiosController.class)
public class SimiosControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SimiosService service;

    private StatsDTO statsDTO = new StatsDTO(1,1,0.4);

    @Test
    public void givenSimian_thenReturnHttpStatusOK() throws Exception {

        given(service.isSimian(Mockito.any())).willReturn(true);

        mvc.perform(MockMvcRequestBuilders.post("/simian")
                .content(asJsonString(new DnaDTO()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNotSimian_thenReturnHttpStatusForbidden() throws Exception {

        given(service.isSimian(Mockito.any())).willReturn(false);

        mvc.perform(MockMvcRequestBuilders.post("/simian")
                .content(asJsonString(new DnaDTO()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void getStatus_thenReturnStatus() throws Exception {

        given(service.getStatus()).willReturn(statsDTO);

        mvc.perform(MockMvcRequestBuilders.get("/stats"))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
