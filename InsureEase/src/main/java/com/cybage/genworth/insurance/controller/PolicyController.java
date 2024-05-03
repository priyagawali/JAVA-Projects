package com.cybage.genworth.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.genworth.insurance.model.Policy;
import com.cybage.genworth.insurance.service.PolicyService;

@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@GetMapping("/getAll")
	public Iterable<Policy> getAllPolicy() throws Exception {
		Iterable<Policy> policies = policyService.getAllPolicy();
		return policies;
	}

	@PostMapping("/save")
	public Policy createPolicy(@RequestBody Policy policy) {
		Policy policies = policyService.savePolicy(policy);
		return policies;
	}

	@GetMapping("/get/{id}")
	public Policy getPolicyById(@PathVariable("id") Integer id) {
		Policy policy = policyService.getPolicyById(id);
		return policy;
	}

	@DeleteMapping("/delete/{id}")
	public void deletePolicyById(@PathVariable("id") Integer id) {
		policyService.deletePolicy(id);
	}
}
