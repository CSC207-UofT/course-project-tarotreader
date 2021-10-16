package entities;


public class user {
    String username;
    String birthday;
    readingLog readingLog;

    public user(String username, int year, int month, int day, readingLog r) {
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

    public readingLog getReadingLog() {
        return this.readingLog; }

}