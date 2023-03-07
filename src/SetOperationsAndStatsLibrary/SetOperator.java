package SetOperationsAndStatsLibrary;
import java.util.ArrayList;
public class SetOperator<E> {

    /**
     * Returns a new ArrayList that contains the union of two ArrayLists.
     *
     * @param a First inputted ArrayList
     * @param b Second inputted ArrayList
     * @return  Returns a newly created ArrayList
     */
    public ArrayList<E> union(ArrayList<E> a, ArrayList<E> b){
        //initialize new array list for the union to be held in
        //add every element from larger arraylist a
        if (a.size() < b.size()){
            ArrayList<E> temp = a;
            a = b;
            b = temp;
        }
        ArrayList<E> unionArray = new ArrayList<>(a);
        //begin adding elements from the second list only if the list doesn't already contain them
        for (E e : b) {
            if (!a.contains(e)) {
                unionArray.add(e);
            }
        }
        return unionArray;
    }

    /**
     * Generates and returns a new ArrayList that contains the intersection of two ArrayLists.
     *
     * @param arrayListA    First inputted ArrayList
     * @param arrayListB    Second inputted ArrayList
     * @return              ArrayList that contains the intersection of the two inputted ArrayLists.
     */
    public ArrayList<E> intersection(ArrayList<E> arrayListA, ArrayList<E> arrayListB) {
        ArrayList<E> intersectionArrayList = new ArrayList<>();
        //make sure ArrayList A is larger by switching around references if needed
        if (arrayListA.size() < arrayListB.size()){
            ArrayList<E> temp = arrayListA;
            arrayListA = arrayListB;
            arrayListB = temp;
        }
        for (E e : arrayListA) {
            if (arrayListB.contains(e)) {
                intersectionArrayList.add(e);
            }
        }
        return intersectionArrayList;
    }

    /**
     * Generates and returns an ArrayList that contains the complement of one subset.
     *
     * @param fullSet   An ArrayList containing the full set of elements
     * @param b         An inputted ArrayList containing the subset of elements you want the complement of
     * @return          An ArrayList containing the complement of the inputted subset
     */
   public ArrayList<E> complement(ArrayList<E> fullSet, ArrayList<E> b) {
       //generate new ArrayList to hold the complement
       ArrayList<E> complementArrayList = new ArrayList<>();
       //go through the full set and only add each element if ArrayList b does not contain it
       for (E e : fullSet) {
           if (!b.contains(e)) {
               complementArrayList.add(e);
           }
       }
       return complementArrayList;
   }
}
