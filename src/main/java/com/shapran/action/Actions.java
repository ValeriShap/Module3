package com.shapran.action;

import lombok.Getter;

@Getter
public enum Actions {
    FIND_GROUP("Get group by name", new FindGroupByName()),
    FIND_COUNT_STUDENT("Get count of student in every group", new FindCountStudent()),
    FIND_AVERAGE_GRADE("Get average grade of group", new FindAverageGrade()),
    FIND_TEACHER_BY_NAME("Get teacher by name or surname", new FindTeacherByName()),
    FIND_SUBJECT_WITH_AVERAGE_GRADE("Get subject with best and worst grade", new FindSubjectWithAverage()),
    FIND_STUDENT_WITH_GRADE("Get student with average grade over your number", new FindStudentWithGrade()),
    CREATE_STUDENT("Create random student", new CreateStudent()),
    EXIT("Finish the program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }
    public void execute(){
        action.execute();
    }
}
