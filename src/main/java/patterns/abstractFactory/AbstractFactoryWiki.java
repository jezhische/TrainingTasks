package patterns.abstractFactory;

// https://ru.wikipedia.org/wiki/%D0%90%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D0%B0%D1%8F_%D1%84%D0%B0%D0%B1%D1%80%D0%B8%D0%BA%D0%B0_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)https://ru.wikipedia.org/wiki/%D0%90%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D0%B0%D1%8F_%D1%84%D0%B0%D0%B1%D1%80%D0%B8%D0%BA%D0%B0_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
public class AbstractFactoryWiki {
//    Суть: клиенту нужно, чтобы продукты, которые он купил, сочетались.
//    Чтобы продукты сочетались, они д.б. произведены на одной и той же фабрике.

//    Клиент умеет ходить на фабрику покупать продукты. Но у него есть лишь идея (чертеж) фабрики и продуктов,
//    поскольку неизвестно заранее, какого стиля набор продуктов он захочет.
//    Поэтому клиент идет в конкретную фабрику A и заказывает там конкретные продукты стиля A,
//    или в конкретную фабрику B и заказывает там продукты стиля B.
//    Соответственно, создаем клиента, в конструктор которого кладем фабрику A или B, которая и поставляет клиенту
//    набор продуктов стиля A или B.
    public static void main(String[] args) {
        new Client(new FactoryHiTech()).execute();
        new Client(new FactoryRococo()).execute();
    }
}
// ---------------клиент умеет покупать набор продуктов (стол и стул, подходящие друг под друга):
class Client {
    private AbstractDesk desk;
    private AbstractChair chair;

    public Client(AbstractFactory factory) {
        desk = factory.createDesk();
        chair = factory.createChair();
    }
    // и теперь клиент осуществляет взаимодействие между продуктами
    // (продукты сами умеют взаимодействовать, он это использует):
    public void execute() {
        chair.interact(desk);
    }
}
// -------------------------------------------Фабрика умеет создавать продукты:
interface AbstractFactory {
    AbstractDesk createDesk();
    AbstractChair createChair();
}
// ------------------Продукты умеют взаимодействовать друг с другом (стол должен подходить к стулу):
interface AbstractDesk {
    void interact(AbstractChair chair);
}
interface AbstractChair {
    void interact(AbstractDesk desk);
}
// ----------------------------Конкретные фабрики, умеющие производить конкретные продукты:
class FactoryHiTech implements AbstractFactory {
    @Override
    public AbstractDesk createDesk() {
        return new DeskHiTech();
    }
    @Override
    public AbstractChair createChair() {
        return new ChairHiTech();
    }
}
class FactoryRococo implements AbstractFactory {
    @Override
    public AbstractDesk createDesk() {
        return new DeskRococo();
    }
    @Override
    public AbstractChair createChair() {
        return new ChairRococo();
    }
}
// ---------------------------------Конкретные продукты, выполненные в конкретном стиле:
class DeskHiTech implements AbstractDesk {
    @Override
    public void interact(AbstractChair chair) {
        System.out.println(this.getClass().getSimpleName() + " fits the style to the " + chair.getClass().getSimpleName());
    }
}
class ChairHiTech implements AbstractChair {
    @Override
    public void interact(AbstractDesk desk) {
        System.out.println(this.getClass().getSimpleName() + " fits the style to the " + desk.getClass().getSimpleName());
    }
}
class DeskRococo implements AbstractDesk {
    @Override
    public void interact(AbstractChair chair) {
        System.out.println(this.getClass().getSimpleName() + " fits the style to the " + chair.getClass().getSimpleName());
    }
}
class ChairRococo implements AbstractChair {
    @Override
    public void interact(AbstractDesk desk) {
        System.out.println(this.getClass().getSimpleName() + " fits the style to the " + desk.getClass().getSimpleName());
    }
}