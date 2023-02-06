package SetOperationsAndStatsLibrary;
import java.util.ArrayList;
public class SetOperator<E> {

    public ArrayList<E> union(ArrayList<E> a, ArrayList<E> b){
        ArrayList<E> unionArray = new ArrayList<>();
        for (E e : a) {
            unionArray.add(e);
        }
        for (E e : b) {
            if (!a.contains(e)) {
                unionArray.add(e);
            }
        }
        return unionArray;
    }

    public ArrayList<E> intersection(ArrayList<E> a, ArrayList<E> b) {
        ArrayList<E> intersectionArrayList = new ArrayList<>();
        if (a.size() > b.size()){
            for (E e : a) {
                if (b.contains(e)) {
                    intersectionArrayList.add(e);
                }
            }
        }
        else{
            for (E e : b) {
                if (a.contains(e)) {
                    intersectionArrayList.add(e);
                }
            }
        }
        return intersectionArrayList;
    }

   public ArrayList<E> complement(ArrayList<E> fullSet, ArrayList<E> b) {
       ArrayList<E> complementArrayList = new ArrayList<>();
       for (E e : fullSet) {
           if (!b.contains(e)) {
               complementArrayList.add(e);
           }
       }
       return complementArrayList;
   }
}
