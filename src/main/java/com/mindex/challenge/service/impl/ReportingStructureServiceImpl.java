package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure reportingStructure(String id) {
        
        Employee employee = employeeService.read(id);

        String structureBuild = "";

        ArrayList<Employee> directs = (ArrayList<Employee>) employee.getDirectReports();

        if (directs != null && !directs.isEmpty()) {

            for (Employee directEmployee : directs) {
                
                String empId = directEmployee.getEmployeeId();

                Employee actualEmployee = employeeService.read(empId);

                structureBuild += this.traverse(actualEmployee);

            }
        }

        int reportCount = (int) structureBuild.chars().filter(ch -> ch == '|').count();

        structureBuild = structureBuild.replaceAll("\\|","");

        ReportingStructure structure = new ReportingStructure();
        structure.setNumberOfReports(reportCount);
        structure.setEmployee(employee);
        structure.setReportingStructure(structureBuild);
        return structure;

        

    }

    private String traverse(Employee employee) {

        String structureBuild = "";

        structureBuild += employee.getFirstName() + " " + employee.getLastName() + "|\n";

        ArrayList<Employee> directs = (ArrayList<Employee>) employee.getDirectReports();

        if (directs != null && !directs.isEmpty()) {        
            for (Employee directEmployee : directs) {

                String innerEmpId = directEmployee.getEmployeeId();

                Employee innerActualEmployee = employeeService.read(innerEmpId);

                structureBuild += "\t" + this.traverse(innerActualEmployee);
            }
        }
        
        return structureBuild;



    }
}
