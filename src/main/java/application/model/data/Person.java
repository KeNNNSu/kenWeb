package application.model.data;

/**
 * [Person]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
public class Person {

    private String name;
    private String email;
    private String phone;

    public Person(String name) {
        super();
        setName(name);
    }

    private Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }

}
