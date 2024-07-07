package com.ApiConversionMonena.Controller;


import com.ApiConversionMonena.DTO.MonedarequesDto;
import com.ApiConversionMonena.DTO.RespuestaMonedaApiDto;
import com.ApiConversionMonena.Service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ConsumoController {

    private static final String ERRORDATA = "ERROR EN EL INGRESO DE DATOS";




    @Value("${urlGetInoformationByClient}")
    private String urlInoformationClient;
    @Value("${you-api-key}")
    private String you_api_key;
    @Value("${finUrl}")
    private String finUrl;

    @Autowired
    private ConsumoService endpointService;

    @PostMapping("/consultavalor")
    public RespuestaMonedaApiDto consultavalor(@RequestBody MonedarequesDto requestEntity, HttpServletRequest request, HttpServletResponse httpResponse) throws ExecutionException, InterruptedException {

        RespuestaMonedaApiDto response = new RespuestaMonedaApiDto();
            String urlConsumo= urlInoformationClient+ you_api_key+finUrl;
            System.out.printf("Datos de entrada son: "+requestEntity);
            response = endpointService.consultaValorMoneda(urlConsumo,requestEntity);




        return response;
    }


}