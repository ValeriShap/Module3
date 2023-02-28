package com.shapran.service;

import com.shapran.model.Group;
import com.shapran.model.Student;
import com.shapran.model.Teacher;
import com.shapran.repository.GroupRepository;
import com.shapran.repository.StudentRepository;
import com.shapran.repository.SubjectRepository;
import com.shapran.repository.TeacherRepository;
import com.shapran.util.RandomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class UniversityService {
    private static UniversityService instance;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    private static Logger logger = LoggerFactory.getLogger(UniversityService.class);

    public UniversityService() {
        groupRepository = GroupRepository.getInstance();
        studentRepository = StudentRepository.getInstance();
        subjectRepository = SubjectRepository.getInstance();
        teacherRepository = TeacherRepository.getInstance();
    }

    public static UniversityService getInstance() {
        if (instance == null) {
            instance = new UniversityService();
        }
        return instance;
    }

    public Student createStudent() {
        final Student student = new Student.StudentBuilder()
                .withId()
                .withName(RandomGenerator.randomString())
                .withSurname(RandomGenerator.randomString())
                .withAge(RandomGenerator.randomAge())
                .withDateOfAdmission(LocalDateTime.now())
                .withGroup(randomGroupe())
                .build();
        return student;
    }

    private Group randomGroupe() {
        return groupRepository.getAll().stream().findAny().get();
    }

    public List<Group> getGroupByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Wrong name");
        } else {
            return groupRepository.getGroupByName(name);
        }
    }

    public void printAverageGrade() {
        Map<String, Double> gradeMap = groupRepository.getAverageGrade();
        for (Map.Entry<String, Double> entry : gradeMap.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + ", Average grade: " + entry.getValue());
        }
    }

    public void getSubjectWithBestOrWorstGrade() {
        subjectRepository.getSubjectWithBestOrWorstGrade();
    }

    public void printNumberOfStudentInGroup() {
        Map<String, Long> mapGroup = studentRepository.numberOfStudentInGroup();
        for (Map.Entry<String, Long> entry : mapGroup.entrySet()) {
            System.out.println("Count of students in group: " + entry.getKey() + "....." + entry.getValue());
        }
    }

    public void printStudentWithAverageGrade(double grade) {
        Map<Student, Number> mapStudent = studentRepository.getStudentWithAverageGrade(grade);
        if (mapStudent.isEmpty()) {
            System.out.println("No students found with average grade of " + grade);
            return;
        }
        System.out.println("Students with average grade of " + grade + ":");
        for (Map.Entry<Student, Number> entry : mapStudent.entrySet()) {
            System.out.println(entry.getKey().getName() + " (" + entry.getKey().getId() + "): " + entry.getValue());
        }
    }

    public void printTeacherByName(String name) {
        List<Teacher> teachers = teacherRepository.getTeacherByName(name);
        if (teachers.isEmpty()) {
            System.out.println("No teachers with name " + name);
        } else {
            System.out.println("Teachers with name " + name + ":");
            for (Teacher teacher : teachers) {
                System.out.println(teacher.getName() + " " + teacher.getSurname() + " " + teacher.getId());
            }
        }
    }
}
