package com.labskeleton.kuzmenko.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    String accessToken;

    String refreshToken;

}
