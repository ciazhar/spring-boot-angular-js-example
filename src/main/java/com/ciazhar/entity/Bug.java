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
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_versi")
    private Versi versi;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_submitter")
    private Tester submitter;

    @Column
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateSeen;

    @Column(nullable=false)
    @NotNull
    @NotEmpty
    private String judulBug;

    @Column(nullable=false)
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

    @Column
    @Temporal(TemporalType.DATE)
    private Date tanggalFix;

    @JoinColumn(name = "id_resolver")
    @ManyToOne
    private Programmer resolver;
}
