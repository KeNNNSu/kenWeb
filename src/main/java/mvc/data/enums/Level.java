package mvc.data.enums;

import java.util.HashMap;
import java.util.Map;



/**
 * <p>
 * [分級]
 * </p>
 * 

 * 
 * @author ken
 * @since 2022/04/04
 */
public enum Level {
    LEVEL1(1, "Lv1") {
        @Override
        IdentityGroup getIdentityGroup() {
            IdentityGroup ig = new IdentityGroup()
                    .setBoss(false)
                    .setManager(false)
                    .setEmployee(true);
            return ig;
        }
    },
    LEVEL2(2, "Lv2") {
        @Override
        IdentityGroup getIdentityGroup() {
            IdentityGroup ig = new IdentityGroup()
                    .setBoss(false)
                    .setManager(false)
                    .setEmployee(true);
            return ig;
        }
    },
    LEVEL3(3, "Lv3") {
        @Override
        IdentityGroup getIdentityGroup() {
            IdentityGroup ig = new IdentityGroup()
                    .setBoss(false)
                    .setManager(true)
                    .setEmployee(true);
            return ig;
        }
    },
    LEVEL4(4, "Lv4") {
        @Override
        IdentityGroup getIdentityGroup() {
            IdentityGroup ig = new IdentityGroup()
                    .setBoss(true)
                    .setManager(true)
                    .setEmployee(true);
            return ig;
        }
    };

    private int value;
    private String lv;

//    // map 1
//    public static Map<Integer, Level> map = new HashMap<>(); // 不建議

    // map 2
    static class Holder {
        static Map<Integer, Level> map = new HashMap<>(); // 建議
    }

    abstract IdentityGroup getIdentityGroup();

    public IdentityGroup get() {
        IdentityGroup ig = new IdentityGroup()
                .setEmployee(true);
        if (this.getValue() == 3)
            ig.setManager(true);
        if (this.getValue() == 4) {
            ig.setManager(true);
            ig.setBoss(true);
        }
        return ig;
    }

    private Level(int value, String lv) {
        this.value = value;
        this.lv = lv;
        System.out.println(this.toString() + " " + value + " " + lv);
        Holder.map.put(value, this);
    }

    public static Level of(int lv) {

//        // foreach 1
//        for (Level level : Level.values())
//            if (lv == level.getValue())
//                return level;
//        return null;

//        // map 1
//        return Level.LEVEL1.map.get(lv); // 不建議

        // map 2
        return Holder.map.get(lv);
    }

    public int getValue() {
        return value;
    }

    public String getLv() {
        return lv;
    }

}
