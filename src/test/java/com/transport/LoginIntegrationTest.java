package com.transport;

import com.transport.dao.InquiryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest
public class LoginIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private InquiryRepository inquiryRepository;

    @Test
    public void givenUser_whenPerformingGet_thenReturnsIndex() throws Exception {
        mockMvc.perform(get("/login")
                .with(user("admin").password("password")))
                .andExpect(status().isOk())
                .andExpect(view().name("inquiries"));
    }

}
