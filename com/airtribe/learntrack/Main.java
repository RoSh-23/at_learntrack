package com.airtribe.learntrack;

import java.util.Scanner;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.CourseInMemoryRepository;
import com.airtribe.learntrack.repository.EnrollmentInMemoryRepository;
import com.airtribe.learntrack.repository.StudentInMemoryRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidEmailException;

public class Main {
    public static void main(String[] args) {

        boolean showMenu = true;
        Scanner scn = new Scanner(System.in);
        StudentInMemoryRepository studentRepo = new StudentInMemoryRepository();
        CourseInMemoryRepository courseRepo = new CourseInMemoryRepository();
        EnrollmentInMemoryRepository enrollmentRepo = new EnrollmentInMemoryRepository();

        while (showMenu) {
            System.out.println(
                    "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("******LEARN TRACK: Student Course Mangement System******");
            System.out.println(
                    "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("\n###### MAIN MENU ######");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int mainChoice = scn.nextInt();

            switch (mainChoice) {
                case 1: {
                    System.out.println("\n--- Student Management ---");
                    System.out.println("1. Add new student");
                    System.out.println("2. View all students");
                    System.out.println("3. Search student by Id");
                    System.out.println("4. Deactivate a student");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Choose a sub-option: ");

                    int studentMgmtChoice = scn.nextInt();

                    StudentService studentService = new StudentService(studentRepo);

                    switch (studentMgmtChoice) {
                        case 1: {
                            String firstName;
                            String lastName;
                            String email;
                            Integer batch;
                            scn.nextLine();
                            System.out.print("Enter Student First Name: ");
                            firstName = scn.nextLine();
                            System.out.print("Enter Student Last Name: ");
                            lastName = scn.nextLine();
                            System.out.print("Enter Student Email: ");
                            email = scn.nextLine();
                            System.out.print("Enter Student Batch: ");
                            batch = scn.nextInt();
                            try {
                                Student student = new Student(firstName, lastName, email, batch);
                                studentService.addStudent(student);
                            } catch (InvalidEmailException e) {
                                System.out.println(e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("*****ALL STUDENTS*****");
                            List<Student> students = studentService.viewAllStudents();
                            for (Student student : students) {
                                System.out.println(student.toString());
                            }
                            break;
                        }
                        case 3: {
                            System.out.print("Enter Student Id for searching: ");
                            scn.nextLine();
                            String studentId = scn.nextLine();
                            try {
                                Student resultStudent = studentService.searchStudentById(studentId);
                                if (resultStudent != null) {
                                    System.out.print("RESULT: ");
                                    System.out.println(resultStudent.toString());
                                }
                            } catch (EntityNotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 4: {
                            System.out.print("Enter Student Id for deactivating: ");
                            scn.nextLine();
                            String studentId = scn.nextLine();
                            try {
                                studentService.deactivateStudent(studentId);
                                System.out.print("Deactivated!");
                            }
                            catch (EntityNotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 5: {
                            System.out.println("Going back to Main Menu");
                            break;
                        }
                        default: {
                            System.out.println("Invalid selection! Please choose a valid option.");
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("\n--- Course Management ---");
                    System.out.println("1. Add new course");
                    System.out.println("2. View all courses");
                    System.out.println("3. Activate/Deactivate a course");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("Choose a sub-option: ");

                    int courseMgmtChoice = scn.nextInt();

                    CourseService courseService = new CourseService(courseRepo);

                    switch (courseMgmtChoice) {
                        case 1: {
                            String courseName;
                            Integer durationInWeeks;
                            System.out.print("Enter Course Name: ");
                            courseName = scn.nextLine();
                            System.out.print("Enter Course Duration in Weeks: ");
                            durationInWeeks = scn.nextInt();
                            try {
                                Course course = new Course(courseName, durationInWeeks);
                                courseService.addCourse(course);
                            } catch (EntityNotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            break;
                        }
                        case 4: {
                            System.out.println("Going back to Main Menu");
                            break;
                        }
                        default: {
                            System.out.println("Invalid selection! Please choose a valid option.");
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("\n--- Enrollment Management ---");
                    System.out.println("1. Enroll a student in a course");
                    System.out.println("2. View all enrollments for a student");
                    System.out.println("3. Mark enrollment as completed/cancelled");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("Choose a sub-option: ");

                    int enrollmentMgmtChoice = scn.nextInt();
                    switch (enrollmentMgmtChoice) {
                        case 1: {
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            break;
                        }
                        case 4: {
                            System.out.println("Going back to Main Menu");
                            break;
                        }
                        default: {
                            System.out.println("Invalid selection! Please choose a valid option.");
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    showMenu = false;
                    scn.close();
                    break;
                }
                default: {
                    System.out.println("Invalid selection! Please choose a valid option.");
                    break;
                }
            }
        }

    }
}