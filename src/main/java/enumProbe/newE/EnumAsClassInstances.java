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
        ASIDE{}; // вынужден переопределять абстрактный метод

        public /*abstract*/ Direction opposite(){return null;};
    }
}
