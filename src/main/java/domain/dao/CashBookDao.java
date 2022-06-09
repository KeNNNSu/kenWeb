package domain.dao;

import java.util.List;

import domain.model.dto.CashBook;

/**
 * <p>
 * [CashBookDao]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
public interface CashBookDao {

    List<CashBook> findAll();

    boolean add(CashBook cashBook);

    boolean modify(Long journalBookId, CashBook cashBook);

    boolean remove(Long journalBookId);
}
