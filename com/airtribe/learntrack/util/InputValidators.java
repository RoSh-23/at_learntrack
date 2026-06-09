package com.airtribe.learntrack.util;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.airtribe.learntrack.exception.*;

public class InputValidators {

    private static final Pattern VALID_EMAIL_PATTERN = Pattern
            .compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    private static final Pattern VALID_FIRST_NAME_PATTERN = Pattern.compile("^(?=.{1,40}$)\\p{L}+(?:[ '-]\\p{L}+)*$");
    private static final Pattern VALID_LAST_NAME_PATTERN = Pattern.compile("^(?=.{1,60}$)\\p{L}+(?:[ '-]\\p{L}+)*$");
    private static final Pattern VALID_COURSE_NAME_PATTERN = Pattern.compile("^(?=.{1,100}$)[A-Za-z0-9 ]+$");

    private static final Integer MAX_ALLOWED_COURSE_DURATION_IN_WEEKS = 14;
    private static final Integer MIN_ALLOWED_COURSE_DURATION_IN_WEEKS = 2;

    public static boolean isValidEmail(String inputEmail) {
        boolean isValid = true;
        if (inputEmail == null) {
            isValid = false;
        } else {
            Matcher matcher = VALID_EMAIL_PATTERN.matcher(inputEmail);
            isValid = matcher.matches();
        }
        if (!isValid) {
            throw new InvalidEmailException("This is not a valid email: " + inputEmail + ".", inputEmail);
        }
        return isValid;
    }

    public static boolean isValidFirstName(String inputFirstName) {
        boolean isValid = true;
        if (inputFirstName == null || inputFirstName.trim().isEmpty()) {
            isValid = false;
        } else {
            Matcher matcher = VALID_FIRST_NAME_PATTERN.matcher(inputFirstName);
            isValid = matcher.matches();
        }
        if (!isValid) {
            throw new IllegalArgumentException("This is not a valid first name: " + inputFirstName + ".");
        }
        return isValid;
    }

    public static boolean isValidLastName(String inputLastName) {
        boolean isValid = true;
        if (inputLastName == null || inputLastName.trim().isEmpty()) {
            isValid = false;
        } else {
            Matcher matcher = VALID_LAST_NAME_PATTERN.matcher(inputLastName);
            isValid = matcher.matches();
        }
        if (!isValid) {
            throw new IllegalArgumentException("This is not a valid last name: " + inputLastName + ".");
        }
        return isValid;
    }

    public static boolean isValidStudentBatch(Integer inputBatch) {
        boolean isValid = true;
        if (inputBatch == null) {
            isValid = false;
        }

        if (inputBatch <= 0) {
            isValid = false;
        }

        if (!isValid) {
            throw new IllegalArgumentException("This is not a valid batch for student. It cannot be negative or zero.");
        }
        return isValid;
    }

    public static boolean isValidCourseName(String inputCourseName) {
        boolean isValid = true;
        if (inputCourseName == null || inputCourseName.trim().isEmpty()) {
            isValid = false;
        } else {
            Matcher matcher = VALID_COURSE_NAME_PATTERN.matcher(inputCourseName);
            isValid = matcher.matches();
        }
        if (!isValid) {
            throw new IllegalArgumentException("This is not a valid course name: " + inputCourseName + ".");
        }
        return isValid;
    }

    public static boolean isValidCourseDuration(Integer inputDurationInWeeks) {
        boolean isValid = true;
        if (inputDurationInWeeks == null) {
            isValid = false;
        }

        if (inputDurationInWeeks < MIN_ALLOWED_COURSE_DURATION_IN_WEEKS
                || inputDurationInWeeks > MAX_ALLOWED_COURSE_DURATION_IN_WEEKS) {
            isValid = false;
        }

        if (!isValid) {
            String errorMsg = String.format(
                    "This is not a valid duration for course in weeks. It should be between (inclusive) %d and %d.",
                    MIN_ALLOWED_COURSE_DURATION_IN_WEEKS, MAX_ALLOWED_COURSE_DURATION_IN_WEEKS);
            throw new IllegalArgumentException(errorMsg);
        }
        return isValid;
    }

    public static boolean isValidEnrollmentDate(LocalDate inputDate) {
        boolean isValid = true;
        if (inputDate == null) {
            isValid = false;
        }

        if (inputDate.isAfter(LocalDate.now())) {
            isValid = false;
        }

        if (!isValid) {
            throw new IllegalArgumentException(
                    "Enrollment Date is not valid, It cannot be in future: " + inputDate + ".");
        }

        return isValid;
    }
}
