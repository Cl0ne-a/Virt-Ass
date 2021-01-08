/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virta.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author anna
 */
@Configuration
public class PhoneValidator {
    
    private static final String phoneMatcherRegex= "(\\+*)\\d{12}";
    
    @Bean
    public static boolean validate(String phone) {
        boolean result = phone.matches(phoneMatcherRegex); 
            return phone.matches(phoneMatcherRegex);
        }
}
