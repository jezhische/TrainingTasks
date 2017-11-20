package singleton.newS;

public class TestSTOne {
    public static void main(String[] args) {
        SingletonTrialOne inst = SingletonTrialOne.getINSTANCE();
        inst.setNumber(20);
        System.out.println(inst.getNumber());
        inst = SingletonTrialOne.getINSTANCE();
        System.out.println(inst.getNumber());
        SingletonTrialOne newInst = SingletonTrialOne.getINSTANCE();
        System.out.println(newInst.getNumber());
        System.out.println(inst);
        inst = null; // ну, это просто отрываем ссылку от объекта, она повисла в воздухе, но с объектом ничего не
        // случилось, и поскольку есть другая ссылка на него newInst, то доступ к нему есть.
        System.out.println(inst);
        System.out.println(newInst);

    }

}
