import Impl.StudentManage;
import system.Menu;
public class Main {
    public static void main(String[] args) {
        StudentManage studentManage = new StudentManage();
        Menu menu = new Menu();
        menu.menuStudent(studentManage);
    }
}