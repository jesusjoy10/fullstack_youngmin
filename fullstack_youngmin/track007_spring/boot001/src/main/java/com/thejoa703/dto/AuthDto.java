package com.thejoa703.dto;

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
public class AuthDto {
	private int AUTH_ID;
	private String email;
	private String auth;
	private int appUserId;

	

}
