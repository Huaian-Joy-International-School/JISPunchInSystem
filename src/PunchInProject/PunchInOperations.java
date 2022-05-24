/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author huihu
 */
public class PunchInOperations {
    
    public static String secret = "jygj12345";
    private String[] allStudents;
    private ArrayList<PunchInInfo> punches;
    private ClassInfo classInfo;
    private String passWord;
    
    public PunchInOperations(String[] allStudents, ClassInfo classInfo)
    {
        this.allStudents = allStudents;
        this.classInfo = classInfo;
        this.passWord = secret;  
        this.punches = new ArrayList<PunchInInfo>();              
    }
    
    public boolean punch(String name, LocalTime time)
    {
        if(!this.canPunchIn()) 
            return false;
        
        this.punches.add(new PunchInInfo(name, time));
        return true;       
    }
    
    /* can punch in 10 miniutes before or after class start */
    private boolean canPunchIn()
    {
        LocalTime classStart = this.classInfo.getStartTime();
        LocalTime now = LocalTime.now();
        return Math.abs(classStart.toSecondOfDay() - now.toSecondOfDay()) <= 60 * 10;
    }
    
    public ArrayList<String> getLateStudents()
    {
        ArrayList<String> late = new ArrayList<String>();
        for(int i = 0; i<this.punches.size(); i++)
        {
            if(this.punches.get(i).getPunchInTime().toSecondOfDay()> this.classInfo.getStartTime().toSecondOfDay())
                late.add(this.punches.get(i).getStudentName());
        }
        return late;
    }
    
    public ArrayList<String> getAbsentStudents()
    {
        ArrayList<String> absent = new ArrayList<String>();
        for(int i = 0; i< this.allStudents.length; i++)
        {
            boolean found = false;
            for(int j = 0; j< this.punches.size(); j++)
            {
                if(this.allStudents[i].equals(this.punches.get(i).getStudentName()))
                {
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                absent.add(this.allStudents[i]);
            }
        }
        return absent;
    }
    
    public boolean checkPassword(String psw)
    {
        if(psw == null)
            return false;
        
        if(this.passWord.isBlank() || this.passWord.isEmpty())
        {
            return psw.equals(secret);
        }
        else
        {
            return psw.equals(this.passWord);
        }        
    }
    
    public boolean changePassword(String oldPass, String newPass)
    {
        if(!checkPassword(oldPass))
            return false;
        this.passWord = newPass;
        return true;
    }
    
    public boolean CleanUp(String password)
    {
        if(!checkPassword(password))
            return false;
        
        this.punches.clear();
        return true;
    }    
}
