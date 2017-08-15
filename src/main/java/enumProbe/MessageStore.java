package enumProbe;

/**
 * Created by WORK on 11.08.2016.
 */
public enum  MessageStore {
    ERR_COUNT_FIRST_LEVEL_MSG("Введите параметры автомобиля либо напечатайте esc и нажмите Enter для перехода " +
            "на следующий этап."), VEHICLE_IDENTIFICATOR(5), ID_AND_MSG(5, "truck");

    private String message;
    private int id;
    MessageStore(String message) { this.message = message; }
    public String getMessage() { return message; }
    MessageStore(int id) {this.id = id;}
    public int getId() {return id;}
    MessageStore(int id, String message) {
        this(id);
        this.message = message;
    }
    //    public final static String ERR_COUNT_FIRST_LEVEL_MSG = "Введите параметры автомобиля либо напечатайте esc и нажмите Enter " +
//            "для перехода на следующий этап.";
}
