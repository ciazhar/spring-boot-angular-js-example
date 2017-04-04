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
        inverseJoinColumns = @JoinColumn(name = "id_permission")
    )
    private List<Permission> daftarPermission = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Permission> getDaftarPermission() {
        return daftarPermission;
    }

    public void setDaftarPermission(List<Permission> daftarPermission) {
        this.daftarPermission = daftarPermission;
    }
}
