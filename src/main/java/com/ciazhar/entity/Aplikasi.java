package com.ciazhar.entity;

import com.ciazhar.entity.role.ProjectManager;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ciazhar on 3/30/17.
 */

@Entity
public class Aplikasi {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_aplikasi")
    private String id;

    @Column(name = "nama_aplikasi",nullable=false, unique = true)
    @NotNull
    @NotEmpty
    private String nama;

    @Column(name="status_rilis_aplikasi", nullable = false, columnDefinition = "boolean DEFAULT 0")
    @NotNull
    private boolean statusRilis;

    @OneToOne
    @JoinColumn(name = "id_project_manager")
    private ProjectManager projectManager;

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

    public boolean isStatusRilis() {
        return statusRilis;
    }

    public void setStatusRilis(boolean statusRilis) {
        this.statusRilis= statusRilis;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
}
