package com.iastech.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotEmpty
	@Size(max=20,message = "Title must be have less than 20 characters")
	private String categoryTitle;
	@NotEmpty
	@Size(min = 4,message = "Description must contain at least 4 characters.")
	private String categoryDescription;
}
