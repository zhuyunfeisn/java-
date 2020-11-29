package operation;

import student.Student;
import student.StudentList;

import java.util.Scanner;

public class AddOperation implements IOpetation {
    @Override
    public void work(int pos, StudentList studentList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入学生姓名");
        String name=scanner.next();
        System.out.println("输入学生性别");
        String sex=scanner.next();
        System.out.println("输入学生学号");
        int num=scanner.nextInt();
        System.out.println("输入学生成绩");
        int score=scanner.nextInt();
        Student student=new Student(name,sex,num,score);
        int countSize=studentList.getUsedSize();
        studentList.setStudents(countSize,student);
        studentList.setUsedSize(countSize+1);
        System.out.println("添加成功!");
    }
}
