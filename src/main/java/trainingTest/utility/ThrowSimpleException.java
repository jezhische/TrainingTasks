package trainingTest.utility;

/**
 * Created by Ежище on 21.06.2016.
 */
public class ThrowSimpleException {
    // метод, который кидает исключение типа SimpleException (NOTE SimpleException extends Exception)
    public String helloMessage(String name) throws SimpleException {
        if (name == null) {
            throw new SimpleException(10, "Message is null"); // создаем объект-исключение new Simp...,
            // а затем вместо "вернуть" (return) командуем "кидай" (метод throws, здесь команда throw)
        } else
            return "Hello, " + name;
    }
}
