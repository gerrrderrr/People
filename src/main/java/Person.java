import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String lastname;
    private int age;
    private String city;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Person(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public Person(String name, String lastname, String city) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
    }

    public Person(String name, String lastname, int age, String city) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasCity() {
        return city != null;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getCity() {
        if (hasCity()) {
            return city;
        }
        return "No city was added";
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setLastname(lastname).setCity(city).setAge(0);
    }

    @Override
    public String toString() {
        if (!hasCity() && hasAge()) {
            return name + " " + lastname + ", " + age + " y.o.";
        } else if (hasCity() && !hasAge()) {
            return name + " " + lastname + " from " + city;
        } else if (hasCity() && hasAge()) {
            return name + " " + lastname + ", " + age + " y.o. from " + city;
        } else return name + " " + lastname;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + lastname.hashCode() + (hasCity() ? getCity().hashCode() : 0) + (hasAge() ? age : 0);
    }
}
