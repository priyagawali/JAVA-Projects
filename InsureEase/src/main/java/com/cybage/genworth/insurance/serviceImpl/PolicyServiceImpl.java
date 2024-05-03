package com.cybage.genworth.insurance.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.genworth.insurance.model.Policy;
import com.cybage.genworth.insurance.repository.PolicyRepository;
import com.cybage.genworth.insurance.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Iterable<Policy> getAllPolicy() {
		Iterable<Policy> policies = policyRepository.findAll();
		return policies;
	}

	@Override
	public Policy savePolicy(Policy policy) {
		Policy policy2 = policyRepository.save(policy);
		return policy2;
	}

	@Override
	public Policy getPolicyById(Integer Id) {
		Policy policy = policyRepository.findById(Id);
		return policy;
	}

	@Override
	public void deletePolicy(Integer id) {
		policyRepository.deleteById(id);
	}

}
