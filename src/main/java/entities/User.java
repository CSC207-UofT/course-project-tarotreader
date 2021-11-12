package entities;


import java.io.Serializable;

public class User implements Serializable {
    String username;
    String birthday;
    ReadingLog readingLog;
    String password;

    public User(String username, String password, int year, int month, int day) {
        this.username = username;
        this.birthday = year + "/" + month + "/" + day;
        this.readingLog = new ReadingLog(this);
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public ReadingLog getReadingLog() {
        return this.readingLog; }


}
