package application.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * [月份]
 * </p>
 * 
 * @author ken
 * @since 2022/06/15
 */
public enum Month {

    M1(1), M2(2), M3(3), M4(4), M5(5), M6(6), M7(7), M8(8), M9(9), M10(10), M11(11), M12(12);

    private int value;

    static class FindEnum {
        static Map<Integer, Month> byValueInMap = new HashMap<>();
    }

    private Month(int value) {
        this.value = value;
        FindEnum.byValueInMap.put(value, this);
    }

    public static Month of(int value) {
        return FindEnum.byValueInMap.get(value);
    }

    public int getValue() {
        return value;
    }
}
