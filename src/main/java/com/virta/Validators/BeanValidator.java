/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virta.Validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;

/**
 *
 * @author anna
 * @param <T>
 */
public abstract class BeanValidator<T> {
    
    protected Validator validator;
    protected Set<ConstraintViolation<T>> constraintViolations;
    
    protected BeanValidator(){
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    public final boolean validate(T t){
        constraintViolations = validator.validate(t);
        return constraintViolations.isEmpty();
    }
    
    public final List<String>getConstraintVIolations(){
        List<String> violations = new ArrayList<String>();
        for (ConstraintViolation<T> violation: constraintViolations){
            violations.add(violation.getMessage());
        }
        return violations;
    }  
    
}
