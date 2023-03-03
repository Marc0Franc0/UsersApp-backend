package com.app.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="contacts")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full name",length = 100)
    private String full_name;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "cell phone",length = 50)
    private String cell_phone;

    @Column(name ="email" ,length = 200)
    private String email;
}
