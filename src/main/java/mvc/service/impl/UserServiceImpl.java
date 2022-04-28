package mvc.service.impl;

import mvc.dao.impl.SystemParamsDaoImpl;
import mvc.dao.impl.UserDaoImpl;
import mvc.service.UserService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import mvc.data.DataConverter;
import mvc.data.enums.Level;
import mvc.model.dto.UserDto;
import mvc.model.po.UserPo;
import mvc.model.vo.UserVo;
import mvc.dao.SystemParamsDao;
import mvc.dao.UserDao;

/**
 * <p>
 * [UserService] -實作類
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/04/17
 */
public class UserServiceImpl implements UserService {
    
    private SystemParamsDao systemParamsDao;
    private UserDao userDao;
    
    public UserServiceImpl() {
        super();
        this.userDao = new UserDaoImpl();
        this.systemParamsDao = new SystemParamsDaoImpl();
    }

    @Override
    public boolean add(UserDto userDto) {
        String k = "next.uid";
        String uid = systemParamsDao.find(k).getV();
        userDto.setUid(uid);
        userDto.setLevel(Level.LEVEL1);
        UserPo userPo = DataConverter.toPo(userDto);
        boolean result = userDao.insert(userPo);
        result = result && systemParamsDao.update(k, SystemParamsDao.nextUID(uid));
        return result;
    }

    @Override
    public List<UserVo> query() {
//        // 一般用法
//        List<UserVo> dtoList = new ArrayList<>();
//        for (UserPo po : userDao.findAll())
//            dtoList.add(DataConverter.toVo(po));

        // 進階用法: java 8 (lambda 表達式)
        Function<UserPo, UserVo> transfer = po -> DataConverter.toVo(po);
        List<UserVo> dtoList = userDao.findAll().stream()
                .map(transfer)
//                .filter(dto -> dto.getLevel().getValue() > 2)
                .sorted((o1, o2) -> o1.getUid().hashCode() - o2.getUid().hashCode())
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public UserDto findByUid(String uid) {
        UserPo userPo = userDao.findByUid(uid);
        return DataConverter.toDto(userPo);
    }

    @Override
    public UserDto findByAccount(String account) {
        UserPo userPo = userDao.findByAccount(account);
        return DataConverter.toDto(userPo);
    }

    @Override
    public boolean modify(String uid, UserDto userDto) {
        UserPo oriUserPo = userDao.findByUid(uid);
        if (oriUserPo == null)
            throw new IllegalArgumentException(uid + " 查無此資料!!");
        // 只有改密碼
        oriUserPo.setPassword(userDto.getPassword());
        return userDao.update(uid, oriUserPo);
    }

    @Override
    public boolean remove(String uid) {
        return userDao.delete(uid);
    }
    

}
