package domain.model.dto;

/**
 * <p>
 * [包含現金科目物件]
 * </p>
 * 
 * @author ken
 * @since 2022/05/30
 */
public class IncludeCashOfSubject {

    private static String subjectOfCash = "1-1-1-1";

    private boolean includeCashOfDebit;
    private boolean includeCashOfCredit;
    private boolean includeCash;

    private IncludeCashOfSubject() {
        super();
    }

    private IncludeCashOfSubject(boolean includeCashOfDebit, boolean includeCashOfCredit) {
        super();
        this.includeCashOfDebit = includeCashOfDebit;
        this.includeCashOfCredit = includeCashOfCredit;
        if (includeCashOfDebit || includeCashOfCredit)
            includeCash = true;
    }

    public static IncludeCashOfSubject from(Subject debit, Subject credit) {
        boolean includeCashOfDebit = false;
        boolean includeCashOfCredit = false;
        if (subjectOfCash.equals(debit.getCode()))
            includeCashOfDebit = true;
        if (subjectOfCash.equals(credit.getCode()))
            includeCashOfCredit = true;
        return new IncludeCashOfSubject(includeCashOfDebit, includeCashOfCredit);
    }

    public static void setSubjectOfCash(String subjectOfCash) {
        IncludeCashOfSubject.subjectOfCash = subjectOfCash;
    }

    public void setIncludeCashOfDebit(boolean includeCashOfDebit) {
        this.includeCashOfDebit = includeCashOfDebit;
    }

    public void setIncludeCashOfCredit(boolean includeCashOfCredit) {
        this.includeCashOfCredit = includeCashOfCredit;
    }

    public void setIncludeCash(boolean includeCash) {
        this.includeCash = includeCash;
    }

    public static String getSubjectOfCash() {
        return subjectOfCash;
    }

    public boolean isIncludeCashOfDebit() {
        return includeCashOfDebit;
    }

    public boolean isIncludeCashOfCredit() {
        return includeCashOfCredit;
    }

    public boolean isIncludeCash() {
        return includeCash;
    }

    @Override
    public String toString() {
        return "IncludeCashOfSubject [includeCashOfDebit=" + includeCashOfDebit + ", includeCashOfCredit="
                + includeCashOfCredit + ", includeCash=" + includeCash + "]";
    }

}
