package lab9.task1;

import java.util.*;

public class Faculty {
    private String name;
    private String address;
    private List<Course> courses;

    public Faculty(String name, String address) {
        this.name = name;
        this.address = address;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        this.courses.add(course);
    }

    //Câu 1
    public Course getMaxPracticalCourse() {
        Course result = null;
        int max = 0;
        for (Course course : courses) {
            if (course.getType().equals("Practical") && course.getStudents().size() >= max) {
                max = course.getStudents().size();
                result = course;
            }
        }
        return result;
    }

    //Câu 2
    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> result = new HashMap<>();
        for (Course course : courses) {
            Set<Map.Entry<Integer, List<Student>>> set = course.groupStudentsByYear().entrySet();
            for (Map.Entry<Integer, List<Student>> ele : set) {
                if (result.containsKey(ele.getKey())) {
                    result.get(ele.getKey()).addAll(ele.getValue());
                } else {
                    result.put(ele.getKey(), ele.getValue());
                }
            }
        }
        return result;
    }

    //Câu 3
    public Set<Course> filterCourses(String type) {
        Set<Course> result = new TreeSet<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getStudents().size() - o2.getStudents().size();
            }
        });

        for (Course course : courses) {
            if (course.getType().equals(type)) result.add(course);
        }

        return result;
    }

    public static void main(String[] args) {
        Student s1 = new Student("S01", "A", 2022);
        Student s2 = new Student("S02", "B", 2021);
        Student s3 = new Student("S03", "C", 2021);
        Student s4 = new Student("S04", "D", 2021);
        Student s5 = new Student("S05", "E", 2023);

        Course c1 = new Course("Course1", "DataStructure", "Practical", "D");
        Course c2 = new Course("Course2", "HowToCodeABeautifulWeb", "Practical", "L");

        c1.addStudent(s1); c1.addStudent(s2);
        c2.addStudent(s3); c2.addStudent(s4); c2.addStudent(s5);

        Faculty f = new Faculty("IT", "HCMC");
        f.addCourses(c1);
        f.addCourses(c2);

        System.out.println(f.getMaxPracticalCourse());
        System.out.println(f.groupStudentsByYear());
        System.out.println(f.filterCourses("Practical"));
    }
}
