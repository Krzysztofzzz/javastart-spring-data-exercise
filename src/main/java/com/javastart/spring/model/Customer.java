package com.javastart.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(length = 11)
    private String peselNumber;
    @Column(name = "person_id_number", length = 10)
    private String personIDNumber;
    @ManyToMany(mappedBy = "customers",
    fetch = FetchType.EAGER)
    private List<Device> rentDevices = new ArrayList<>();

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getPersonIDNumber() {
        return personIDNumber;
    }

    public void setPersonIDNumber(String personIDNumber) {
        this.personIDNumber = personIDNumber;
    }

    public List<Device> getRentDevices() {
        return rentDevices;
    }

    public void setRentDevices(List<Device> rentDevices) {
        this.rentDevices = rentDevices;
    }
    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", imię='" + firstName + '\'' +
                ", nazwisko='" + lastName + '\'' +
                ", pesel='" + peselNumber + '\'' +
                ", nr dowodu='" + personIDNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(peselNumber, customer.peselNumber) && Objects.equals(personIDNumber, customer.personIDNumber) && Objects.equals(rentDevices, customer.rentDevices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, peselNumber, personIDNumber, rentDevices);
    }
}
