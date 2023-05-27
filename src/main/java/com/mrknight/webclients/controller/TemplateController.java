package com.mrknight.webclients.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

  @RequestMapping("/helloWorld")
  public String hello(Model modelo) {

    /*
     * Habría que añadir la llamada con WebClient para poder mandar la info a la Web
     */

    modelo.addAttribute("mensaje", "Hello World!");

    return "helloWorld";
  }

}
