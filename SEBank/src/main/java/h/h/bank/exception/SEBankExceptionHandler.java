package h.h.bank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // controller와 동일함
public class SEBankExceptionHandler {

	@ExceptionHandler (Exception.class) // exception 부모
	public String errorHandler() {
		return "/error";
	}
}
