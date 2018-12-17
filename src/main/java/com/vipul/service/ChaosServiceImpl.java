package com.vipul.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.vipul.model.ServiceSelection;

import de.codecentric.spring.boot.chaos.monkey.configuration.AssaultProperties;

@Service
public class ChaosServiceImpl implements ChaosService {

	@PostMapping("/assaults")
	public String updateAssaultProperties(ServiceSelection serviceSelection) {
		return new RestTemplate()
				.postForObject(
						"http://" + serviceSelection.getNode() + ":8080/" + serviceSelection.getService()
								+ "/actuator/chaosmonkey/assaults",
						serviceSelection.getAssaultProperties(), String.class);
	}

	@GetMapping("/assaults")
	public AssaultProperties getAssaultSettings(ServiceSelection serviceSelection) {
		return new RestTemplate().getForObject("http://" + serviceSelection.getNode() + ":8080/"
				+ serviceSelection.getService() + "/actuator/chaosmonkey/assaults", AssaultProperties.class);
	}

	@PostMapping("/enable")
	public String enableChaosMonkey(ServiceSelection serviceSelection) {
		return new RestTemplate().postForObject("http://" + serviceSelection.getNode() + ":8080/"
				+ serviceSelection.getService() + "/actuator/chaosmonkey/enable", "", String.class);
	}

	@PostMapping("/disable")
	public String disableChaosMonkey(ServiceSelection serviceSelection) {
		return new RestTemplate().postForObject("http://" + serviceSelection.getNode() + ":8080/"
				+ serviceSelection.getService() + "/actuator/chaosmonkey/disable", "", String.class);
	}

}
