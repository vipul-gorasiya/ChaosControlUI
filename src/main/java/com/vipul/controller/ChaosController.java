package com.vipul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipul.model.ServiceSelection;
import com.vipul.service.ChaosService;

import de.codecentric.spring.boot.chaos.monkey.configuration.AssaultProperties;

@RestController
public class ChaosController {

	@Autowired
	private ChaosService chaosService;

	@Value("${nodes}")
	private List<String> nodes;

	@Value("${services}")
	private List<String> services;

	@GetMapping("/nodes")
	public List<String> getNodes() {
		return nodes;
	}

	@GetMapping("/services")
	public List<String> getServices() {
		return services;
	}

	@PostMapping("/assaults")
	public ResponseEntity<String> updateAssaultProperties(@RequestBody ServiceSelection serviceSelection) {
		return ResponseEntity.ok().body(chaosService.updateAssaultProperties(serviceSelection));
	}

	@PostMapping("/getAssaults")
	public AssaultProperties getAssaultSettings(@RequestBody ServiceSelection serviceSelection) {
		return chaosService.getAssaultSettings(serviceSelection);
	}

	@PostMapping("/enable")
	public ResponseEntity<String> enableChaosMonkey(@RequestBody ServiceSelection serviceSelection) {
		return ResponseEntity.ok().body(chaosService.enableChaosMonkey(serviceSelection));
	}

	@PostMapping("/disable")
	public ResponseEntity<String> disableChaosMonkey(@RequestBody ServiceSelection serviceSelection) {
		return ResponseEntity.ok().body(chaosService.disableChaosMonkey(serviceSelection));
	}
}
