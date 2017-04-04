package com.ciazhar.entity.security;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciazhar on 4/4/17.
 */

@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id_role")
    private String id;

    @Column(name = "nama_role", unique = true)
    @NotNull
    private String nama;

    @Column(name = "label_role")
    @NotNull
    private String label;

    @ManyToMany
    @JoinTable(
        name = "role_permission",
        joinColumns = @JoinColumn(name = "id_role"),
        inverseJoinColumns = @JoinColumn(name = "id_permisssion")
    )
    private List<Role> daftarPermission = new ArrayList<>();
}
