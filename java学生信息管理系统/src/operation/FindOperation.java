package operation;

import student.Student;
import student.StudentList;

import java.util.Scanner;

public class FindOperation implements IOpetation{
    @Override
    public void work(int pos, StudentList studentList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你所要查找的学生信息");
        String name=scanner.next();
        for (int i = 0; i <studentList.getUsedSize() ; i++) {
            Student student=studentList.getStudents(i);
            if(student.getName().equals(name)){
                System.out.println(student);
                System.out.println("查找成功！");
                return;
            }
            System.out.println("没有该学生！");
        }
    }
}
