package system;

import Impl.StudentManage;

import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void menuStudent(StudentManage studentManage){
        int choice =0 ;
        boolean flag ;
        do {
            System.out.println("----- student management program -------");
            System.out.println("select function by number to continue");
            System.out.println("1 : Display list students");
            System.out.println("2 : Add Students");
            System.out.println("3 : Update Students by msv");
            System.out.println("4 : Delete Students by msv");
            System.out.println("5 : arrange");
            System.out.println("0 : Exits");
            System.out.println("Enter Your choice !!");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                flag = true ;
            }catch (Exception e){
                System.out.println("Please enter valid");
                flag = false;
            }
            if (0>choice|| choice>5){
                System.out.println("Please enter valid");
            }else {
                switch (choice){
                    case 1:studentManage.display();break;
                    case 2:studentManage.add();break;
                    case 3:studentManage.update();break;
                    case 4:studentManage.delete();break;
                    case 5:menuArrange(studentManage);break;
                }
            }
        }while (choice != 0||!flag);

    }
    public void menuArrange(StudentManage studentManage){
        int choice =0 ;
        boolean flag ;
        do {
            System.out.println("select function by number to continue");
            System.out.println("1 : sort grade point average in ascending");
            System.out.println("2 : sort grade point average in descending");
            System.out.println("0 : exits ");
            System.out.println("Enter Your choice !!");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                flag = true ;
            }catch (Exception e){
                System.out.println("Please enter valid");
                flag = false;
            }
            if (0>choice|| choice>2){
                System.out.println("Please enter valid");
            }else {
                switch (choice){
                    case 1:studentManage.displayStudentAvgMinArriveMax();break;
                    case 2:studentManage.displayStudentAvgMaxArriveMin();break;
                }
            }
        }while (choice != 0||!flag);

    }
    }
