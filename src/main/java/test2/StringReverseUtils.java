package test2;

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
public class StringReverseUtils {

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public String reverse(String s, int k) {
        StringBuilder sb = new StringBuilder(s.substring(0, k + 1)).reverse();
        sb.append(s.substring(k + 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test
        StringReverseUtils utils = new StringReverseUtils();
        System.out.println(utils.reverse("abcde"));
        System.out.println(utils.reverse("abcde", 3));
    }

}
