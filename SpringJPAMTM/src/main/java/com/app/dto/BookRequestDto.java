
package com.app.dto;


import com.app.entities.BookType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookRequestDto {
	
	private String btitle;
	private double price;
	private BookType type;
}
