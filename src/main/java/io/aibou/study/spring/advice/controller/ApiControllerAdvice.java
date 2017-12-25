package io.aibou.study.spring.advice.controller;


import io.aibou.study.spring.exception.BadRequestException;
import io.aibou.study.spring.exception.DatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by aibou on 2017/04/25.
 */
@ControllerAdvice(basePackageClasses = io.aibou.study.spring.controller.ApiController.class)
public class ApiControllerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ApiControllerAdvice.class);

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(BadRequestException e) {
		logger.error(e.getMessage());
		return "hoge";
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(DatabaseException e) {
		logger.error(e.getMessage());
		return "fuga";
	}
}
