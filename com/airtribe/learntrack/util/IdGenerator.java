package com.airtribe.learntrack.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong personIdCounter = new AtomicLong(100);
    private static final AtomicLong studentIdCounter = new AtomicLong(100);
    private static final AtomicLong courseIdCounter = new AtomicLong(100);
    private static final AtomicLong enrollmentIdCounter = new AtomicLong(100);

    public static String getNextPersonId() {
        return "PER-" + personIdCounter.incrementAndGet();
    }

    public static String getNextStudentId() {
        return "STU-" + studentIdCounter.incrementAndGet();
    }

    public static String getNextCourseId() {
        return "COR-" + courseIdCounter.incrementAndGet();
    }

    public static String getNextEnrollmentId() {
        return "ENR-" + enrollmentIdCounter.incrementAndGet();
    }
}
