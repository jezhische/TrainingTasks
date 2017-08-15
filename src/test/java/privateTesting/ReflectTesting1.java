package privateTesting;

import privateTesting.support.Sup1;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ежище on 17.08.2016.
 * http://blog.trukhin.com/2012/05/private-java.html
 */
public class ReflectTesting1 {
    private Object invokePrivateMethod(Object test, String methodName, Object params[]) throws Exception {
        Object ret = null;

        final Method[] methods =
                test.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; ++i) {
            if (methods[i].getName().equals(methodName)) {
                methods[i].setAccessible(true);
                ret = methods[i].invoke(test, params);
                break;
            }
        }
        return ret;
    }

    public void main(String[] args) throws Exception {
        Sup1 instance = new Sup1();
        String expResult = "Expected Result";
        Object[] params = {"FileWriterSimply String Value", "Another Value"};
        String result = (String) this.invokePrivateMethod(instance, "subtract", params);
        assertEquals(expResult, result);
    }

}
