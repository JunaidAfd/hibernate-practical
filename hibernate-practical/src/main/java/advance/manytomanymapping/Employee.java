package advance.manytomanymapping;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    public void setEid(int eid) {
        this.eid = eid;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }

    public Employee(int eid, String name, List<Project> projects) {
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public int getEid() {
        return eid;
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Id
    private int eid;
    private String name;
    @ManyToMany
    @JoinTable(name="emp_proj_join",
            joinColumns = {@JoinColumn(name = "eid")},
            inverseJoinColumns = {@JoinColumn(name = "pid")}
    )
    private List<Project> projects;

}
