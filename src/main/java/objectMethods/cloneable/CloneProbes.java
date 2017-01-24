package objectMethods.cloneable;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by WORK_x64 on 26.12.2016.
 */
public class CloneProbes implements Cloneable {
    ArrayList<Integer> list = new ArrayList<>();
    Move move = new Move();
    Integer x;
    @Override
    public CloneProbes clone () throws CloneNotSupportedException {
        CloneProbes temp = (CloneProbes)super.clone();
        temp.list = (ArrayList<Integer>)list.clone();
        temp.move = move.clone();
//        temp.x = x;
        return temp;
    }

//    List<Integer> list = new ArrayList<>();
//    public ArrayList<Integer> doNothing(ArrayList<Integer> l) {
//        return (ArrayList<Integer>)l;
//    }
//    void dodo () {
//        ArrayList<Integer> temp = this.doNothing((ArrayList<Integer>)list);
//    }


    public static void main(String[] args) throws CloneNotSupportedException {
        CloneProbes cloneProbes1 = new CloneProbes();
        for (int i = 0; i < 10; i++)
            cloneProbes1.list.add(i);


        CloneProbes cloneProbes3 = cloneProbes1.clone();
        cloneProbes3.list.set(0, 45);
        cloneProbes1.move.mumu = 98;
        cloneProbes1.x = 963;

        System.out.println(cloneProbes1.list.get(0));
        System.out.println(cloneProbes3.move.mumu);
        System.out.println(cloneProbes3.x);

        CloneProbes cloneProbes2 = cloneProbes1;

        ArrayList<Integer> clonedList = (ArrayList<Integer>)cloneProbes1.list.clone();
        for (int i = 0; i < clonedList.size(); i++)
            clonedList.set(i, -1);
        System.out.println("After cloning and changing elements value: \ncloneProbes1.list = " + (cloneProbes1.list)
        + "\nclonedList = " + (clonedList));


    }
}

class Move implements Cloneable {
    int mumu;
    @Override
    public Move clone() throws CloneNotSupportedException {
        return (Move)super.clone();
    }
}
