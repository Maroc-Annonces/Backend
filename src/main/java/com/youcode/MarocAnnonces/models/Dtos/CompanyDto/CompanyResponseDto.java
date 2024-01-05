package com.youcode.MarocAnnonces.models.Dtos.CompanyDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private String image;
    private String login;
}
