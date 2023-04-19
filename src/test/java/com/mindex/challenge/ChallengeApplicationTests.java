package com.mindex.challenge;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.ReportingStructureService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Autowired
	private ReportingStructureService reportingStructureService;

	@Autowired
	private CompensationService compensationService;

	@Test
	public void testReportingStructure() {
		
		String id = "16a596ae-edd3-4847-99fe-c4518e82c86f";
		ReportingStructure reportingStructure = reportingStructureService.reportingStructure(id);
		int numberOfReports = reportingStructure.getNumberOfReports();
		assertEquals(numberOfReports, 5);

	}

	@Test
	public void testCompensation() {

		Compensation compensation = new Compensation();
		compensation.setEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
		compensation.setEffectiveDate(LocalDate.now());
		compensation.setSalary(new BigDecimal(50000));
		compensationService.create(compensation);


		compensation = null;

		compensation = compensationService.readByEmpId("16a596ae-edd3-4847-99fe-c4518e82c86f");

		assertEquals(compensation.getSalary(), new BigDecimal(50000) );
		assertEquals(compensation.getEmployeeId(), "16a596ae-edd3-4847-99fe-c4518e82c86f");

	}





}
