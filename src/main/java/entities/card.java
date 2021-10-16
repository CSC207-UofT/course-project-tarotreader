package entities;

public class card{
    /***
     *
     */
    private String name;
    private int number;
    private boolean isReversed;
    private boolean isMajor;
    private String suit;
    private String meaning;
    public card(String name, String number,  String isMajor, String meaning){
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.meaning = meaning;
        this.isReversed = false;
    }
    public card(String name, String number, String isMajor, String suit, String meaning){
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.suit = suit;
        this.meaning = meaning;
        this.isReversed = false;
    }
    public String getMeaning(){
        return this.meaning;
    }
    public static String getName(){
        return this.name;
    }
}

