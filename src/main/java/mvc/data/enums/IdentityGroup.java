package mvc.data.enums;

/**
 * <p>
 * [身分組] 不懂 void (return this;)
 * </p>
 *
 * @author ken
 * @since 2022/04/06
 */
public class IdentityGroup {
    
    private boolean boss;
    private boolean manager;
    private boolean employee;
    
    public boolean isBoss() {
        return boss;
    }
    public IdentityGroup setBoss(boolean boss) {
        this.boss = boss;
        return this;
    }
    public boolean isManager() {
        return manager;
    }
    public IdentityGroup setManager(boolean manager) {
        this.manager = manager;
        return this;
    }
    public boolean isEmployee() {
        return employee;
    }
    public IdentityGroup setEmployee(boolean employee) {
        this.employee = employee;
        return this;
    }
    @Override
    public String toString() {
        return "IdevtityGroup [boss=" + boss + ", manager=" + manager + ", employee=" + employee + "]";
    }

}
