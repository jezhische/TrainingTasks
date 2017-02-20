package garbage.overload;

/**
 * Created by Ежище on 19.02.2017.
 */
public class Over {
    protected void aaa(int k, String s) {}
    protected void aaa(String s, int k) {}
    private String aaa(double kk) throws Exception {return null;}
//    static void aaa(double kk) {} // не пройдет
    int aaa() {return 0;}
    static int aaa(Integer ou) {return 0;}

    /* сигнатура - только имя и параметры (и их порядок), без возвращаемого значения, модификаторов доступа
    * и бросаемых исключений. Переопределение - изменение параметров при том же имени **/
}
