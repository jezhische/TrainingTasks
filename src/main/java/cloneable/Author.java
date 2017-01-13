package cloneable;

/**
 * Created by Ежище on 13.01.2017.
 */
public class Author implements Cloneable { // см. также пакет objectMethods
    private String name;

    public void setName(String n){ name=n;}
    public String getName(){ return name;}

    public Author(String name){

        this.name=name;
    }

    @Override
    public Author clone() throws CloneNotSupportedException { // в Object он protected, здесь расширяем
        return (Author) super.clone();
    }
}
