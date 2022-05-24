/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.time.LocalTime;

/**
 *
 * @author huihu·
 */
public class PunchInProject {

    /**
     * @param args the command line arguments
    **/
    public static void main(String[] args){

        String className = "AP Physics";
        LocalTime time = LocalTime.of(7, 40, 0);
        LocalTime endTime = LocalTime.of(9, 10, 0);
        ClassInfo classInfo = new ClassInfo(className, time, endTime);
        PunchInOperations operations = new PunchInOperations(Students.all, classInfo);
        
        MainFrame frame = new MainFrame(operations);
    }
    
}
