public class Main {
    public static void main(String[] args) {
        Person person1 = new PersonBuilder()
                .setName("Anna")
                .setLastname("Brooks")
                .setAge(45)
                .setCity("Moscow")
                .build();
        person1.happyBirthday();
        System.out.println(person1);
        Person son = person1.newChildBuilder()
                .setName("Sally")
                .build();
        son.happyBirthday();
        System.out.println(son);

        try {
            new PersonBuilder().setName("Hanna").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
