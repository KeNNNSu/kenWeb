COMMENT ON TABLE "MEMBERS" IS '會員';

COMMENT ON COLUMN "MEMBERS"."ID" IS '序號';
COMMENT ON COLUMN "MEMBERS"."NAME" IS '姓名';
COMMENT ON COLUMN "MEMBERS"."EMAIL" IS '電子郵件';
COMMENT ON COLUMN "MEMBERS"."PHONE" IS '手機';
COMMENT ON COLUMN "MEMBERS"."TIME_MODIFY" IS '修改日期';
COMMENT ON COLUMN "MEMBERS"."TIME_BUILD" IS '建立日期';

--data
INSERT INTO members(id, name, email, phone, time_build, time_modify) VALUES (members_id_seq.nextval,'Asu','asu@gmail.com','0987654321',current_timestamp,current_timestamp);
INSERT INTO members(id, name, email, phone, time_build, time_modify) VALUES (members_id_seq.nextval,'Peter','peter@gmail.com','0954328761',current_timestamp,current_timestamp);
INSERT INTO members(id, name, email, phone, time_build, time_modify) VALUES (members_id_seq.nextval,'Asia','asia@gmail.com','0985287456',current_timestamp,current_timestamp);
INSERT INTO members(id, name, email, phone, time_build, time_modify) VALUES (members_id_seq.nextval,'Sandy','sandy@gmail.com','0912356855',current_timestamp,current_timestamp);
INSERT INTO members(id, name, email, phone, time_build, time_modify) VALUES (members_id_seq.nextval,'Macy','macy@gmail.com','0911213111',current_timestamp,current_timestamp);
