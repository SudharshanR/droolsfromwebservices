package com.myproject.controller;

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
public class ControllerClass {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerClass.class);
    WebservicesClass webservicesClass;
    
    public ControllerClass(){
    	webservicesClass = new WebservicesClass();
    }	
	
	@RequestMapping(value = "/droolstest",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getOrderInfo() {
        webservicesClass.callDroolsMethod();
	}
}