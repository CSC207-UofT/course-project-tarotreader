package entities;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class user {
    String username;
    String birthday;
    ArrayList readingLog;
    public user(String username, int year, int month, int day){
        this.username = username;
        this.birthday = year + "/" + month + "/" + day;
        this.readingLog = new ArrayList<String>();
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
