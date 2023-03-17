package test2;

import java.util.Map;
import java.util.TreeMap;

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
 * @since 2023/03/17
 */
public class SignUtils {
    private TreeMap<String, String> map;

    public SignUtils() {
        map = new TreeMap<String, String>();
    }

    public void put(String key, String value) {
        map.put(key, value);
    }

    public String getSign() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        }

    public static void main(String[] args) {
        // Test
        SignUtils signUtils = new SignUtils();
        signUtils.put("timestamp", "1670549739457");
        signUtils.put("amount", "100");
        signUtils.put("userName", "alden");
        signUtils.put("userPhone", "09844789231");
        signUtils.put("orderNo", "fpx08742139912");
        System.out.println(signUtils.getSign());
    }

}
