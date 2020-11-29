package operation;

import student.StudentList;

public class ExitOperation implements IOpetation{
    @Override
    public void work(int pos, StudentList studentList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}
