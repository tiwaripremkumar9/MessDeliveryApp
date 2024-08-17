package com.techviz.app.dto;

import com.techviz.app.pojos.Locality;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessDTO {
	
	private String messName;
	private Locality locality;
	private long phone;

}
