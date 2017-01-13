package binaryTrees;

/**
 * Created by WORK_x64 on 12.01.2017.
 */
public class BSTree <T1 extends Comparable<T1>, T2> { // это дерево называется бинарным деревом (сбалансированным)
    static class Node<T1, T2> {
        T1 key;
        T2 value;
        Node<T1, T2> left, right;

        Node(T1 key, T2 value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node<T1, T2> root = null;

    public boolean containsKey(T1 k) {
        Node<T1, T2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                return true;
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return false;
    }

    public T2 get(T1 k) {
        Node<T1, T2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                return x.value;
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }

    public void add(T1 k, T2 v) {
        Node<T1, T2> x = root, y = null;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                x.value = v;
                return;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        Node<T1, T2> newNode = new Node<T1, T2>(k, v);
        if (y == null) {
            root = newNode;
        } else {
            if (k.compareTo(y.key) < 0) {
                y.left = newNode;
            } else {
                y.right = newNode;
            }
        }
    }

    public void remove(T1 k) {
        Node<T1, T2> x = root, y = null;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                break;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        if (x == null) {
            return;
        }
        if (x.right == null) {
            if (y == null) {
                root = x.left;
            } else {
                if (x == y.left) {
                    y.left = x.left;
                } else {
                    y.right = x.left;
                }
            }
        } else {
            Node<T1, T2> leftMost = x.right;
            y = null;
            while (leftMost.left != null) {
                y = leftMost;
                leftMost = leftMost.left;
            }
            if (y != null) {
                y.left = leftMost.right;
            } else {
                x.right = leftMost.right;
            }
            x.key = leftMost.key;
            x.value = leftMost.value;
        }
    }

    public static void main(String[] args) {
//        class T1 implements Comparable<T1>{
//            int a;
//            T1 (int a) {this.a = a;}
//            @Override
//            public int compareTo(T1 o) {
////                if (o instanceof T1) {
////                    if (a > ((T1) o).a)
////                        return 1;
////                    else if (a < ((T1) o).a)
////                        return -1;
////                    else
////                        return 0;
////                }
//                return 0;
//            }
//        };
//        T1 t10 = new T1(6);
//        T1 t11 = new T1(10);
//        T1 t12 = new T1(85);
//        T1 t13 = new T1(4253);
//        T1 t14 = new T1(5);
//        T1 t15 = new T1(8);
        String t20 = "iu";
        String t21 = "i;ol";
        String t22 = "qEWR3";
        String t23 = "436";
        String t24 = "ghj";
        String t25 = "tyituyi";

        BSTree<Integer, String> bstree = new BSTree<Integer, String>();
        bstree.add(10, t20);
        bstree.add(11, t21);
        bstree.add(12, t22);
        bstree.add(13, t23);
        bstree.add(14, t24);
        bstree.add(15, t25);

        System.out.println(bstree.get(13));
        System.out.println(bstree.get(10));

        Node<Integer, String> root = null;
        Node<Integer, String> x = root;
        System.out.println(x);
    }
}
