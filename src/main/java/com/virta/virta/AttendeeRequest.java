/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virta.virta;

import com.virta.Validators.PhoneValidator;
import com.virta.Validators.PhoneValidator;
import com.virta.Validators.StringValidator;
import com.virta.Validators.StringValidator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author anna
 */
@Configuration
@WebServlet(name = "AttendeeRequest", urlPatterns = "/processAttendee")
public class AttendeeRequest extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        RequestAttendee customer = RequestAttendee.fromRequestParameters(req);
        customer.setAsRequestAttributes(req);
        List<String>violations = customer.validate();
        
        if(!violations.isEmpty()){
            req.setAttribute("violations", violations);
            
        }
        
        String url = determineUrl(violations);
        forwardResponse(url, req, resp);
    }
    private String determineUrl(List<String>violations){
        if(!violations.isEmpty()){
            return "/"; // add error page here
        }
        else {
            return "/customerinfo.jsp";
        }
    }
    
    private void forwardResponse(String url, HttpServletRequest request, HttpServletResponse response){
        try{
            request.getRequestDispatcher(url).forward(request, response);
        } catch(ServletException | IOException sEx){
            sEx.printStackTrace();
        }
    }

    public void getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Configuration
    private static class RequestAttendee{
        private final String name;
        private final String surname;
        private final String phone;
        
        
        public RequestAttendee(String name, String surname, String phone) {
            this.name = name;
            this.surname = surname;
            this.phone = phone;
        }
        
        public static RequestAttendee fromRequestParameters(HttpServletRequest request){
            return new RequestAttendee(
                    request.getParameter("name"),
                    request.getParameter("surname"),
                    request.getParameter("phone"));
        }
        public void setAsRequestAttributes(HttpServletRequest request){
            request.setAttribute("name", name);
            request.setAttribute("surname", surname);
            request.setAttribute("phone", phone);
        }
        
        @Bean(name = "violations")
        public List <String> validate(){
            List<String> violations = new ArrayList<>();
            if((StringValidator.validate(name))==false){
                violations.add("Enter name");
            }
            if(StringValidator.validate(surname)==false){
                violations.add("Enter surname");
            }
            if(PhoneValidator.validate(phone)==false){
                violations.add("Invalid phone format");
            }
            return violations;
        }
        
    }
}
