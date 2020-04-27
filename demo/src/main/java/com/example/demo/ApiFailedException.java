package com.example.demo;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class holds the NotFoundException.

 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
@Getter
public class ApiFailedException extends Exception{


  private ErrorResponse errResponse;

  private String errCode;

  private String errMsg;

  private String errSubcode;

  private String errTraceId;

  /**
   * produces the error response based on the any fatal issues/errors.
   */
  public ErrorResponse getErrorResponse() {
    if (errResponse == null) {
    	errResponse = new ErrorResponse();
    	errResponse.setErrorCode(this.getErrCode());
    	errResponse.setErrorMessage(this.getErrMsg());
    	errResponse.setErrorSubcode(this.getErrSubcode());
    	errResponse.setTraceId(this.getErrTraceId());
    }
    return errResponse;
  }

  public ApiFailedException() {
    super();
  }

  /**
   *
   * @param message - exception message.
   */
  public ApiFailedException(String message) {
    super(message);
  }

  /**
   *
   * @param errorCode - status code.
   * @param errorMessage - error message to be displayed.
   */
  public ApiFailedException(String errorCode, String errorMessage) {
    super(errorMessage);
    this.errCode = errorCode;
    this.errMsg = errorMessage;
  }

  /**
   *
   * @param errorCode - status code.
   * @param errorMessage - error message to be displayed.
   * @param errorSubcode - status sub code.
   * @param traceId - on item which error occured.
   */
  public ApiFailedException(String errorCode, String errorMessage, String errorSubcode,
                            String traceId) {
    super(errorMessage);
    this.errCode = errorCode;
    this.errMsg = errorMessage;
    this.errSubcode = errorSubcode;
    this.errTraceId = traceId;
  }
}
