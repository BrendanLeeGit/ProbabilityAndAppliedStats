package SameBirthday;

/**
 * Simple Person class, used to store a certain day for each person. Realistically could've just done an array though
 * with the way I built this.
 */
public class Person {
    private int day;
    public Person (int day){
        this.day = day;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }
}
