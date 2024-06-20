package com.spindrift.utils;

/**
 * ClassName: IDutils
 * Package: com.spindrift.utils
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/20 13:34
 * @Version 1.0
 */
public class IdUtils {

    public static Long extractStudentId(String studentId) {
        return Long.parseLong(studentId.replaceFirst("^XY0+", ""));
    }

    public static Long extractBillId(String billId) {
        return Long.parseLong(billId.replaceFirst("^SJ0+", ""));
    }

    public static String generateStudentId(Long studentId) {

        return String.format("XY%06d", studentId);
    }

    public static String generateBillId(Long billId) {

        return String.format("SJ%06d", billId);
    }
}
