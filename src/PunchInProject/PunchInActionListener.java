/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

/**
 *
 * @author huihu
 */
public class PunchInActionListener implements ActionListener {

    private PunchInOperations operations;
    private MainFrame frame;
    
    public PunchInActionListener(MainFrame frame, PunchInOperations operations)
    {
        this.operations = operations;
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String student = e.getActionCommand();
        LocalTime time = LocalTime.now();
        if(this.operations.punch(student, time))
        {
            this.frame.ShowMessageDialog(student + " punch in succeed.");
        }
        else
        {
            this.frame.ShowMessageDialog(student + " punch in failed.");
        }
    }
    
}
