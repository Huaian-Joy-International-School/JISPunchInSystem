/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.time.LocalTime;

/**
 *
 * @author huihu
 */
public class PunchInInfo {
    
    private String studentName;
    private LocalTime punchInTime;
    
    public PunchInInfo(String studentName, LocalTime punchInTime)
    {
        this.studentName = studentName;
        this.punchInTime = punchInTime;
    }
    
    public String getStudentName()
    {
        return this.studentName;
    }
    
    public LocalTime getPunchInTime()
    {
        return this.punchInTime;
    }            
}
