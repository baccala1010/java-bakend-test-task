package com.example.demo;

import com.example.demo.config.JwtAuthenticationFilter;
import com.example.demo.config.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

	@MockBean
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@MockBean
	private JwtUtils jwtUtils;

	@Test
	void contextLoads() {
	}

}
