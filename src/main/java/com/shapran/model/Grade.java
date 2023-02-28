package com.shapran.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "grades")
@ToString
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "grade_id")
    private String id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private int mark;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Grade(){
    }
}
