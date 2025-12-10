package com.thejoa703.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sboard2Dto {
    /*   자료형이 달라서.... 매핑이 안된거같아요. sql 구문은 맞고요~!
	 private Long id;
	    private Long appUserId;
	    private String btitle;
	    private String bcontent;
	    private String bpass;
	    private String bfile;
	    private Integer bhit;
	    private String bip;
	    private Date createdAt;
	    
	     */
    private int id;               // ID
    private int appUserId;        // APP_USER_ID
    private String btitle;        // BTITLE
    private String bcontent;      // BCONTENT
    private String bpass;         // BPASS
    private String bfile;         // BFILE (default: 'no.png')
    private int bhit;             // BHIT (default: 0)
    private String bip;           // BIP
	private String createdAt;

}


/* SQL> desc sboard2;
   Name                                      Null?    Type
   ----------------------------------------- -------- ----------------------------
   ID                                        NOT NULL NUMBER
   APP_USER_ID                               NOT NULL NUMBER
   BTITLE                                    NOT NULL VARCHAR2(1000)
   BCONTENT                                  NOT NULL CLOB
   BPASS                                     NOT NULL VARCHAR2(255)
   BFILE                                              VARCHAR2(255)
   BHIT                                               NUMBER(10)
   BIP                                       NOT NULL VARCHAR2(255)
   CREATED_AT                                          DATE*/

