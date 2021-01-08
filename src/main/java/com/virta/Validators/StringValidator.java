/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virta.Validators;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author anna
 */
@Configuration
public class StringValidator {
    
    @Bean
    public static boolean validate(String message) {
        if (message==null||message.isEmpty()){
            return false;
        } else return true;
    }    
}