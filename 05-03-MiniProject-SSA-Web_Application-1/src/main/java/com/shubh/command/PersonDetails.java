package com.shubh.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonDetails {
    
	private int personId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
}
