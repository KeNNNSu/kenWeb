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
//        System.out.println(b.charAt(0)+"1");
//        System.out.println(b.charAt(1)+"1");
//        System.out.println(b.charAt(2)+"1");
//        System.out.println(b.charAt(3)+"1");
//        System.out.println(b.charAt(4)+"1");
//        System.out.println(b.charAt(5)+"1");
//        System.out.println(b.charAt(6)+"1");
//        
//        System.out.println();
//        
        for (int i=0;i<b.length();i++) {
            System.out.println(b.charAt(i)+"1");
        }
       
    }

}
