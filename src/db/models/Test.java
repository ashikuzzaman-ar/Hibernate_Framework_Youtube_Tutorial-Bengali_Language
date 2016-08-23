/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.models;

import java.io.Serializable;

/**
 *
 * @author ashik
 */
public class Test implements Serializable{
    
    private Double age ;
    private Boolean isMale ;

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }
}
