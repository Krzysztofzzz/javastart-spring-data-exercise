package javastart.spring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String peselNumber;
    private String personIDNumber;
    @ManyToMany
    private List<Device> devices;

}
