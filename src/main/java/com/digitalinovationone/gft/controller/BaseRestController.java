package com.digitalinovationone.gft.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.digitalinovationone.gft.exception.BusinessErrorMessage;
import com.digitalinovationone.gft.exception.BusinessException;
import com.digitalinovationone.gft.util.BundleUtil;

public class BaseRestController {
	
	private Logger logger = LoggerFactory.getLogger(BaseRestController.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	List<BusinessErrorMessage> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<BusinessErrorMessage> erros = new ArrayList<>();
		
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			erros.add(criarMensagemRetornoTo(true, e, "error.invalid.input.field", new Object[] {fieldError.getDefaultMessage(), fieldError.getField()}));
		}
		
		return erros;
	}
		
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	List<BusinessErrorMessage> onBusinessException(BusinessException e) {
		logger.error(e.getMessage(), e);
		
		List<BusinessErrorMessage> erros = new ArrayList<>();
		
		erros.add(criarMensagemRetornoTo(true, e, e.getMessage(), e.getArgs()));
		
		return erros;
	}
	
    private static BusinessErrorMessage criarMensagemRetornoTo(boolean isLightWeigth, Throwable excecao, String codMensagem, Object... args) {
        String detalhe = BundleUtil.getText(codMensagem, args);
        
        BusinessErrorMessage mensagemRetornoTo = new BusinessErrorMessage();
        mensagemRetornoTo.setCodigo(codMensagem);
        mensagemRetornoTo.setMessage(detalhe);
        mensagemRetornoTo.setDataHora(LocalDateTime.now());
        
        String stackTracer = excecao == null ? StringUtils.EMPTY : ExceptionUtils.getStackTrace(excecao);

        mensagemRetornoTo.setStackTrace(isLightWeigth ? null : stackTracer);
        
        return mensagemRetornoTo;
    }
}
