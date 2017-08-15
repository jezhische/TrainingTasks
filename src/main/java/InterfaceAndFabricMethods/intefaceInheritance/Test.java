package InterfaceAndFabricMethods.intefaceInheritance;

/**
 * Created by WORK on 21.02.2017.
 */
public class Test {
    AI ai = new BI() {
        @Override
        public void doBI() {

        }

        @Override
        public void doAI() {

        }
    };
    // Inconvertible types:
//    BI bi = (BI) (new AI() {
//        @Override
//        public void doAI() {
//
//        }
//    });

    CI ci = new CI() {
        @Override
        public void doCI() {

        }
    };
}
