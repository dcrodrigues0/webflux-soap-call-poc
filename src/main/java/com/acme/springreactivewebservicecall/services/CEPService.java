package com.acme.springreactivewebservicecall.services;


import com.acme.springreactivewebservicecall.gateway.CorreiosGateway;
import com.acme.springreactivewebservicecall.wsdl.ConsultaCEPResponse;
import org.springframework.stereotype.Service;

@Service
public class CEPService {

    private CorreiosGateway correiosGateway;

    public CEPService(CorreiosGateway correiosGateway) {
        this.correiosGateway = correiosGateway;
    }

    public ConsultaCEPResponse consultaCEP(String cep){
        return correiosGateway.buscarDetalhesCep(cep);
    }
}
