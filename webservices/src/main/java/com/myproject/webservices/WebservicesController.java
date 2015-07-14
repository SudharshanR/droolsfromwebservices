package com.myproject.webservices;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.webservices.WebservicesClass;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WebservicesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebservicesController.class);
    StatelessKieSession kSession;
    KieServices kieService;
    KieContainer kContainer;
    
    public WebservicesController() {
        kieService = KieServices.Factory.get();
        kContainer = kieService.getKieClasspathContainer();
    }
	
	@RequestMapping(value = "/droolstest",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getOrderInfo() {
		String kSessionName = "samplerule";
        kSession = kContainer.newStatelessKieSession(kSessionName);	
        WebservicesClass webservicesClass = new WebservicesClass();
        webservicesClass.callDroolsMethod(kSession);
	}
}