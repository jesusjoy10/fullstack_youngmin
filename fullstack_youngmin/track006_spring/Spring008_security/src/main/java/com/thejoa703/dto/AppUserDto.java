package com.thejoa703.dto;

import lombok.Data;

@Data
public class AppUserDto {
	private int  appUserId;
	private String email;
	private String password;
	private String region;
	private String createdAt;
	private String ufile;

		
	}


/*

--		SQL> desc appuser;
--		Name                                      Null?    Type
--		----------------------------------------- -------- ----------------------------
--		APP_USER_ID                               NOT NULL NUMBER(5)
--		EMAIL                                     NOT NULL VARCHAR2(100)
--		PASSWORD                                           VARCHAR2(100)
--		region                                    		  VARCHAR2(50)
--		CREATED_AT                                         DATE
*/