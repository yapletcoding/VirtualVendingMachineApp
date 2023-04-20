package com.yapletcoding.application;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditWriter {
    private File auditFile;

    public AuditWriter(String fileName) {
        this.auditFile = new File(fileName);
    }

    public void write(String action, BigDecimal oldBalance, BigDecimal newBalance){
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(auditFile,true))){
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            String now = LocalDateTime.now().format(dateFormat);
            printWriter.println(now + " "+String.format("%-19s",action) + "\t$"+oldBalance+ "\t\t$"+newBalance);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
