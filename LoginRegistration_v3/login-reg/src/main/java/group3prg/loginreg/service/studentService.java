package group3prg.loginreg.service;

import group3prg.loginreg.model.student;
import group3prg.loginreg.web.dto.studentRegistrationDto;

public interface studentService {
    student save(studentRegistrationDto registrationDto);
    
}
