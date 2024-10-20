package com.sales.management.model.generic;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class ErrorServiceResponse implements Serializable {
    private String reference = UUID.randomUUID().toString();
    private String englishMessage = "";
    private String arabicMessage = "";
    private String code = "";
    private String description = "";
}
