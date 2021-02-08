package com.huchx.datajpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "m_data_jpa", schema = "spring_boot", catalog = "")
public class MUserEntity {
    private int id;
    private String name;
    private Integer status;

    public MUserEntity() {
    }

    public MUserEntity(int id, String name, Integer status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MUserEntity that = (MUserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }
}
