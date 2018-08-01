package modificators.final_.newFinal;

import java.util.Objects;

public class ChangeFinalObject {

    static class Entity {
        private String name;
        public Entity() {}
        public Entity(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entity entity = (Entity) o;
            return Objects.equals(name, entity.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
    public static final Entity ENTITY = new Entity("hororo");

    public static void main(String[] args) {
        System.out.println(ENTITY.getName() + ENTITY.hashCode());
        ENTITY.setName("brabrabra");
        System.out.println(ENTITY.getName() + ENTITY.hashCode());
// todo: final означает всего лишь, что ссылка прикрепляется к одному объекту и не может быть от него оторвана, хотя
// изменить сам этот объект возможно, как я показал выше:
//        ENTITY = new Entity(); // а вот оторвать эту ссылку от объекта и прикрепить к другому невозможно, поскольку final
//        ENTITY = null; // тоже не выйдет
    }
}
