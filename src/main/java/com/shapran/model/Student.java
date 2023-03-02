package com.shapran.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "students")
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "student_id")
    private String id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "date_of_admission")
    private LocalDateTime dateOfAdmission;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @OneToMany(mappedBy = "student",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Grade> grades;
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

    public Student(){
    }

    public Student(String id,String name, String surname, int age, LocalDateTime dateOfAdmission,
                   Group group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateOfAdmission = dateOfAdmission;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", dateOfAdmission=" + timeFormatter.format(dateOfAdmission) +
                ", group=" + group +
                '}';
    }

    public static class StudentBuilder{
        private String id;
        private String name;
        private String surname;
        private int age;
        private LocalDateTime dateOfAdmission;
        private Group group;

        public StudentBuilder withId(){
            this.id = UUID.randomUUID().toString();
            return this;
        }
        public StudentBuilder withName(String name){
            this.name = name;
            return this;
        }
        public StudentBuilder withSurname(String surname){
            this.surname = surname;
            return this;
        }
        public StudentBuilder withAge(int age){
            this.age = age;
            return this;
        }
        public StudentBuilder withDateOfAdmission(LocalDateTime dateOfAdmission){
            this.dateOfAdmission = dateOfAdmission;
            return this;
        }
        public StudentBuilder withGroup(Group group){
            this.group = group;
            return this;
        }
        public Student build(){
            return new Student(id, name, surname, age, dateOfAdmission, group);
        }

    }
}
