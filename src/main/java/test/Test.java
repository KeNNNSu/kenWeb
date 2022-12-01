package test;

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
 * @since 2022/11/30
 */
public class Test {
    public static void main(String[] args) {
        int a = 5;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        String b = "abcdefg";
        for (int i = 0; i < b.length(); i++) {
            System.out.println(b.charAt(i) + "1");
        }

    }

}
