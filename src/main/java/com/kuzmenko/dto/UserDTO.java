package com.kuzmenko.dto;

import com.kuzmenko.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Status status;
    private Date createdAt;
    private Date lastModifiedAt;

}
