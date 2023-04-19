package com.mindex.challenge.data;

import java.time.LocalDate;
import java.math.BigDecimal;

public class Compensation {
    
    private String compensationId;
    private Employee employee;
    private String employeeId;

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    private BigDecimal salary;
    private LocalDate effectiveDate;

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    

    public String getCompensationId() {
        return this.compensationId;
    }

    public void setCompensationId(String compensationId) {
        this.compensationId = compensationId;
    }


}
