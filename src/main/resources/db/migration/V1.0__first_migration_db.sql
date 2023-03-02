CREATE TABLE teachers (
    teacher_id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE groups (
    group_id VARCHAR(255) PRIMARY KEY NOT NULL,
    group_name VARCHAR(255) NOT NULL
);

CREATE TABLE subjects (
    subject_id VARCHAR(255) PRIMARY KEY NOT NULL,
    name_of_subject VARCHAR(255) NOT NULL
);

CREATE TABLE students (
    student_id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    date_of_admission TIMESTAMP NOT NULL,
    group_id VARCHAR(255),
    FOREIGN KEY (group_id) REFERENCES groups(group_id)
);
CREATE TABLE grades (
    grade_id VARCHAR(255) NOT NULL,
    subject_id VARCHAR(255) NOT NULL,
    mark INT NOT NULL,
    student_id VARCHAR(255) NOT NULL,
    PRIMARY KEY(student_id, subject_id),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

