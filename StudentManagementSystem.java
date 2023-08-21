/*

1. Create a Student class to represent individual students. Include attributes such as name, roll
number, grade, and any other relevant details.

2. Implement a StudentManagementSystem class to manage the collection of students. Include
methods to add a student, remove a student, search for a student, and display all students.

3 . Design the user interface for the Student Management System. This can be a console-based
interface or a graphical user interface (GUI) using libraries like Swing or JavaFX.

4. Implement methods to read and write student data to a storage medium, such as a file or a
database.

5. Allow users to interact with the Student Management System by providing options such as
adding a new student, editing an existing student's information, searching for a student, displaying all
students, and exiting the application.
6. Implement input validation to ensure that required fields are not left empty and that the student
data is in the correct format

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    // Validate input
                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Name and grade cannot be empty.");
                    } else {
                        Student newStudent = new Student(name, rollNumber, grade);
                        sms.addStudent(newStudent);
                        System.out.println("Student added.");
                    }
                    break;
                case 2:
                    // Remove student logic
                	 System.out.print("Enter roll number: ");
                     rollNumber = scanner.nextInt();
                     sms.removeStudent(rollNumber);
                    break;
                case 3:
                    // Search student logic
                	Student s;
                	System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextInt();
                    s=sms.searchStudent(rollNumber);
                    System.out.println("Student Found!! Below are the details");
                    System.out.println("Name: "+s.getName());
                    System.out.println("Roll Number: "+s.getRollNumber());
                    System.out.println("Grade: "+s.getGrade());
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}

