/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author huihu
 */
public class TeacherActionListener implements ActionListener {
    
    private PunchInOperations operation;
    private MainFrame frame;
    
    public TeacherActionListener(MainFrame frame, PunchInOperations operation)
    {
        this.frame = frame;
        this.operation = operation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd)
        {
            case "Change Password":
            {
                PasswordDialog dlg = new PasswordDialog(this.frame, this.operation); 
                break;
            }
            case "Reset":
            {
                ResetDialog dlg = new ResetDialog(this.frame, this.operation); 
                break;
            }
            case "Query":
            {
                ArrayList<String> absentList = this.operation.getAbsentStudents();
                ArrayList<String> lateList = this.operation.getLateStudents();
                String abs = absentList.size() == 0 ? "None": absentList.toString();
                String ls = lateList.size() == 0 ? "None" : lateList.toString();
                this.frame.ShowMessageDialog("Absence：" + abs + "\nLate：" + ls);
                break;
            }
            default:
            {
                System.out.println("Undefined Command");
            }
        }
    }    
}
