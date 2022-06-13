package infrastructure.dao;

import java.util.List;

import infrastructure.model.po.ReportGroupByCredit;
import infrastructure.model.po.ReportGroupByDebit;

/**
 * <p>
 * [報表 Dao]
 * </p>
 * 
 * @author ken
 * @since 2022/06/13
 */
public interface ReportDao {

    List<ReportGroupByDebit> findDebitAll();

    List<ReportGroupByCredit> findCreditAll();
}
