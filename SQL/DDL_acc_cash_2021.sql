CREATE TABLE "ACC_CASH"
  (
    "JOURNAL_ID"  NUMBER,
    "INCREASE"    NUMBER,
    "REDUCE"      NUMBER,
    "TIME_BUILD"  TIMESTAMP (6),
    "TIME_MODIFY" TIMESTAMP (6),
    CONSTRAINT "TABLE1_FK1" FOREIGN KEY ("JOURNAL_ID") REFERENCES "ACC_JOURNALS" ("ID") ENABLE
  )
  SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS" ;

CREATE SEQUENCE acc_cash_journal_id_seq;
