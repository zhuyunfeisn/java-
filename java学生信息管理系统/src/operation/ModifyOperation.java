package operation;

import student.Student;
import student.StudentList;

import java.util.Scanner;

public class ModifyOperation implements IOpetation{
    @Override
    public void work(int pos, StudentList studentList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入你要修改的学生的姓名");
        String name=scanner.next();
        System.out.println("输入修改后的姓名");
        String Newname=scanner.next();
        System.out.println("输入修改后的性别");
        String sex=scanner.next();
        System.out.println("输入修改后的学号");
        int num=scanner.nextInt();
        System.out.println("输入修改后的成绩");
        int score=scanner.nextInt();
        int number=0;
        for (int i = 0; i <studentList.getUsedSize() ; i++) {
            Student student=studentList.getStudents(i);
            if (student.getName().equals(name)){
                number=i;
                break;
            }
        }
        Student student=new Student(Newname,sex,num,score);
        studentList.setStudents(number,student);
        System.out.println("修改成功!");
    }
}
