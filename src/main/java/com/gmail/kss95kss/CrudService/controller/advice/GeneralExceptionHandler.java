package com.gmail.kss95kss.CrudService.controller.advice;

import com.gmail.kss95kss.CrudService.controller.domain.dto.ErrorResponse;
import com.gmail.kss95kss.CrudService.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    public static final String DEFAULT_ERROR_CODE = "000001";

    @ExceptionHandler(value = {DuplicateVinCodeException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorResponse handleDuplicateVinCodeException(DuplicateVinCodeException e) {
        var errorMessage = e.getMessage();
        LOG.warn("Incorrect VIN-CODE (Duplicate): {}", errorMessage);
        return handleExceptionMessage("409001", "Incorrect VIN-CODE (Duplicate)");
    }

    @ExceptionHandler(value = {DefaultClientException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleDefaultClientException(DefaultClientException e) {
        var errorMessage = e.getMessage();
        LOG.warn("Something got wrong: {}", errorMessage);
        return handleExceptionMessage(errorMessage);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleNullPointerException(NullPointerException e) {
        var errorMessage = e.getMessage();
        LOG.warn("Something got wrong: {}", errorMessage);
        return handleExceptionMessage(errorMessage);
    }

    @ExceptionHandler(value = {CompanyCarsIsFullException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleCompanyCarsIsFullException() {
        var errorMessage = "Company allready have 10 cars";
        var errorCode= "40002";
        LOG.warn(errorMessage);
        return handleExceptionMessage(errorCode,errorMessage);
    }

    @ExceptionHandler(value = {CarAlreadyInCompanyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleCarAlreadyinCompanyException() {
        var errorMessage = "Car already have Company";
        var errorCode= "40003";
        LOG.warn(errorMessage);
        return handleExceptionMessage(errorCode,errorMessage);
    }

    @ExceptionHandler(value = {CarNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleCarNotFoundException() {
        var errorMessage = "Car not found";
        var errorCode= "40004";
        LOG.warn(errorMessage);
        return handleExceptionMessage(errorCode,errorMessage);
    }

    @ExceptionHandler(value = {CompanyNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleCompanyNotFoundException() {
        var errorMessage = "Company not found";
        var errorCode= "40005";
        LOG.warn(errorMessage);
        return handleExceptionMessage(errorCode,errorMessage);
    }
    private static ErrorResponse handleExceptionMessage(String exceptionMessage) {
        return handleExceptionMessage(DEFAULT_ERROR_CODE, exceptionMessage);
    }

    private static ErrorResponse handleExceptionMessage(String errorCode, String errorMessage) {
        return ErrorResponse.builder()
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
    }
}
