package com.mrknight.webclients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ForecastController {

  @GetMapping("/forecast")
  Flux<String> getAll() {
    /*
     * Servicio que aglutina la llamada a la previsión del servicio de Weather
     * 1. Temperatura
     * 2. Prevision
     * 3. Lluvia
     * Etc.
     */
    Flux<String> resp = Flux.just("Prueba");

    return resp;
  }

}
