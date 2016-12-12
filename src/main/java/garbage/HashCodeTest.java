package garbage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ежище on 26.11.2016.
 */
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object obj) {
        HashCodeTest.count++;

        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        Employee emp = (Employee) obj;
        if (this.name == emp.name) {
            return true;
        }
        return false;
    }

    public int hashCode(){
        return name.hashCode();
    }
}

public class HashCodeTest {
    static int count = 0;

    public static void main(String[] args) {

        Map employees = new HashMap();

        employees.put(new Employee("Joe"), new Integer("1"));
        employees.put(new Employee("Chandler"), new Integer("2"));
        employees.put(new Employee("Chandler"), new Integer("2"));
        employees.put(new Employee("Ross"), new Integer("3"));

        Iterator iterator = employees.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(count);
    }
}
// Пояснение: Если при добавлении пары ключ-значение в Map оказывается, что там уже содержится такой ключ, ему в
// соответствие ставится новое значение.
//В классе Employee метод equals() реализован таким образом, что равными считаются два объекта, содержащие одну и ту же
// ссылку на строку name (this.name == emp.name). Поэтому из двух объектов-ключей, содержащих ссылку
// на строку-константу "Chandler", в Map'е остаётся только один. Поле count используется для подсчёта количества
// вызовов метода Employee.equals(). При работе с HashMap метод equals() вызывается относительно редко, например,
// когда хэш-код вновь добавляемого ключа совпадает с хэш-кодом ранее добавленного ключа - чтобы достоверно убедиться,
// что это одинаковые объекты (равенство хэш-кодов ещё не гарантирует равенство объектов). В данном примере такое
// происходит ровно один раз, при повторном добавлении Chandler'а.