package com.youcode.MarocAnnonces.models.Dtos.ChercheurDto;

import com.youcode.MarocAnnonces.models.Dtos.PostulationDto.PostulationResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChercheurDto {
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

    private List<PostulationResponseDto> postulations;
}
