/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virta.virta;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author anna
 */
@Entity
@Table(name = "attendee")
@NamedQueries({
    @NamedQuery(name = "Attendee.findAll", query = "SELECT a FROM Attendee a"),
    @NamedQuery(name = "Attendee.findById", query = "SELECT a FROM Attendee a WHERE a.id = :id"),
    @NamedQuery(name = "Attendee.findByName", query = "SELECT a FROM Attendee a WHERE a.name = :name"),
    @NamedQuery(name = "Attendee.findBySurname", query = "SELECT a FROM Attendee a WHERE a.surname = :surname"),
    @NamedQuery(name = "Attendee.findByPhone", query = "SELECT a FROM Attendee a WHERE a.phone = :phone")})
public class Attendee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    
    @Size(max = 2147483647)
    @Column(name = "surname")
    private String surname;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "phone")
    private String phone;

    public Attendee() {
    }

    public Attendee(int id) {
        this.id = id;
    }

    public Attendee(int id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public Attendee(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    
    public Attendee(int id, String name, String surname, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.surname);
        hash = 89 * hash + Objects.hashCode(this.phone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Attendee other = (Attendee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Attendee id=" + id + ", " + "Name: " + name + ", Surname" + surname + ", Phone: " + phone;
    }
    
}
