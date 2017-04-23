package com.ciazhar.entity.role;

import com.ciazhar.entity.Aplikasi;
import com.ciazhar.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciazhar on 3/30/17.
 */

@Entity
public class ProjectManager {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id_project_manager")
    private String id;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
//            orphanRemoval = true,
            mappedBy = "projectManager"
    )
    private List<Aplikasi> daftarAplikasi = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Aplikasi> getDaftarAplikasi() {
        return daftarAplikasi;
    }

    public void setDaftarAplikasi(List<Aplikasi> daftarAplikasi) {
        this.daftarAplikasi = daftarAplikasi;
    }
}
