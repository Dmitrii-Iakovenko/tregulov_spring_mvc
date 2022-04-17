package com.wutreg.spring_rest.dto;

public class EmployeeExceptionDTO {

    private String errorMessage;

    public EmployeeExceptionDTO() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
