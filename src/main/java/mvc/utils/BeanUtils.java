package mvc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;

import oracle.sql.TIMESTAMP;

/**
 * <p>
 * [Java Bean 工具] 不懂 
 * </p>
 * 

 * 
 * @author ken
 * @since 2022/04/04
 */
public class BeanUtils {

    
    public static <T> T toBean(Map<String, Object> map, Class<T> clazz) {
        return toBean(map, clazz, false);
    }

    public static <T> T toBean(Map<String, Object> map, Class<T> clazz, boolean isEntity) {
        try {
            // 用 .class 建立空物件
            T bean = clazz.getDeclaredConstructor().newInstance();
            // 用 .class 取得所有宣告屬性
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                String fieldName = f.getName(); // 取得屬性名稱
                String columnName = f.getAnnotation(Column.class).name(); // @Column 名稱
                String set = toSetMethodName(fieldName); // 轉換 set 方法名稱
                Method setMethod = clazz.getMethod(set, f.getType()); // 取得 set 方法
                // 若為 Entity, map key 為 @Column 的名稱
                Object value = map.get(isEntity ? columnName : fieldName); // 取得屬性值
                if (value != null)
                    if (f.getType() == int.class && value instanceof BigDecimal) {
                        setMethod.invoke(bean, ((BigDecimal) value).intValue());
                    } else if (f.getType() == Date.class && value instanceof TIMESTAMP) {
                        try {
                            long timestamp = ((TIMESTAMP) value).dateValue().getTime();
                            setMethod.invoke(bean, new Date(timestamp));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        
                    } else {
                        setMethod.invoke(bean, value); // 設定值到 bean
                    }

                // 測試
                String get = toGetMethodName(fieldName);
                Method getMethod = clazz.getMethod(get);
                System.out.println(fieldName + ": " + getMethod.invoke(bean));
            }
            return bean;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 轉換 get 方法名稱
    private static String toGetMethodName(String fieldName) {
        return ofMethodName("get", fieldName);
    }

    // 轉換 set 方法名稱
    private static String toSetMethodName(String fieldName) {
        return ofMethodName("set", fieldName);
    }

    // 建立 方法名稱
    private static String ofMethodName(String perfix, String fieldName) {
        if (fieldName == null)
            throw new IllegalArgumentException("fieldName 不可為空!!");
        String first = String.valueOf(fieldName.charAt(0)).toUpperCase();
        String other = fieldName.substring(1);
        return String.format("%s%s%s", perfix, first, other);
    }
}
