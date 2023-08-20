package advance.hibernate_practical;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    @Column(length = 50,name = "STREET")
    private String street;
    @Column(length = 100,name = "CITY")
    private String city;
    @Column(name = "is_open")
    private boolean isOpen;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", addedDate=" + addedDate +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    @Transient
    private double x;
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @Lob
    private byte  image[];
    public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public double getX() {
        return x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public Address() {
        super();
    }


}
