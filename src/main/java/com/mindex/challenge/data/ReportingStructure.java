package com.mindex.challenge.data;

public class ReportingStructure {
    private Employee employee;
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private int numberOfReports = 0;
    public int getNumberOfReports() {
        return numberOfReports;
    }
    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    private String reportingStructure;
    public String getReportingStructure() {
        return reportingStructure;
    }
    public void setReportingStructure(String reportingStructure) {
        this.reportingStructure = reportingStructure;
    }
}
