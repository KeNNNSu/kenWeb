package mvc.dao;

import java.util.List;

import mvc.model.po.UserPo;

/**
 * <p>
 *  [User 資料存取層]
 * </p>
 * 
 * @author ken
 * @since 2022/04/04
 */
public interface UserDao {
    
    boolean insert(UserPo userPo);
    
    List<UserPo> findAll();
    
    UserPo findByUid(String uid);
    
    UserPo findByAccount(String account);
    
    boolean update(String uid, UserPo userPo);
    
    boolean delete(String uid);

}
