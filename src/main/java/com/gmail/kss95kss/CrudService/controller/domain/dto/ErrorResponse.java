package com.gmail.kss95kss.CrudService.controller.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class ErrorResponse {

    @JsonProperty("error_code")
    @NotNull
    private String errorCode;

    @JsonProperty("error_message")
    @NotNull
    private String errorMessage;

    public static ErrorResponse.ErrorResponseBuilder builder() {
        return new ErrorResponse.ErrorResponseBuilder();
    }
    public ErrorResponse.ErrorResponseBuilder toBuilder() {
        return (new ErrorResponse.ErrorResponseBuilder()).errorCode(this.errorCode).errorMessage(this.errorMessage);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @JsonProperty("error_code")
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("error_message")
    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorResponse() {
    }

    public ErrorResponse(final String errorCode, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public static class ErrorResponseBuilder {
        private String errorCode;
        private String errorMessage;

        ErrorResponseBuilder() {
        }

        @JsonProperty("error_code")
        public ErrorResponse.ErrorResponseBuilder errorCode(final String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        @JsonProperty("error_message")
        public ErrorResponse.ErrorResponseBuilder errorMessage(final String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this.errorCode, this.errorMessage);
        }

        public String toString() {
            return "ErrorResponse.ErrorResponseBuilder(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
        }
    }
}
