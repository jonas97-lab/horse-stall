package novi.horsestall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HorseStallApplication.class)
@AutoConfigureMockMvc
@EnableConfigurationProperties
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturn200ForEndpointUsers() throws Exception {
        mockMvc.perform(get("/users").with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200ForEndpointMemberships() throws Exception {
        mockMvc.perform(get("/memberships").with(user("user").roles("USER")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200ForEndpointHorses() throws Exception {
        mockMvc.perform(get("/horses").with(user("user").roles("USER")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200ForEndpointHorseStalls() throws Exception {
        mockMvc.perform(get("/horsestalls").with(user("user").roles("USER")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200ForEndpointCustomers() throws Exception {
        mockMvc.perform(get("/customers").with(user("user").roles("USER")))
                .andExpect(status().isOk());
    }
}