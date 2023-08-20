package advance.hibernate_practical;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", cert=" + cert +
                '}';
    }

    @Id
    private int id;
    private String name;
    private String city;

    public Student(int id, String name, String city, Certificate cert) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.cert = cert;
    }

    public void setCert(Certificate cert) {
        this.cert = cert;
    }

    public Certificate getCert() {
        return cert;
    }

    private Certificate cert;

    public Student() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

}
