package advance.manytomanymapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name = "project_name")
    private String pname;

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Project() {
    }

    public Project(int pid, String pname, List<Employee> employees) {
        this.pid = pid;
        this.pname = pname;
        this.employees = employees;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", employees=" + employees +
                '}';
    }

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;
}
