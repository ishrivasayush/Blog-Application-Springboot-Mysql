package com.Narainox.blog.BlogAppAPI.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int categoryId;
    @NotEmpty
    @Size(min = 3,max = 20,message = "Input Range min 3 and max 20")
    private String categoryName;

    @NotEmpty
    @Size(min = 3,max = 20,message = "Input Range min 3 and max 20")
    private String categoryDescription;
}
