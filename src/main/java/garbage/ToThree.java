package garbage;

public class ToThree {
    private static void triple(int checked) throws Exception {
        int n = (checked != 0 && checked % 3 == 0)? checked / 3 : 0;
        if (n == 0) throw new Exception("Try again");
        else for (int i = 0; i < n; i++) {
            System.out.print("3 + ");
        }
    }

    private static void recursiveTriple(int checked) throws Exception {
        int n = (checked != 0 && checked % 3 == 0)? checked / 3 : 0;
        if (n == 0) throw new Exception("Try again");
        else {
            StringBuilder expression = null;

            for (int i = 0; i < n; i++) {
                System.out.print("3 + ");
            }
        }
    }

    public static void main(String[] args) {
        try {
            triple(33);
            triple(11);
            triple(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
