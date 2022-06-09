package domain.dao;

import java.util.List;

import domain.model.dto.Account;

/**
 * <p>
 * [AccountDao]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/01
 */
public interface AccountDao {
    
    public List<Account> findAll();

}
