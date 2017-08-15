package cloneable;

/**
 * Created by Ежище on 13.01.2017.
 */
public class Book implements Cloneable {

    private String name;
    private Author author;

    public void setName(String n){ name=n;}
    public String getName(){ return name;}

    public void setAuthor(String n){ author.setName(n);}
    public String getAuthor(){ return author.getName();}

    Book(String name, String author){

        this.name = name;
        this.author = new Author(author);
    }

    public String toString(){

        return "Книга '" + name + "' (автор " +  author + ")";
    }

    public Book clone() throws CloneNotSupportedException{

        Book newBook = (Book) super.clone();
        newBook.author = (Author) author.clone();
        return newBook;
    }

    public static void main(String[] args) {
        try{
            Book book = new Book("Война и мир", "Л. Толстой");
            Book book2 = book.clone();
            book2.setAuthor("И. Тургенев");
            System.out.println(book.getAuthor());
            System.out.println(book2.getAuthor());
        }
        catch(CloneNotSupportedException ex){

            System.out.println("Все ok");
        }
    }

}
