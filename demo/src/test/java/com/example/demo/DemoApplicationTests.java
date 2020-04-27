package com.example.demo;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.example.demo.MonthlyDataServiceImpl;
import java.net.URI;

@SpringBootTest(classes = DemoApplicationTests.class)
class DemoApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testRetrievePublicServiceData() {
		URI requestUri = URI.create(String.format("http://covidtracking.com/api/cdc/daily"));


	}

	@Test
	public void testRetrieveMonthlyData() {
		CovidTrackingServiceResponseDto covidTrackingServiceResponseDto = new CovidTrackingServiceResponseDto("4/18", "5674");
		CasesDataResponse casesDataResponse = new MonthlyDataServiceImpl().retrievePublicServiceData().getDetails();
		assertNotNullEquals(casesDataResponse);
	}
}
