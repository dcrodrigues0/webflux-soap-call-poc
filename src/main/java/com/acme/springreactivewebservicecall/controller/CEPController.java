package com.acme.springreactivewebservicecall.controller;

import com.acme.springreactivewebservicecall.services.CEPService;
import com.acme.springreactivewebservicecall.wsdl.ConsultaCEPResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/correios")
public class CEPController {

    private CEPService cepService;

    public CEPController(CEPService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<ConsultaCEPResponse> consultaCEP(@RequestParam String cep){
        return ResponseEntity.ok(cepService.consultaCEP(cep));
    }

}
