package com.sales.management.model.generic;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGeneric {
    private String errorCode = "0";
    private String errorDescription = "";

    private ErrorServiceResponse errorServiceResponse = new ErrorServiceResponse();


}
