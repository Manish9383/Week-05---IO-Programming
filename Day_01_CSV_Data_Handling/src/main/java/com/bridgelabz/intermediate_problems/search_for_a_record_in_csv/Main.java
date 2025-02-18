package com.bridgelabz.intermediate_problems.search_for_a_record_in_csv;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/employee.csv";
        String target="Manish Patel";
        String [] employee=SearchRecord.searchByName(filePath,target);
        if(!(employee==null)){
            System.out.println("Name : "+employee[1].trim()+" | Department : "+employee[2].trim()+" | Salary : "+employee[3].trim());
        }else{
            System.out.println("Record Not Found!");
        }
    }
}
