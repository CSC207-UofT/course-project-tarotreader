package entities;

import java.util.ArrayList;

public class user {
    String username;
    String birthday;
    readingLog readingLog;
    public user(String username, int year, int month, int day, readingLog r){
        this.username = username;
        this.birthday = year + "/" + month + "/" + day;
        this.readingLog = r;
    }

    public String getUsername(){
        return this.username;
    }

    public String getBirthday(){
        return this.birthday;
    }

    public ArrayList getReadingLog(){
        return this.readingLog;
    }

    public static void main(String[] args){
        user elif = new user("eliferzincan", 2001, 4, 30);
        System.out.println(elif.getBirthday());
    }
}
