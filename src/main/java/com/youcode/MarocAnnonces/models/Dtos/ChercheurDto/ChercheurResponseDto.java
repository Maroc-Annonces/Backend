package com.youcode.MarocAnnonces.models.Dtos.ChercheurDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChercheurResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String educationLevel;
    private String experience;
    private String skills;
    private String image;
}
