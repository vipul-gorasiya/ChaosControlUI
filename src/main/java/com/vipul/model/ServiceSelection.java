package com.vipul.model;

import de.codecentric.spring.boot.chaos.monkey.configuration.AssaultProperties;

public class ServiceSelection {

	private String node;
	private String service;
	private AssaultProperties assaultProperties;

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public AssaultProperties getAssaultProperties() {
		return assaultProperties;
	}

	public void setAssaultProperties(AssaultProperties assaultProperties) {
		this.assaultProperties = assaultProperties;
	}

}
