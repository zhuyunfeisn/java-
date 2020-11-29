package student;

public class StudentList {
    private int UsedSize;
    private Student[] students=new Student[10];

    public StudentList() {
      this.UsedSize=3;
      students[0]=new Student("张三","男",1001,85);
      students[1]=new Student("李四","男",1002,86);
      students[2]=new Student("小芳","女",1003,92);
    }

    public int getUsedSize() {
        return UsedSize;
    }

    public void setUsedSize(int usedSize) {
        UsedSize = usedSize;
    }

    public Student getStudents(int pos) {
        return students[pos];
    }

    public void setStudents(int pos,Student student) {
       this.students[pos]=student;
    }
}
