package com.x.service.Impl;


import com.x.service.TaxService;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@WebService(name = "TaxService",
targetNamespace = "http://service.x.com",
endpointInterface ="com.x.service.TaxService" )
@Service
public class TaxServiceImpl implements TaxService {
    @Override
    public String calculateTax(double income) {
        double tax;
        if (income <= 5000) {
            tax = 0;
        } else if (income <= 30000) {
            tax = (income - 5000) * 0.1;
        } else {
            tax = 2500 + (income - 30000) * 0.2; // 示例税率
        }

        return "个人所得税为： "+tax;
    }
}
