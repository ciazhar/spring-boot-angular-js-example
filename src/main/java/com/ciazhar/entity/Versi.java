package com.ciazhar.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ciazhar on 3/30/17.
 */

@Entity
public class Versi {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_versi")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_aplikasi")
    private Aplikasi aplikasi;

    @Column(nullable=false, unique = true)
    @NotNull
    @NotEmpty
    private String versi;

    @Column(name = "tanggal_dibuat")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date tanggalDibuat;

    @Column(name = "tanggal_rilis")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date tanggalRilis;


    @OneToMany(
            mappedBy = "versi",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Bug> daftarBug = new ArrayList<>();

    public Aplikasi getAplikasi() {
        return aplikasi;
    }

    public void setAplikasi(Aplikasi aplikasi) {
        this.aplikasi = aplikasi;
    }

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public Date getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(Date tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersi() {
        return versi;
    }

    public void setVersi(String versi) {
        this.versi = versi;
    }


    public List<Bug> getDaftarBug() {
        return daftarBug;
    }

    public void setDaftarBug(List<Bug> daftarBug) {
        this.daftarBug = daftarBug;
    }
}
