package com.cybage.genworth.insurance.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cybage.genworth.insurance.model.Policy;
import com.cybage.genworth.insurance.repository.PolicyRepository;
import com.cybage.genworth.insurance.serviceImpl.PolicyServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyServiceImplTest {

	@InjectMocks
	PolicyServiceImpl policyService;

	@Mock
	PolicyRepository policyRepository;

	@Test
	public void savePolicyTest() {
		// Integer id, String policyNumber, String premiumAmount, String name, String
		// email, String claimNumber,String status
		Policy policy = new Policy(3, "1255", "500", "ram", "ram@gmail.com", "5012", "active");
		when(policyRepository.save(policy)).thenReturn(policy);
		assertEquals(policy, policyService.savePolicy(policy));
	}

	@Test
	public void getAllPolicyTest() {
		List<Policy> list = new ArrayList<>();
		Policy policy1 = new Policy(1, "101", "1000", "Ram", "ram@gmail.com", "2020", "active");
		Policy policy2 = new Policy(2, "102", "2000", "Shyam", "shyam@gmail.com", "2021", "active");
		Policy policy3 = new Policy(3, "103", "3000", "Rahul", "rahul@gmail.com", "2022", "active");

		list.add(policy1);
		list.add(policy2);
		list.add(policy3);

		when(policyRepository.findAll()).thenReturn(list);

		Iterable<Policy> policyList = policyService.getAllPolicy();
		assertEquals(list, policyList);

	}

	@Test
	public void getPolicyByIdTest() {
		when(policyRepository.findById(3))
				.thenReturn(new Policy(3, "103", "1000", "Shyam", "shyam@gmail.com", "2022", "active"));
		Policy policy = policyService.getPolicyById(3);
		assertEquals("103", policy.getPolicyNumber());
		assertEquals("Shyam", policy.getName());
		assertEquals("active", policy.getStatus());
		assertEquals("1000", policy.getPremiumAmount());
	}

	@Test
	public void deletePolicyTest() {
		Policy policy = new Policy(1, "101", "1000", "Ram", "ram@gmail.com", "2020", "active");
		policyRepository.save(policy);
		policyRepository.deleteById(policy.getId());
		Policy exp = policyRepository.findById(policy.getId());
		assertEquals(null, exp);
	}

}
