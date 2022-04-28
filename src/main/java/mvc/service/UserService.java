package mvc.service;

import java.util.List;

import mvc.model.dto.UserDto;
import mvc.model.vo.UserVo;

/**
 * <p>
 * [User 服務層]
 * </p>
 * 
 * <pre>
 * -檢查參數
 *  -實作商業邏輯
 *  -資料轉換
 *  -處理異常
 * </pre>
 * 
 * @author ken
 * @since 2022/04/17
 */
public interface UserService {
    
    boolean add(UserDto userDto);

    List<UserVo> query();

    UserDto findByUid(String uid);

    UserDto findByAccount(String account);

    boolean modify(String uid, UserDto userDto);

    boolean remove(String uid);
}
