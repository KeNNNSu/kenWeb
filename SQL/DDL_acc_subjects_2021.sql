CREATE TABLE "ACC_SUBJECTS"
  (
    "ID"          NUMBER(*,0) NOT NULL ENABLE,
    "CODE"        VARCHAR2(31 BYTE) NOT NULL ENABLE,
    "NAME"        VARCHAR2(63 BYTE) NOT NULL ENABLE,
    "TIME_BUILD"  TIMESTAMP (6) NOT NULL ENABLE,
    "TIME_MODIFY" TIMESTAMP (6) NOT NULL ENABLE,
    CONSTRAINT "ACC_SUBJECTS_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 TABLESPACE "USERS" ENABLE
  )
  SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS" ;

CREATE SEQUENCE acc_subjects_id_seq;