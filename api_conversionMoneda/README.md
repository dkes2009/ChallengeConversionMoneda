# README #
ExplicaicoComponente ApiConversionMoneda

COMPONENTE:  ApiConversionMoneda

Actividad:
    Challenge Conversion Moneda

Desarrollador:
    Carlos Mario Aristizabal Acevedo

Fase 1
    Fecha elaboracion: 06/07/2024
    Version: 0.0.1
    Spring Boot
    Java Open JDK 11 

Notas:
Componente que realiza la conversion de una moneda a otra


Informacion de la api:
    Ambiente Desarrollo
    Para esta Api es necesario tener  el json de envio y realizar el consumo en el endpoint de  conversion de moneda,    
    en la carpeta de documentacion se adjunta la Collecion de Postman    
    

Como se Usa:
    1.se tiene un Endpoint /consultavalor
    Este endpoint recibe un Json  el cual contiene las siguientes variables
    "monedaOrigen":"AUD", (variable que trae el identificador de la moneda de origen del cliente)
    "valorMonedaOrigen": 10000,(variable que trae el valor de la moneda de origen del cliente)
    "monedaConvercion":"USD" (variable que trae el identificador de la moneda de conversion del cliente)

https://www.exchangerate-api.com/docs/authenticatio
la api  se conecta por http a una api exchangerate-api  en donde recupera el valor actual de cada moneda
este identificador se toma desde la variable del json "monedaConvercion" 
despues se ejecuta un metodo  donde hace la conversion  y genera un resultado con el valor  de la moneda solicitada a convertir 
respuesta exitosa :
{
"success": true,
"codigo": "200",
"dateTime": "2024/07/06 06:39",
"message": "Exitoso",
"valorMonedaConvercion": 41044304
}


    
    
    

