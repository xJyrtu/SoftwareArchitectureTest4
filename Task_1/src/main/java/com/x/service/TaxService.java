package com.x.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "TaxService",
targetNamespace = "http://service.x.com")
public interface TaxService {
    @WebMethod
    public String calculateTax(@WebParam double income);

}
