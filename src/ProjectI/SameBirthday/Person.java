package ProjectI.SameBirthday;

/**
 * Simple Person class, used to store a certain day for each person. Realistically could've just done an array though
 * with the way I built this.
 */
public class Person {
    private int day;
    public Person (int day){
        this.day = day;
    }

    /**
     * Get method.
     * @return  Returns the birthday int of the current person
     */
    public int getDay(){
        return day;
    }

    /**
     * Set method to change the person's birthday int.
     * @param day   The int birthday you want the person to have
     */
    public void setDay(int day){
        this.day = day;
    }
}
