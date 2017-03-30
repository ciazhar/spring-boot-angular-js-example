package com.ciazhar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciazhar on 3/30/17.
 */

@Entity
public class Versi {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable=false)
    @NotNull
    @NotEmpty
    private String version;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_aplikasi")
    private Aplikasi aplikasi;

    @OneToMany(
            mappedBy = "versi",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Bug> daftarBug = new ArrayList<>();
}
