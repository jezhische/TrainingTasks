package patterns.builder;

// https://ru.wikipedia.org/wiki/Строитель_(шаблон_проектирования)
public class BuilderStaticWiki {
    public static void main(String[] args) {
        User user = User.getBuilder("John").setSurname("Dow").build();
        System.out.println(user);
    }
}

class User {
    private String name; // obligatory field, но, увы, не получается сделать его final - его тогда можно инициализировать
    //    либо в конструкторе User, либо в блоке инициализации, но никак не из класса Builder
    private String surname; // optional field

    private User() {
    } // конструктор приватный, чтоб через него класс было не создать.

    public static Builder getBuilder(String name) {
        return new User().new Builder(name); // NB создаем здесь (в статическом методе!) образец класса, поскольку все
        // равно этот метод будет использоваться при создании образца класса User
    }

    @Override
    public String toString() {
        return "User{" + name + " " + surname + "}";
    }

    public class Builder {
        private Builder(String name) {
            User.this.name = name; // todo: NB: обращение из inner класса к outer полю
        }

        public Builder setSurname(String surname) {
            User.this.surname = surname;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
