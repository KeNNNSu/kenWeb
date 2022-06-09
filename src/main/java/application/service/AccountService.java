package application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.VoConverter;
import application.model.vo.AccountVo;
import domain.dao.AccountDao;

/**
 * <p>
 * [AccountService]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/05/01
 */
@Service
public class AccountService {
    
    @Autowired
    private AccountDao accountDao;
    
    public List<AccountVo> findAll(){
        return accountDao.findAll().stream()
          //      map(dto -> VoConverter.toVo(dto))
                .map(VoConverter::toAVo)
                .collect(Collectors.toList());
    }

}
