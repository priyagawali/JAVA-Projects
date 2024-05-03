package com.iastech.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {

	private int id;
	@NotEmpty
	@Size(min=4,message = "Username must be minimium of 4 characters.")
	private String name;
	@Email(message = "Email id is not valid.")
	private String email;
	@NotEmpty
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "Password must be at least 8 char & max 20 chars, also Password must contain at least one lower case,one upper case,one special char and one number.")
	private String password;
	@NotEmpty
	private String about;

}
