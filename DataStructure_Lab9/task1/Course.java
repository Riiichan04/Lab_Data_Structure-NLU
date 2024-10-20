package lab9.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String id;
    private String title;
    private String type;
    private List<Student> students;
    private String lecturer;

    public Course(String id, String title, String type, String lecturer) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = new ArrayList<>();
        this.lecturer = lecturer;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    //Câu 2
    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            if (result.containsKey(student.getYear())) {
                result.get(student.getYear()).add(student);
            } else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                result.put(student.getYear(), list);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return this.id + " " + this.title + " " + this.students.size() + " " + this.lecturer + " " + this.type;
    }

}
