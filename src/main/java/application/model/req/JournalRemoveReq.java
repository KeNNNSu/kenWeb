package application.model.req;

/**
 * <p>
 * [JournalRemoveReq]
 * </p>
 * 
 * @author ken
 * @since 2022/06/01
 */
public class JournalRemoveReq {

    private String journalBookId;

    public void setJournalBookId(String journalBookId) {
        this.journalBookId = journalBookId;
    }

    public String getJournalBookId() {
        return journalBookId;
    }

    @Override
    public String toString() {
        return "JournalRemoveReq [journalBookId=" + journalBookId + "]";
    }

}
