package operation;

import student.Student;
import student.StudentList;

import java.util.Scanner;

public class DelOperation implements IOpetation{
    @Override
    public void work(int pos, StudentList studentList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入所要删除学生的姓名");
        String name=scanner.next();
        int i=0;
        for ( i = 0; i <studentList.getUsedSize() ; i++) {
            Student student=studentList.getStudents(i);
            if(student.getName().equals(name)){
                pos=i;
                break;
            }
        }
        if(pos>studentList.getUsedSize()){
            System.out.println("没有该学生");
            return;
        }
        for (int j = pos; j <studentList.getUsedSize() ; j++) {
            Student student=studentList.getStudents(j+1);
            studentList.setStudents(j,student);
        }
        System.out.println("删除成功");
    }
}
