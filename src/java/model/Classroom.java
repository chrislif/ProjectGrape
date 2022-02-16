/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jacks
 */
public class Classroom {
    private int classroomID;
    private Account teacherID;
    public ArrayList<Account> studentList;

    public int getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(int classroomID) {
        this.classroomID = classroomID;
    }

    public Account getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Account teacherID) {
        this.teacherID = teacherID;
    }  
}
