package com.ciazhar.entity;

import com.ciazhar.entity.role.Programmer;
import com.ciazhar.entity.role.Tester;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ciazhar on 3/30/17.
 */

@Entity
public class Bug {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_bug")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_versi")
    private Versi versi;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_tester")
    private Tester submitter;

    @Column(name = "date_seen")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateSeen;

    @Column(name = "judul_bug",nullable=false)
    @NotNull
    @NotEmpty
    private String judulBug;

    @Column(name = "deskripsi_bug", nullable=false)
    @NotNull
    @NotEmpty
    private String deskripsiBug;

    @JoinColumn(name = "id_severity")
    @NotNull
    @ManyToOne
    private Severity severity;

    @ManyToOne
    @JoinColumn(name = "id_penanggung_jawab")
    private Programmer penanggungJawab;

    @Column(name = "tanggal_fix")
    @Temporal(TemporalType.DATE)
    private Date tanggalFix;

    @JoinColumn(name = "id_resolver")
    @ManyToOne
    private Programmer resolver;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Versi getVersi() {
        return versi;
    }

    public void setVersi(Versi versi) {
        this.versi = versi;
    }

    public Tester getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Tester submitter) {
        this.submitter = submitter;
    }

    public Date getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(Date dateSeen) {
        this.dateSeen = dateSeen;
    }

    public String getJudulBug() {
        return judulBug;
    }

    public void setJudulBug(String judulBug) {
        this.judulBug = judulBug;
    }

    public String getDeskripsiBug() {
        return deskripsiBug;
    }

    public void setDeskripsiBug(String deskripsiBug) {
        this.deskripsiBug = deskripsiBug;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Programmer getPenanggungJawab() {
        return penanggungJawab;
    }

    public void setPenanggungJawab(Programmer penanggungJawab) {
        this.penanggungJawab = penanggungJawab;
    }

    public Date getTanggalFix() {
        return tanggalFix;
    }

    public void setTanggalFix(Date tanggalFix) {
        this.tanggalFix = tanggalFix;
    }

    public Programmer getResolver() {
        return resolver;
    }

    public void setResolver(Programmer resolver) {
        this.resolver = resolver;
    }
}
