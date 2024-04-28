package com.acme.springreactivewebservicecall.gateway;

import com.acme.springreactivewebservicecall.wsdl.ConsultaCEP;
import com.acme.springreactivewebservicecall.wsdl.ConsultaCEPResponse;
import com.acme.springreactivewebservicecall.wsdl.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class CorreiosGateway extends WebServiceGatewaySupport {

    @Value("${webservices.correios.info.user}")
    private String user;
    @Value("${webservices.correios.info.pass}")
    private String pass;

    public ConsultaCEPResponse buscarDetalhesCep(String cep) {
        ObjectFactory objectFactory = new ObjectFactory();
        ConsultaCEP consultaCEP = objectFactory.createConsultaCEP();
        consultaCEP.setCep(cep);
        consultaCEP.setUsuario(user);
        consultaCEP.setSenha(pass);

        JAXBElement<ConsultaCEP> jaxbRequest = objectFactory.createConsultaCEP(consultaCEP);
        JAXBElement<ConsultaCEPResponse> jaxbResponse =
                (JAXBElement<ConsultaCEPResponse>) getWebServiceTemplate()
                        .marshalSendAndReceive(jaxbRequest);
        return jaxbResponse.getValue();
    }

}
