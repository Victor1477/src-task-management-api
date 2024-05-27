package com.task.management.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static PrintStream getPrintStream() throws FileNotFoundException {
        File file = new File("logs");
        file.mkdirs();
        final String fileName = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss-a")) + ".txt";
        return new PrintStream(new File(file.getAbsolutePath() + "/" + fileName));
    }
}
