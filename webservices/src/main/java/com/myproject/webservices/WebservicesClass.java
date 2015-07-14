package com.myproject.webservices;

import org.kie.api.runtime.StatelessKieSession;

public class WebservicesClass {
	public void callDroolsMethod(StatelessKieSession kSession){
		Properties prop = new Properties();
		System.out.println("String before drools >>>>>>> "+prop.getResult());
		kSession.execute(prop);
		System.out.println("String after drools >>>>>>> "+prop.getResult());
	}
}
