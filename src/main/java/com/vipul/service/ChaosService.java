package com.vipul.service;

import com.vipul.model.ServiceSelection;

import de.codecentric.spring.boot.chaos.monkey.configuration.AssaultProperties;

public interface ChaosService {

	public String updateAssaultProperties(ServiceSelection serviceSelection);

	public AssaultProperties getAssaultSettings(ServiceSelection serviceSelection);

	public String enableChaosMonkey(ServiceSelection serviceSelection);

	public String disableChaosMonkey(ServiceSelection serviceSelection);
}
