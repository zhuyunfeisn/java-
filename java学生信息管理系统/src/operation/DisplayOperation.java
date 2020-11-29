package operation;

import student.Student;
import student.StudentList;

public class DisplayOperation implements IOpetation{
    @Override
    public void work(int pos, StudentList studentList) {
        for (int i = 0; i <studentList.getUsedSize() ; i++) {
            Student student=studentList.getStudents(i);
            System.out.println(student);
        }
        System.out.println("显示成功");
    }
}
