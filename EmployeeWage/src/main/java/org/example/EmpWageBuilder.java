package org.example;

public class EmpWageBuilder {
    final int IS_FULL_TIME = 1;
    final int IS_PART_TIME = 2;
    final int EMP_RATE_PER_HOUR = 20;
    final int NUM_OF_WORKING_DAYS = 20;
    final int MAX_WORKING_DAYS=20;
    final int MAX_HRS_IN_MONTH=50;
    int empHrs = 0;
    int empWage = 0;

    public static void main(String[] args) {
        int empCheck = (int) (Math.floor(Math.random() * 10) % 3);
        EmpWageBuilder obj = new EmpWageBuilder();
        //Check Employee is Present or Absent
        obj.isPresent(empCheck);
        //Calculate Daily Employee Wage
        // Add Part time Employee & Wage
        System.out.println("Employee Wage=" + obj.getDailyWage(empCheck));
        //Solving using Switch Case Statement
        System.out.println("Employee Wage (Switch Statement)=" + obj.getDailyWageSwitchStatement(empCheck));
        //Calculating Wages for a Month
        obj.getWagesForMonth();
        //Calculate Wages till a condition of total working hours or days is reached for a month
        obj.getWagesByCondition();
    }

    private void isPresent(int empCheck) {
        if (empCheck == IS_FULL_TIME || empCheck == IS_PART_TIME) System.out.println("Employee is Present");
        else System.out.println("Employee is Absent");
    }

    int getDailyWage(int empCheck) {
        if (empCheck == IS_FULL_TIME) empHrs = 8;
        else if (empCheck == IS_PART_TIME) empHrs = 4;
        empWage = empHrs * EMP_RATE_PER_HOUR;
        return empWage;
    }

    int getDailyWageSwitchStatement(int empCheck) {
        switch (empCheck) {
            case IS_FULL_TIME:
                empHrs = 8;
                break;
            case IS_PART_TIME:
                empHrs = 4;
                break;
            default:
                empHrs = 0;
        }
        empWage = empHrs * EMP_RATE_PER_HOUR;
        return empWage;
    }

    private void getWagesForMonth() {
        int totalWage = 0;
        for (int i = 0; i < NUM_OF_WORKING_DAYS; i++) {
            int empCheck = (int) (Math.floor(Math.random() * 10) % 3);
            EmpWageBuilder obj1 = new EmpWageBuilder();
            empWage = obj1.getDailyWageSwitchStatement(empCheck);
            totalWage = totalWage + empWage;
            System.out.println("emp Wage: " + empWage);
        }
        System.out.println("total Wages for a Month: " + totalWage);
    }

    private void getWagesByCondition() {
        int totalEmpHrs=0;
        int totalEmpWage=0;
        int totalWorkingDay=0;
        while (totalEmpHrs<=MAX_HRS_IN_MONTH && totalWorkingDay<MAX_WORKING_DAYS){
            totalWorkingDay++;
            int empCheck = (int) (Math.floor(Math.random() * 10) % 3);
            EmpWageBuilder obj2 = new EmpWageBuilder();
            totalEmpHrs=totalEmpHrs+(obj2.getDailyWageSwitchStatement(empCheck)/20);
            System.out.println("Day: "+totalWorkingDay+" Emp Hr: "+obj2.getDailyWageSwitchStatement(empCheck)/20);
        }
        System.out.println("total Day:="+totalWorkingDay+" Total Hr: "+totalEmpHrs);
    }
}