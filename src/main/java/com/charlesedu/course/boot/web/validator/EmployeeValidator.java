package com.charlesedu.course.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.charlesedu.course.boot.domain.Employee;

public class EmployeeValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        LocalDate admission = employee.getAdmissionDate();

        if (employee.getExitDate() != null) {
            if (employee.getExitDate().isBefore(admission)) {
                errors.rejectValue("exitDate", "AfterExitDate.employee.exitDate");
            }
        }
    }

}
