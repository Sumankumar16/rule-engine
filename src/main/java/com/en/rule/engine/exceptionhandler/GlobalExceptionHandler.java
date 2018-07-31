package com.en.rule.engine.exceptionhandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.en.rule.engine.controller.RuleController;
import com.en.rule.engine.model.ApiErrorResponseTemplate;
import com.en.rule.engine.model.MetaData;

/***
 * 
 * @author Suman Kumar
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger LOG = LoggerFactory.getLogger(RuleController.class);

	/***
	 * This will catch any IllegalArgumentException thrown throughout the project.
	 * @param req
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public final ResponseEntity<ApiErrorResponseTemplate> handleIllegalArgumentException(HttpServletRequest req,
			Exception ex) {

		UUID id = UUID.randomUUID();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());

		LOG.error("=================================================================");
		LOG.error("Id : " + id);
		LOG.error("Timestamp : " + timeStamp);
		LOG.error("Request URL : " + req.getRequestURL().toString());
		LOG.error("Request Method : " + req.getMethod());
		LOG.error("Error Message : " + ex.getMessage());
		LOG.error("Error stack trace ", ex);
		ApiErrorResponseTemplate apiResponse = new ApiErrorResponseTemplate();
		MetaData metaData = new MetaData();
		metaData.setMessage(ex.getMessage());
		metaData.setCode(HttpStatus.BAD_REQUEST.value());
		apiResponse.setMetadata(metaData);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
	}

	/**
	 * This will catch any MethodArgumentNotValidException thrown throughout the
	 * project.
	 * @param req
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<ApiErrorResponseTemplate> handleMethodArgumentNotValidException(HttpServletRequest req,
			MethodArgumentNotValidException ex) {

		UUID id = UUID.randomUUID();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());

		LOG.error("=================================================================");
		LOG.error("Id : " + id);
		LOG.error("Timestamp : " + timeStamp);
		LOG.error("Request URL : " + req.getRequestURL().toString());
		LOG.error("Request Method : " + req.getMethod());
		LOG.error("Error Message : " + ex.getMessage().toString());
		LOG.error("Error stack trace ", ex);
		ApiErrorResponseTemplate apiResponse = new ApiErrorResponseTemplate();
		MetaData metaData = new MetaData();
		metaData.setCode(HttpStatus.BAD_REQUEST.value());
		apiResponse.setMetadata(metaData);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);

	}

	/***
	 * Any generic exception throughout the project will be handled by this method.
	 * @param req
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApiErrorResponseTemplate> handleInternalServerException(HttpServletRequest req,
			Exception ex) {

		UUID id = UUID.randomUUID();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());

		LOG.error("=================================================================");
		LOG.error("Id : " + id);
		LOG.error("Timestamp : " + timeStamp);
		LOG.error("Request URL : " + req.getRequestURL().toString());
		LOG.error("Request Method : " + req.getMethod());
		LOG.error("Error Message : " + ex.getMessage());
		LOG.error("Error stack trace ", ex);

		ApiErrorResponseTemplate apiResponse = new ApiErrorResponseTemplate();
		MetaData metaData = new MetaData();
		metaData.setMessage(ex.getMessage());
		metaData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		apiResponse.setMetadata(metaData);
		System.out.println("internal server error!");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
	}
}
