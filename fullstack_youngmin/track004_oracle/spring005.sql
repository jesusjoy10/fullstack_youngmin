 CREATE TABLE sboard1 (
  ID          NUMBER PRIMARY KEY,
  APP_USER_ID NUMBER NOT NULL,
  BTITLE      VARCHAR2(1000) NOT NULL,
  BCONTENT    CLOB NOT NULL,
  BPASS       VARCHAR2(255) NOT NULL,
  BFILE       VARCHAR2(255),
  BHIT        NUMBER(10),
  BIP         VARCHAR2(255) NOT NULL,
  CREATE_AT   TIMESTAMP(6)
);

CREATE SEQUENCE sboard1_seq START WITH 1 INCREMENT BY 1;


INSERT INTO sboard1 (ID, APP_USER_ID, BTITLE, BCONTENT, BPASS, BIP)
VALUES (sboard1_seq.NEXTVAL, 21, 'title', 'content', '1111', '127.0.0.1');

select * from sboard1 order by id desc;


select * from sboard1 where id=4;

update sboard1
       set BTITLE= 'new1' , BCONTENT='content1',
       where id=4;  and BPASS='1111';

DELETE FROM sboard1 WHERE ID = 4;




