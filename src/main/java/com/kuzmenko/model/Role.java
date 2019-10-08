package com.kuzmenko.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    public static final String ROLE_PREFIX = "ROLE_";


    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private Integer id;

    @Column(name = "role_name")
//    @Enumerated(EnumType.STRING)
    private String role;

    public Role(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return ROLE_PREFIX + getRole();
    }

    //        USER("USER"),
//
//        ADMIN("ADMIN"),
//
//        SUPER_ADMIN("SUPER_ADMIN");
//
//        private String text;
//
//        RoleName(String user) {
//
//        }
}


