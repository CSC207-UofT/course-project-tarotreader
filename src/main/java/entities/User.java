package entities;


public class User {
    String username;
    String birthday;
    ReadingLog readingLog;

    public User(String username, int year, int month, int day, ReadingLog r) {
        this.username = username;
        this.birthday = year + "/" + month + "/" + day;
        this.readingLog = r;
    }

    public String getUsername() {
        return this.username;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public ReadingLog getReadingLog() {
        return this.readingLog; }

}