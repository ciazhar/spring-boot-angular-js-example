package com.ciazhar.entity;

import com.ciazhar.entity.security.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ciazhar on 4/3/17.
 */

@Entity
public class Employee {

    @Id@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id_employee")
    private String id;

    @Column(nullable=false)
    @NotNull
    @NotEmpty
    private String nama;

    @Column(nullable=false)
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
