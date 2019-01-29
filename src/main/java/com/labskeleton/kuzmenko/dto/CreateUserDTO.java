package com.labskeleton.kuzmenko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
