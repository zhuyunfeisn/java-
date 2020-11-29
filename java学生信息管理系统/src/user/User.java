package user;

import operation.IOpetation;
import student.Student;
import student.StudentList;

public abstract class User {
    public String name;
    IOpetation iOpetations[];
    public  int menu() {
        return 0;
    }

    public User(String name) {
        this.name = name;
    }
    public void DoOperation(int choice , StudentList studentList){
        this.iOpetations[choice].work(choice,studentList);
    }
}
