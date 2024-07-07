package com.ApiConversionMonena.Service;


import com.ApiConversionMonena.DTO.MonedarequesDto;
import com.ApiConversionMonena.DTO.RespuestaMonedaApiDto;

import java.util.concurrent.ExecutionException;

public interface ConsumoService {

    RespuestaMonedaApiDto consultaValorMoneda(String urlConsumo, MonedarequesDto requestEntity) throws ExecutionException, InterruptedException;

}
