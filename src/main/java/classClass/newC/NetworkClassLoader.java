package classClass.newC;

public class NetworkClassLoader extends ClassLoader {
    private String host;
    private int port;
    public NetworkClassLoader(String host,
                              int port) {
        this.host = host;
        this.port = port;
    }
    public Class findClass(String className) {
        byte[] bytes = loadClassData(className);
        return defineClass(className, bytes, 0,
                bytes.length);
    }
    private byte[] loadClassData(
            String className) {
        byte[] result = null;
        // open connection, load the class data
        try {
            ClassLoader loader =
                    new NetworkClassLoader(host, port);
            Object main = loader.loadClass(
                    "Main").newInstance();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
