package io.github.jojomoomaw.JavaSQLPractice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "distributor")
public class Distributor {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "brands_list")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "distributor")
    private List<Brand> brands;

    public Distributor() {}

    public Distributor(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Distributor [id=" + id + ", name=" + name + "]";
    }
}
