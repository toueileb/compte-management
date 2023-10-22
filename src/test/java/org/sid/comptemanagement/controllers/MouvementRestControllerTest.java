package org.sid.comptemanagement.controllers;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sid.comptemanagement.dto.MouvementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MouvementRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testGetMouvementsByCompteId() throws Exception {

        Long compteId = 1L;
        String uri = "/mouvements/compte/" + compteId;


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertResultOkSansException(mvcResult);

        List<MouvementDto> mouvementDtos = mapListFromJson(mvcResult, MouvementDto.class);
        MouvementDto mouvementDto = mouvementDtos.get(0);
        assertEquals(7, mouvementDtos.size());
        assertEquals(Long.valueOf(49), mouvementDto.getJour());
        assertEquals("REF 49", mouvementDto.getReference());
        assertEquals(new BigDecimal("4900.00"), mouvementDto.getSolde());
    }

    protected <T> List<T> mapListFromJson(MvcResult mvcResult, Class<T> elementClass) throws IOException {
        String json = mvcResult.getResponse().getContentAsString();
        JavaType type = this.objectMapper.getTypeFactory().constructParametricType(List.class, elementClass);
        return this.objectMapper.readValue(json, type);
    }

    protected static void assertResultOkSansException(MvcResult mvcResult) {
        assertEquals(SC_OK, mvcResult.getResponse().getStatus());
        assertNull(mvcResult.getResolvedException());
    }
}