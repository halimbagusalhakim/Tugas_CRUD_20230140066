package com.example.ktp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    // Format standar untuk tanggal lahir di sistem (Tahun-Bulan-Tanggal)
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Method bantuan untuk mengubah LocalDate menjadi String (jika suatu saat dibutuhkan)
    public static String formatTanggal(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DATE_FORMATTER);
    }
}