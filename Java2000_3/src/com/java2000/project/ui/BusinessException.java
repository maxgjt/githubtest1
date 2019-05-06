package com.java2000.project.ui;

public class BusinessException  extends RuntimeException{
    public BusinessException() {
        super();
    }
    public BusinessException(String errorMessage){
        super(errorMessage);
    }
}
