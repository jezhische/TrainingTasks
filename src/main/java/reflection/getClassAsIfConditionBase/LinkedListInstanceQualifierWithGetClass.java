package reflection.getClassAsIfConditionBase;

import java.util.LinkedList;

/**
 * Created by Ежище on 23.11.2016.
 */
public class LinkedListInstanceQualifierWithGetClass {
    public LinkedList list = new LinkedList();

    public static void main(String[] args) {
        LinkedListInstanceQualifierWithGetClass liq = new LinkedListInstanceQualifierWithGetClass();
        liq.push();
        liq.printList();
    }

    private LinkedList push() {

        list.addLast(5);
        list.addFirst('c');
        list.addFirst("жужу");
        return list;
    }

    private void printList() {
//        System.out.println(list.peekLast().getClass().toString());
        System.out.println("list size is " + list.size());
        int count = list.size() - 1;
        while (!list.isEmpty()) {
            Object object = list.pollFirst();
            if (object.getClass().equals(String.class))
                System.out.printf("String of index %d is %s\n", count - list.size(), object.toString());
            else if (object.getClass().equals(Integer.class))
                System.out.printf("int of index %d is %s\n", count - list.size(), object.toString());
            else if (object.getClass().equals(Character.class))
                System.out.printf("char of index %d is %s\n", count - list.size(), object.toString());


//            String[] s = object.getClass().toString().split("\\.");
////            System.out.println(object.getClass());
////            System.out.println(s[s.length - 1]);
//            switch (s[s.length - 1]) {
//                case "String":
//                    System.out.printf("String of index %d is %s\n", count - list.size(), object.toString());
//                    break;
//                case "Integer":
//                    System.out.printf("int of index %d is %s\n", count - list.size(), object.toString());
//                    break;
//                case "Character":
//                    System.out.printf("char of index %d is %s\n", count - list.size(), object.toString());
//                    break;
//            }
//            if (s[s.length - 1].equals("String"))
//                System.out.printf("String of index %d is %s\n", count - list.size(), object.toString());
//            else if (s[s.length - 1].equals("Integer"))
//                System.out.printf("int of index %d is %s\n", count - list.size(), object.toString());
//            else if (s[s.length - 1].equals("Character"))
//                System.out.printf("char of index %d is %s\n", count - list.size(), object.toString());
        }
    }
}
