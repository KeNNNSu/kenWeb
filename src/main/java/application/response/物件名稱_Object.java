package application.response;

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
 * @since 2022/06/07
 */
public class 物件名稱_Object {

    private String 名字;

    public 物件名稱_Object() {
        super();
    }

    public 物件名稱_Object(String 名字) {
        this();
        this.名字 = 名字;
    }

    public 回傳型態 方法名稱(參數 參數1) {
        return new 回傳型態();
    }
    
    static class 回傳型態 {
        
    }
    
    static class 參數 {
        
    }
    
    public String get名字() {
        return 名字;
    }

    public void set名字(String 名字) {
        this.名字 = 名字;
    }

    @Override
    public String toString() {
        return "物件名稱 [名字=" + 名字 + "]";
    }

    public static void main(String[] args) {
        物件名稱_Object 變數名稱 = new 物件名稱_Object("jj");
        變數名稱.get名字();
        System.out.println(變數名稱);
    }
}
