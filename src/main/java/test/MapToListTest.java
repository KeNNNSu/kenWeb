package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class MapToListTest {

    public static void main(String[] args) {
        List<People> peoples = getListFromDB2();
        Map<String, People> checkMap = new HashMap<>();
        for (People p : peoples) {
            checkMap.put(p.getId(), p);
        }
        String queryId = "F8575";
        System.out.println(checkMap.get(queryId));
    }

    public static List<Map<String, Object>> getListFromDB() {
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "F1234");
        map1.put("name", "bob");
        map1.put("age", 18);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "F8575");
        map2.put("name", "anita");
        map2.put("age", 19);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", "F1575");
        map3.put("name", "cherry");
        map3.put("age", 14);
        maps.add(map1);
        maps.add(map2);
        maps.add(map3);
        return maps;
    }

    public static List<People> getListFromDB2() {
        List<People> peoples = new ArrayList<>();
        peoples.add(new People("F1234", "bob", 18));
        peoples.add(new People("F8575", "anita", 19));
        peoples.add(new People("F1575", "cherry", 14));
        return peoples;
    }

    public static class People {
        private String id;
        private String name;
        private int age;

        public People() {
            super();
        }

        public People(String id, String name, int age) {
            super();
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "People [id=" + id + ", name=" + name + ", age=" + age + "]";
        }

    }
}
