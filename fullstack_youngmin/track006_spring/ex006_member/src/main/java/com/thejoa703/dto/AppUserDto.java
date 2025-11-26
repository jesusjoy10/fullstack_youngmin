package com.thejoa703.dto;





import lombok.Data;

@Data
public class AppUserDto {
	private int appUserId;
	private String email;
	private String password;
	private int mbtiTypeId;
	private String  createdAt; 
	private String ufile;

}
