package Impl;

import model.Student;
import service.Generate;
import service.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentManage extends ReadAndWrite implements Generate {
    Pattern pattern;
    Matcher matcher;
    private Scanner scanner;
    private List<Student> listStudents = new ArrayList<>();
    private final String file = "src/io/FileStudents.CSV";
    public StudentManage() {
        scanner = new Scanner(System.in);
        listStudents = read(file,listStudents);
    }
public Student getProduct(){

            System.out.println("Format msv : msv + 12345");
            System.out.println("Enter a Msv");
          String  msv = scanner.nextLine();
    System.out.println("Enter a Full Name");
    String fullName = scanner.nextLine();
    boolean flag1 = false;
    String eag;
    do {
        System.out.println("Format eag : 1x =>9x  ");
    System.out.println("Enter a eag");
    eag = scanner.nextLine();
    if (checkValidate(eag,"^\\d{2}")){
        flag1= true;
    }
    }while (!flag1);
    System.out.println("Enter a male");
    String male  = scanner.nextLine();
    System.out.println("Enter a address");
    String address = scanner.nextLine();
    String avg;
    boolean flag2 = false;
    do {
        System.out.println("Format avg : 1 - 9");
    System.out.println("Enter a avg");
    avg = scanner.nextLine();
    if (checkValidate(avg,"^\\d")){
        flag2 = true;
    }
    }while (!flag2);
    return new Student(msv,fullName,eag,male,address,avg);
}
    @Override
    public void add() {
    listStudents.add(getProduct());
write(file,listStudents);
    }

    @Override
    public void update() {
        display();

            System.out.println("Format msv : msv + 12345");
            System.out.println("Enter Msv by update");
           String msv = scanner.nextLine();
        Student student = checkMsv(msv);
        if (student != null){
            System.out.println("Enter new Msv");
            String msv1 = scanner.nextLine();
            if (!msv.isEmpty()&& checkValidate(msv1,"^[msv]\\d{1,5}")){
                student.setMsv(msv1);
            }
            System.out.println("Enter new Full Name");
            String fullName = scanner.nextLine();
            if (!fullName.isEmpty()){
                student.setFullName(fullName);
            }
            System.out.println("Enter new eag");
            String eag = scanner.nextLine();
            if (!eag.isEmpty()||checkValidate(eag,"^\\d{2}")){
                student.setEag(eag);
            }
            System.out.println("Enter new male");
            String male  = scanner.nextLine();
            if (!male.isEmpty()){
                student.setMale(male);
            }
            System.out.println("Enter new address");
            String address = scanner.nextLine();
            if (!address.isEmpty()){
                student.setAddress(address);
            }
            System.out.println("Enter new avg");
            String avg = scanner.nextLine();
            if (!avg.isEmpty()|| checkValidate(avg,"^\\d")){
                student.setAvg(avg);
            }
            System.out.println("update success");
        }
write(file,listStudents);
    }

    @Override
    public void display() {
        listStudents = read(file,listStudents);
        for (int i = 0; i < listStudents.size(); i++) {
            System.out.println((i+1) + " : " + listStudents.get(i));
        }

    }

    @Override
    public void delete() {
        display();
        System.out.println("Enter a msv by Delete");
       String msv = scanner.nextLine();
        Student student = checkMsv(msv);
        if (student != null){
            listStudents.remove(student);
            System.out.println("delete success");
        }
write(file,listStudents);
    }
    public void displayStudentAvgMinArriveMax(){
        for (int i = 0; i < listStudents.size(); i++) {
            for (int j = listStudents.size()-1; j >i ; j--) {
                if (Integer.parseInt(listStudents.get(j - 1).getAvg()) > Integer.parseInt(listStudents.get(j).getAvg())) {
                    Student temp = listStudents.get(j);
                    listStudents.set(j, listStudents.get(j - 1));
                    listStudents.set(j - 1, temp);
                }
            }}
        for (int i = 0; i < listStudents.size(); i++) {
            System.out.println((i+1) + " : " + listStudents.get(i));
        }
    }
    public void displayStudentAvgMaxArriveMin(){
        for (int i = 0; i < listStudents.size(); i++) {
            for (int j = listStudents.size()-1; j >i ; j--) {
                if (Integer.parseInt(listStudents.get(j - 1).getAvg()) < Integer.parseInt(listStudents.get(j).getAvg())) {
                    Student temp = listStudents.get(j);
                    listStudents.set(j, listStudents.get(j - 1));
                    listStudents.set(j - 1, temp);
                }
            }}
        for (int i = 0; i < listStudents.size(); i++) {
            System.out.println((i+1) + " : " + listStudents.get(i));
        }
    }
    public Student checkMsv( String msv){
        for (Student listStudent : listStudents) {
            if ((msv.equals(listStudent.getMsv()))) {
                return listStudent;
            }
        }
            return null;
}
    public boolean checkValidate(String regex,String checkRegex){
        pattern = Pattern.compile(checkRegex);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
