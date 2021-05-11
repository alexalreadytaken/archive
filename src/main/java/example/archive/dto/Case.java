package example.archive.dto;

import java.time.LocalDate;

public class Case<TODO> {
    private String id;
    private String letter;
    private String oldId;
    private String heading;
    private String annotation;
    private LocalDate startDate;
    private LocalDate endDate;
    private TODO dates;
    private long sheetCount;
    private TODO category;
    private TODO groups;
    private TODO docType;
    private boolean nominal;
    private TODO[] more;
}
