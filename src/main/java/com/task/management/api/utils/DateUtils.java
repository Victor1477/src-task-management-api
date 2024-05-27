package com.task.management.api.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtils {

    public static String getCurrentDateTime() {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString();
    }
}
