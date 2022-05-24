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
public class ClassInfo {
    
    private String className;
    private LocalTime startTime;
    private LocalTime endTime;
    
    public ClassInfo(String className, LocalTime startTime, LocalTime endTime)
    {
        this.className  = className;
        this.startTime = startTime;
        this.endTime = endTime;        
    }
    
    public String getClassName()
    {
        return this.className;
    }
    
    public LocalTime getStartTime()
    {
        return this.startTime;
    }
    
    public LocalTime getEndTime()
    {
        return this.endTime;
    }
}
