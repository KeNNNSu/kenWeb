package domain.dao;

import java.util.List;

import domain.model.dto.JournalBook;

/**
 * <p>
 * [JournalBookDao]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
public interface JournalBookDao {

    List<JournalBook> findAll();

    boolean add(JournalBook journalBook);

    boolean modify(Long journalBookId, JournalBook journalBook);

    boolean remove(Long journalBookId);

    Long findNextId();

    JournalBook findLatest();

    JournalBook findById(Long journalBookId);
}
