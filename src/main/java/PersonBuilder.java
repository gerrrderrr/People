public class PersonBuilder {
    private String name;
    private String lastname;
    private int age;
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0 && age < 150) {
            this.age = age;
            return this;
        } else
            throw new IllegalArgumentException("Invalid value entered. Entered: " + age + ". Expected: value from 0 to 150.");
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (city != null && age == 0) {
            return new Person(name, lastname, city);
        } else if (city == null && age != 0) {
            return new Person(name, lastname, age);
        } else if (city != null && age != 0) {
            return new Person(name, lastname, age, city);
        } else if (name == null || lastname == null) {
           throw new IllegalStateException("Missing name or lastname. Name entered: " + name +
                   ". Lastname entered: " + lastname + ".");
        } else return new Person(name, lastname);
    }
}
