package com.cybage.genworth.insurance.service;
import com.cybage.genworth.insurance.model.Policy;

public interface PolicyService {
	
	public Iterable<Policy> getAllPolicy();
	public Policy savePolicy(Policy policy);
	public Policy getPolicyById(Integer Id);
	public void deletePolicy(Integer id);
	
}
