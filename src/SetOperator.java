import java.lang.reflect.Array;
import java.util.ArrayList;
public class SetOperator<E> {

    public ArrayList<E> union(ArrayList<E> a, ArrayList<E> b){
        ArrayList<E> unionArray = new ArrayList<E>();
        for (int i = 0; i < a.size(); i++){
            unionArray.add(a.get(i));
        }
        for (int i = 0; i < b.size(); i++){
            if (!a.contains(b.get(i))){
                unionArray.add(b.get(i));
            }
        }
        return unionArray;
    }

    public ArrayList<E> intersection(ArrayList<E> a, ArrayList<E> b) {
        ArrayList<E> intersectionArrayList = new ArrayList<>();
        if (a.size() > b.size()){
            for (int i = 0; i < a.size(); i++){
                if (b.contains(a.get(i))){
                    intersectionArrayList.add(a.get(i));
                }
            }
        }
        else{
            for (int i = 0; i < b.size(); i++){
                if (a.contains(b.get(i))){
                    intersectionArrayList.add(b.get(i));
                }
            }
        }
        return intersectionArrayList;
    }

   public ArrayList<E> complement(ArrayList<E> fullSet, ArrayList<E> b) {
       ArrayList<E> complementArrayList = new ArrayList<>();
       for (int i = 0; i < fullSet.size(); i++){
           if (!b.contains(fullSet.get(i))){
               complementArrayList.add(fullSet.get(i));
           }
       }
       return complementArrayList;
   }
}
