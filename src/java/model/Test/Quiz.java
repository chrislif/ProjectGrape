/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Test;

import model.Assessment;

/**
 *
 * @author chris
 */
public class Quiz extends Assessment{
    private Boolean isRandomized;

    public Boolean getIsRandomized() {
        return isRandomized;
    }

    public void setIsRandomized(Boolean isRandomized) {
        this.isRandomized = isRandomized;
    }
}
