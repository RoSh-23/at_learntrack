package com.airtribe.learntrack;

import java.util.Scanner;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.repository.CourseInMemoryRepository;
import com.airtribe.learntrack.repository.EnrollmentInMemoryRepository;
import com.airtribe.learntrack.repository.StudentInMemoryRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.EnrollmentService;
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

            int mainChoice = 0;
            try {
                mainChoice = scn.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            switch (mainChoice) {
                case 1: {
                    System.out.println("\n--- Student Management ---");
                    System.out.println("1. Add new student");
                    System.out.println("2. View all students");
                    System.out.println("3. Search student by Id");
                    System.out.println("4. Deactivate a student");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Choose a sub-option: ");

                    int studentMgmtChoice = 0;

                    try {
                        studentMgmtChoice = scn.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    StudentService studentService = new StudentService(studentRepo);

                    switch (studentMgmtChoice) {
                        case 1: {
                            String firstName;
                            String lastName;
                            String email;
                            Integer batch = 2026;
                            scn.nextLine();
                            System.out.print("Enter Student First Name: ");
                            firstName = scn.nextLine();
                            System.out.print("Enter Student Last Name: ");
                            lastName = scn.nextLine();
                            System.out.print("Enter Student Email: ");
                            email = scn.nextLine();
                            System.out.print("Enter Student Batch: ");
                            try {
                                batch = scn.nextInt();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
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
                            } catch (EntityNotFoundException e) {
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

                    int courseMgmtChoice = 0;

                    try {
                        courseMgmtChoice = scn.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    CourseService courseService = new CourseService(courseRepo);

                    switch (courseMgmtChoice) {
                        case 1: {
                            String courseName;
                            Integer durationInWeeks = 8;
                            System.out.print("Enter Course Name: ");
                            scn.nextLine();
                            courseName = scn.nextLine();
                            System.out.print("Enter Course Duration in Weeks: ");
                            try {
                                durationInWeeks = scn.nextInt();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

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
                            System.out.println("*****ALL COURSES*****");
                            List<Course> courses = courseService.viewAllCourses();
                            for (Course course : courses) {
                                System.out.println(course.toString());
                            }
                            break;
                        }
                        case 3: {
                            System.out.print("Enter Course Id for activating/deactivating: ");
                            scn.nextLine();
                            String courseId = scn.nextLine();
                            char activationChoice;
                            do {
                                System.out.print("Enter T: to activate F: to deactivate: ");
                                activationChoice = Character.toUpperCase(scn.next().charAt(0));

                                if (activationChoice != 'T' && activationChoice != 'F') {
                                    System.out.println("Error: Input must be either T or F.");
                                }

                            } while (activationChoice != 'T' && activationChoice != 'F');
                            try {
                                boolean activationChoiceBool = (activationChoice == 'T') ? true : false;
                                courseService.activateDeactivateCourse(courseId, activationChoiceBool);
                            } catch (EntityNotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
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

                    int enrollmentMgmtChoice = 0;
                    try {
                        enrollmentMgmtChoice = scn.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepo);

                    switch (enrollmentMgmtChoice) {
                        case 1: {
                            System.out.print("Enter Course Id for enrollment: ");
                            scn.nextLine();
                            String courseId = scn.nextLine();
                            System.out.print("Enter Student Id for enrollment: ");
                            String studentId = scn.nextLine();
                            try {
                                Enrollment enrollment = new Enrollment(studentId, courseId);
                                enrollmentService.addEnrollment(enrollment, studentRepo, courseRepo);
                            } catch (EntityNotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Enter Student Id for viewing all Enrollments of a student: ");
                            scn.nextLine();
                            String studentId = scn.nextLine();
                            try {
                                List<Enrollment> enrollments = enrollmentService.viewAllStudentEnrollments(studentId);
                                for (Enrollment enrollment : enrollments) {
                                    System.out.println(enrollment.toString());
                                }
                            } catch (EntityNotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 3: {
                            System.out.print("Enter Enrollment Id for marking completed/cancelled: ");
                            scn.nextLine();
                            String enrollmentId = scn.nextLine();
                            char enrollmentStatusChoice;
                            do {
                                System.out.print("Enter A: to cancel B: to complete: ");
                                enrollmentStatusChoice = Character.toUpperCase(scn.next().charAt(0));

                                if (enrollmentStatusChoice != 'A' && enrollmentStatusChoice != 'B') {
                                    System.out.println("Error: Input must be either A or B.");
                                }

                            } while (enrollmentStatusChoice != 'A' && enrollmentStatusChoice != 'B');
                            try {
                                EnrollmentStatus enrollmentStatusChoiceEnum = (enrollmentStatusChoice == 'A')
                                        ? EnrollmentStatus.CANCELLED
                                        : EnrollmentStatus.COMPLETED;
                                enrollmentService.setEnrollmentStatus(enrollmentId, enrollmentStatusChoiceEnum);
                            } catch (EntityNotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
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