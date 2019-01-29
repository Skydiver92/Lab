package com.labskeleton.kuzmenko.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public enum RoleList {

    USER("USER"),
    ADMIN("ADMIN"),
    SUPER_ADMIN("SUPER_ADMIN");

    @Getter
    String text;

}