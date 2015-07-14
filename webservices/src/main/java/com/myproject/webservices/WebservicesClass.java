package com.myproject.webservices;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class WebservicesClass {
    StatelessKieSession kSession;
    KieServices kieService;
    KieContainer kContainer;
	
	public WebservicesClass(){
        kieService = KieServices.Factory.get();
        kContainer = kieService.getKieClasspathContainer();		
	}
	
	public void callDroolsMethod(){
		String kSessionName = "samplerule";
        kSession = kContainer.newStatelessKieSession(kSessionName);	
		Properties prop = new Properties();
		
		System.out.println("String before drools >>>>>>> "+prop.getResult());
		kSession.execute(prop);
		System.out.println("String after drools >>>>>>> "+prop.getResult());
	}
}
