package kz.iitu.itse1902.var1_nurkhan.exception;

import java.util.Date;

public class ErrorDetails {
    private Date time;
    private String message;
    private String Details;

    public ErrorDetails(Date time, String message, String details) {
        this.time = time;
        this.message = message;
        Details = details;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
