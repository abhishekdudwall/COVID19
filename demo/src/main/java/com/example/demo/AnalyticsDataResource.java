package com.example.demo;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * REST Resource to get the COVID 19 Analytics Data
 */

@RestController
@RequestMapping("v1/COVID19")
public class AnalyticsDataResource {

	@Autowired
	MonthlyDataServiceImpl demoService;

	/**
	 * Method to retrieve list of COVID19 Monthly Data
	 *
	 * @param request
	 *            HttpServletRequest
	 * 
	 * @return ResponseEntity ResponseEntity
	 * @throws BusinessException
	 * @throws BadRequestException
	 */
	@ApiOperation(value = "Retrieves the monthly COVID19 data")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved case notifications", response = CasesDataResponse.class)
			/*@ApiResponse(code = 400, message = "Business validation errors", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Case not found errors", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "UnAuthorized Access", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "No Permission", response = ErrorResponse.class) */
	}
			)
		@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET, value = "/monthlyCOVID19Cases")
	public ResponseEntity getMonthlyData()
			throws BadRequestException, NotFoundException
			{
		ResponseEntity responseEntity = null;
		CasesDataResponse casesDataResponse = null;
		casesDataResponse = demoService.retrieveMonthlyData();
		responseEntity = new ResponseEntity(casesDataResponse, HttpStatus.OK);
		return responseEntity;
	}

}
