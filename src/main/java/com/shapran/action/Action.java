package com.shapran.action;

import com.shapran.service.UniversityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface Action {
    UniversityService service = UniversityService.getInstance();
    Logger logger = LoggerFactory.getLogger(Action.class);
    void execute();
}
