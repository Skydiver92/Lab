package com.labskeleton.kuzmenko.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {



    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private Integer id;
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleList role;

    public Role(RoleList role) {
        this.role = role;
    }

}
