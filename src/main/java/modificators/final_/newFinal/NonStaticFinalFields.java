package modificators.final_.newFinal;

public class NonStaticFinalFields {
//    NB: ЛЮБОЕ финальное поле нужно инициализировать, причем статическое - немедленно или в статическом блоке ин-ции.
    public static final String stat = "stat";
    public final String nonstat; // также нужно обязательно инициализировать! попробуем через шаблон Builder
    public final String optional; // также нужно обязательно инициализировать

//    инициализация финальных полей в конструкторе:
    private NonStaticFinalFields(Builder builder) {
        nonstat = builder.nonstat;
        optional = builder.optional;
    }

    public static class Builder {
        private final String nonstat;
        private String optional; // это поле может иметь значение по умолчанию, необязательно для инициализации
//        инициализация финального поля в конструкторе:
        public Builder(String nonstat) {
            this.nonstat = nonstat;
        }
        public Builder setOptional(String optional) {
            this.optional = optional;
            return this; // NB: возвращаем Builder, чтобы м.б. выстраивать сеттеры в цепочку
        }
        public NonStaticFinalFields build() {
            return new NonStaticFinalFields(this);
        }
    }

    @Override
    public String toString() {
        return "NonStaticFinalFields{" +
                "nonstat='" + nonstat + '\'' +
                ", optional='" + optional + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Builder("nonstat").setOptional("optional").build());
    }
}
