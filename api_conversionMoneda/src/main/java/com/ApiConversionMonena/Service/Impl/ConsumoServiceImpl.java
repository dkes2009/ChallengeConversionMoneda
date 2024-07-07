package com.ApiConversionMonena.Service.Impl;


import com.ApiConversionMonena.DTO.MonedarequesDto;
import com.ApiConversionMonena.DTO.RespuestaMonedaApiDto;
import com.ApiConversionMonena.Service.ConsumoService;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class ConsumoServiceImpl implements ConsumoService {


    @Override
    public RespuestaMonedaApiDto consultaValorMoneda(String urlConsumo, MonedarequesDto requestEntity) throws ExecutionException, InterruptedException {
        String stringRespuesta = "";
        int responseCode = 0;
        RespuestaMonedaApiDto response = new RespuestaMonedaApiDto();

        HttpClient client = HttpClient
                .newBuilder()
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlConsumo))
                .GET()
                .build();


        CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> respons = futureResponse.get();
        responseCode = respons.statusCode();

        respons.body();
        stringRespuesta = respons.body();

        JSONObject respuestaJsonObj = new JSONObject(stringRespuesta);

        JSONObject conversion_rates = (JSONObject) respuestaJsonObj.get("conversion_rates");

        Object valormoneda = conversion_rates.get(requestEntity.getMonedaConvercion());
        System.out.println("respuestaJsonObj" +valormoneda);
        RespuestaMonedaApiDto respuestaMedodo =  consultaValorMoneda(requestEntity.getMonedaOrigen(),requestEntity.getValorMonedaOrigen(),requestEntity.getMonedaConvercion(),valormoneda);


        if (responseCode == 200) {

            response.setSuccess(true);
            response.setCodigo(String.valueOf(responseCode));
            response.setMessage("Exitoso");
            response.setValorMonedaConvercion(respuestaMedodo.getValorMonedaConvercion());


        }

        return response;
    }


    public RespuestaMonedaApiDto consultaValorMoneda(String MonedaOrigen, double ValorMonedaOrigen,String MonedaConvercion, Object valormoneda){
        RespuestaMonedaApiDto respuestaMoneda = new RespuestaMonedaApiDto();
        System.out.println("MonedaOrigen"+MonedaOrigen);
        System.out.println("ValorMonedaOrigen"+ValorMonedaOrigen);
        System.out.println("MonedaConvercion"+MonedaConvercion);
        System.out.println("valormoneda"+valormoneda);

        double valorMonedaConvertir = Double.parseDouble(valormoneda.toString());

        double NewValorMonedaOrigen = valorMonedaConvertir;
        float valorTotalMoneada = (float) (ValorMonedaOrigen*valorMonedaConvertir);

      //  valorTotalMoneada = (float) ((double)Math.round(valorTotalMoneada*100)/100);

        System.out.println("valorTotalMoneada"+valorTotalMoneada);


        respuestaMoneda.setSuccess(true);
        respuestaMoneda.setCodigo("200");
        respuestaMoneda.setMonedaOrigen(MonedaOrigen);
        respuestaMoneda.setMonedaConvercion(MonedaConvercion);
        respuestaMoneda.setValorMonedaConvercion(valorTotalMoneada);



        return  respuestaMoneda;
    }



}