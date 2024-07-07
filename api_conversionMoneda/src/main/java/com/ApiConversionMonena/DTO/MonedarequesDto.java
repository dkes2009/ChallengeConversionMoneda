package com.ApiConversionMonena.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder
@Data
public class MonedarequesDto {


    //private int id;
    private String monedaOrigen;
    private double valorMonedaOrigen;
    private String monedaConvercion;



}
