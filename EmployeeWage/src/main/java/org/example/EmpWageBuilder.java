package org.example;

public class EmpWageBuilder {
    final int IS_FULL_TIME = 1;
    final int EMP_RATE_PER_HOUR = 20;
    int empHrs = 0;
    int empWage = 0;

    public static void main(String[] args) {
        final int IS_FULL_TIME = 1;
        double empCheck = Math.floor(Math.random() * 10) % 2;
        EmpWageBuilder obj = new EmpWageBuilder();
        obj.isPresent(empCheck);
        System.out.println("Employee Wage=" + obj.getDailyWage(empCheck));
    }

    private void isPresent(double empCheck) {
        if (empCheck == IS_FULL_TIME)
            System.out.println("Employee is Present");
        else
            System.out.println("Employee is Absent");
    }

    int getDailyWage(double empCheck) {
        if (empCheck == IS_FULL_TIME)
            empHrs = 8;
        empWage = empHrs * EMP_RATE_PER_HOUR;
        return empWage;
    }
}