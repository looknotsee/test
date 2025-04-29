import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample subjects
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("MATH101", "Calculus 1", "Mon 8-10am", 2));
        subjects.add(new Subject("ENG101", "English Grammar", "Mon 8-10am", 2));
        subjects.add(new Subject("CS101", "Intro to Programming", "Tue 10-12pm", 2));

        Student student = new Student("Juan Dela Cruz");

        while (true) {
            System.out.println("\nAvailable Subjects:");
            for (int i = 0; i < subjects.size(); i++) {
                Subject s = subjects.get(i);
                System.out.println(i + ". " + s.code + " (" + s.name + ") - Slots left: " + (s.capacity - s.enrolled));
            }
            
            // Define the Student class
            

            System.out.print("Enter subject number to add (or -1 to finish): ");
            int choice = scanner.nextInt();
            if (choice == -1) break;

            if (choice >= 0 && choice < subjects.size()) {
                student.addSubject(subjects.get(choice));
            } else {
                System.out.println("Invalid choice.");
            }
        }

        student.viewEnrolledSubjects();
        scanner.close();
    }
}

class Student {
    private String name;
    private List<Subject> enrolledSubjects;

    public Student(String name) {
        this.name = name;
        this.enrolledSubjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        if (subject.enrolled < subject.capacity) {
            enrolledSubjects.add(subject);
            subject.enrolled++;
            System.out.println("Successfully enrolled in " + subject.name);
        } else {
            System.out.println("No slots available for " + subject.name);
        }
    }

    public void viewEnrolledSubjects() {
        System.out.println("\nEnrolled Subjects:");
        for (Subject subject : enrolledSubjects) {
            System.out.println(subject.code + " - " + subject.name);
        }
    }
}

// Define the Subject class
class Subject {
    String code;
    String name;
    String schedule;
    int capacity;
    int enrolled;

    public Subject(String code, String name, String schedule, int capacity) {
        this.code = code;
        this.name = name;
        this.schedule = schedule;
        this.capacity = capacity;
        this.enrolled = 0;
    }
}