package main;

import java.util.Calendar;
import java.util.Date;

/**
 * Author andy_
 * created 27.09.2017.
 */


public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() throws IllegalStateException {
        if (getFirstName() == null || getLastName() == null) {
            throw new IllegalStateException();
        }
        StringBuilder fullName = new StringBuilder();
        fullName.append(getLastName()).append(", ").append(getFirstName());
        return fullName.toString();
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.setTime(dateOfBirth);
        int year = calendar.get(Calendar.YEAR);
        return currentYear - year;
    }
}
