/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author huihu
 */
public class ResetListener implements ActionListener {
    
    private MainFrame frame;
    private ResetDialog dialog;
    private PunchInOperations operations;

    public ResetListener(MainFrame frame, ResetDialog dialog, PunchInOperations operations)
    {
        this.frame = frame;
        this.dialog = dialog;
        this.operations = operations;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd)
        {
            case "Submit":
            {
                String psw = this.dialog.getPassword();
                if(!this.operations.checkPassword(psw))
                {
                    this.frame.ShowMessageDialog("Password is wrong, please input correct password");
                }
                else if(!this.operations.CleanUp(psw))
                {
                    this.frame.ShowMessageDialog("Can not clean the punch in records due to some unexpected issue");
                }
                else
                {
                    this.frame.ShowMessageDialog("Reset succeed");
                    this.dialog.dispose();               
                }

                break;
            }
            case "Cancel":
            {
                this.dialog.dispose();
                break;
            }
            default:
            {
                System.out.println("Undefined Command");
            }
        }
    }
    
}
