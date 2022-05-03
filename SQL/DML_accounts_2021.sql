COMMENT ON TABLE "ACCOUNTS" IS '帳戶';

COMMENT ON COLUMN "ACCOUNTS"."ID" IS '序號';
COMMENT ON COLUMN "ACCOUNTS"."M_ID" IS '會員序號';
COMMENT ON COLUMN "ACCOUNTS"."ACCOUNT" IS '帳號';
COMMENT ON COLUMN "ACCOUNTS"."PASSWORD" IS '密碼';
COMMENT ON COLUMN "ACCOUNTS"."STATUS" IS '帳號狀態(0:停用, 1:啟用中, 4:已鎖定)';
COMMENT ON COLUMN "ACCOUNTS"."ERROR_TIMES" IS '登入錯誤次數';
COMMENT ON COLUMN "ACCOUNTS"."TIME_LAST" IS '最後登入日期';
COMMENT ON COLUMN "ACCOUNTS"."TIME_BUILD" IS '建立日期';
COMMENT ON COLUMN "ACCOUNTS"."TIME_MODIFY" IS '修改日期';

--data
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'super','zxc',0,0,current_timestamp,current_timestamp,current_timestamp,1);
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'asc','zxc',1,0,current_timestamp,current_timestamp,current_timestamp,1);
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'peter','zxc',1,0,current_timestamp,current_timestamp,current_timestamp,2);
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'asia','zxc',1,0,current_timestamp,current_timestamp,current_timestamp,3);
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'sandy1','zxc',1,0,current_timestamp,current_timestamp,current_timestamp,4);
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'sandy2','zxc',0,0,current_timestamp,current_timestamp,current_timestamp,4);
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'sandy3','zxc',4,3,current_timestamp,current_timestamp,current_timestamp,4);
INSERT INTO accounts(id, account, password, status, error_times, time_build, time_last, time_modify, m_id) VALUES (accounts_id_seq.nextval,'macy','zxc',1,0,current_timestamp,current_timestamp,current_timestamp,5);
