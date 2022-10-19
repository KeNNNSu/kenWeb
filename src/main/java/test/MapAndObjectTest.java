package test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * [TODO]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/06/22
 */
public class MapAndObjectTest {

    public static Info toInfo(Map<String, Object> map) {
        Info info = new Info();
        // ....
        return info;
    }
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(); // 1000,000
        map.put("name", "ken");
        map.put("age", 20);
        map.put("email", "abcd@gmail.com");
        map.put("merry", false);
        
        Info info = new Info((String)map.get("name"), (String)map.get("email"));
        System.out.println(info);

        System.out.println(map.get("age"));
        int newAge = ((int) map.get("age")) + 1;
        System.out.println(newAge);

        System.out.println();

        Person person = new Person("cano", 28, "qwer@gmail.com", false);
        int newAge2 = person.getAge() + 1;
        System.out.println(newAge2);
        System.out.println(person.getAge());
        
        Info info2 = person.toInfo();
        System.out.println(info2);
    }

    public static class Info {
        private String name;
        private String email;

        public Info() {
            super();
        }

        public Info(String name, String email) {
            super();
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class Person {
        private String name;
        private Integer age;
        private String email;
        private boolean merry;

        public Person() {
            super();
        }

        public Person(String name, Integer age, String email, boolean merry) {
            super();
            this.name = name;
            this.age = age;
            this.email = email;
            this.merry = merry;
        }
        
        public Info toInfo() {
            return new Info(name, email);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isMerry() {
            return merry;
        }

        public void setMerry(boolean merry) {
            this.merry = merry;
        }
    }
}
