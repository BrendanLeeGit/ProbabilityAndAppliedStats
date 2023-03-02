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
        //add every element from first array list
        //TODO Make sure the larger ArrayList is added first
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
        //If arrayListA is larger, go through entire list and add each element to intersectionArrayList
        //if arrayListB also contains it
        if (arrayListA.size() > arrayListB.size()){
            for (E e : arrayListA) {
                if (arrayListB.contains(e)) {
                    intersectionArrayList.add(e);
                }
            }
        }
        //If arrayListB is larger, do the same thing just for B
        //TODO Just switch the references around if the wrong one is bigger tbh
        else{
            for (E e : arrayListB) {
                if (arrayListA.contains(e)) {
                    intersectionArrayList.add(e);
                }
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
