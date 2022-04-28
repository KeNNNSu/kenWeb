package mvc.data;

import mvc.data.enums.Level;
import mvc.model.dto.UserDto;
import mvc.model.po.UserPo;
import mvc.model.vo.UserVo;

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
 * @since 2022/04/04
 */
public class DataConverter {

    public static UserVo toVo(UserPo po) {
        UserVo vo = new UserVo();
        vo.setUid(po.getUid());
        vo.setAccount(po.getAccount());
        vo.setPassword(po.getPassword());
        vo.setLevel(po.getLevel());
        return vo;
    }
    public static UserDto toDto(UserPo userPo) {
        UserDto dto = new UserDto();
        dto.setUid(userPo.getUid());
        dto.setAccount(userPo.getAccount());
        dto.setPassword(userPo.getPassword());
        dto.setLevel(Level.of(userPo.getLevel()));
        return dto;
    }
    
    public static UserPo toPo(UserDto userDto) {
        UserPo po = new UserPo();
        po.setUid(userDto.getUid());
        po.setAccount(userDto.getAccount());
        po.setPassword(userDto.getPassword());
        po.setLevel(userDto.getLevel().getValue());
        return po;
    }
}
