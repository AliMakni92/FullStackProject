package com.social.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.entities.Affectation;
import com.social.services.AffectationService;
import com.social.services.PayPalClient;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/paypal")
public class PayPalController {

	@Autowired
	AffectationService affectationService;
    private final PayPalClient payPalClient;
    @Autowired
    PayPalController(PayPalClient payPalClient){
        this.payPalClient = payPalClient;
    }

    @PostMapping(value = "/make/payment/{idAffectation}")
    public Map<String, Object> makePayment(@PathVariable("idAffectation") Long idAffectation,@RequestParam("sum") String sum){
    	Affectation affectation = affectationService.getAffectationById(idAffectation);
    	affectationService.makeStatusTrue(affectation);
    	
    	return payPalClient.createPayment(sum);
    }

    @PostMapping(value = "/complete/payment")
    public Map<String, Object> completePayment(HttpServletRequest request){
        return payPalClient.completePayment(request);
    }
}
