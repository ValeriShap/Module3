package com.shapran.action;

import com.shapran.model.Group;
import com.shapran.util.UserInput;

import java.time.LocalDateTime;
import java.util.List;

public class FindGroupByName implements Action{
    @Override
    public void execute() {
        final String name = UserInput.getString();
        List<Group> groupList = service.getGroupByName(name);
        if (groupList.size() != 0) {
            groupList.forEach(group ->
                    System.out.println(group));
            logger.info("getGroupByName was created, time: " + LocalDateTime.now());
        } else {
            System.out.println("This group is not found");
            logger.warn("getGroupByName not found, time: " + LocalDateTime.now());
        }
    }
}
