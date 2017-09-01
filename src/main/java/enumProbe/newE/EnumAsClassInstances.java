package enumProbe.newE;

public class EnumAsClassInstances {

    enum Direction {
        UP {
            @Override
            public Direction opposite() {
                return DOWN;
            }
        },
        DOWN {
            @Override
            public Direction opposite() {
                return UP;
            }
        },
        ASIDE(" "){};

        // метод:
        public /*abstract*/ Direction opposite(){return null;};

        //конструкторы:
        Direction() {}
        Direction(String s) {}
    }


    private enum AbstractDirection {
        UP("go") {
            @Override
            public AbstractDirection opposite() {
                return DOWN;
            }
        },
        DOWN() {
            @Override
            public AbstractDirection opposite() {
                return UP;
            }
        };
//        ,
//        ASIDE{}; // вынужден переопределять абстрактный метод

        // конструкторы:
        AbstractDirection() {}
        AbstractDirection(String s) {}
        // абстрактный метод:
        public abstract AbstractDirection opposite();
    }

    //конструкторы:
    public EnumAsClassInstances() {}
    public EnumAsClassInstances(int i) {}

    public static void main(String[] args) {
        System.out.println(Direction.UP + " " + Direction.UP.opposite());

        System.out.println("class: " + AbstractDirection.DOWN.getClass() + ", superclass:  "
                + AbstractDirection.DOWN.getClass().getSuperclass()
                + ", supersuperclass:  " + AbstractDirection.DOWN.getClass().getSuperclass().getSuperclass());
    }
}
