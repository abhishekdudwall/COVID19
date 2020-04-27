package com.example.demo;


import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

/**

 */

@Service
public class MonthlyDataServiceImpl implements MonthlyService{

	/**
	 * The rest template class to invoke the service
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MonthlyDataHelper monthlyDatahelper;

	@Override
	public CasesDataResponse retrieveMonthlyData() {
		CovidTrackingServiceResponseDto covidTrackingServiceResponseDto= retrievePublicServiceData();
		if (covidTrackingServiceResponseDto != null) {
			return prepareMonthlyCasesData(covidTrackingServiceResponseDto);

		}
		return new CasesDataResponse();
	}

	public CovidTrackingServiceResponseDto retrievePublicServiceData() {
		URI requestUri = URI.create(String.format("http://covidtracking.com/api/cdc/daily"));
		RequestEntity requestEntity = new RequestEntity(HttpMethod.GET, requestUri);
		ResponseEntity<CovidTrackingServiceResponseDto> response = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<CovidTrackingServiceResponseDto>() {
				});
		/*if (null == response) {
			// throw APIFAILEDException exception
			throw new ;
		}*/

		CovidTrackingServiceResponseDto covidTrackingServiceResponseDto = response.getBody();
		HttpHeaders headers = response.getHeaders();

		if (covidTrackingServiceResponseDto != null) {


		}
		return covidTrackingServiceResponseDto;
	}

	}
