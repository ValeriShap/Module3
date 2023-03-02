package com.shapran.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "teachers")
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "teacher_id")
    private String id;
    private String name;
    private String surname;
    private int age;

    public Teacher(){
    }

    @Override
    public String toString() {
        return String.format("Teacher: (Id: %s, Name: %s, " +
                "Surname: %s, Age: %s )%n", id, name, surname, age);
    }
}
