package com.oocl.web.sampleWebApp;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.rmi.CORBA.ValueHandler;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith( SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleEntityControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void should_get_hello_message() throws Exception{
        final MvcResult result = mvc.perform(
                get("/singleEntity")).andReturn();

        final MockHttpServletResponse response = result.getResponse();
        assertEquals(200,response.getStatus());

    }

    @Test
    public void should_get_message() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get( "/singleEntity" ))
                .andExpect( jsonPath("name",is("ABC") ).exists()
        );


//
//
//        final MvcResult result = mvc.perform( get("/singleEntity") ).andReturn();
//        final String json =result.getResponse().getContentAsString();
//        final ObjectMapper objectMapper = new ObjectMapper( );
//        final SingleEntity singleEntity = objectMapper.readValue(json,SingleEntity.class);
//
//        assertEquals( "hello",SingleEntity.get );

    }

    






}
