/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;

/**
 *
 * @author huihu
 */
public class PasswordListener implements ActionListener {
    
    private MainFrame frame;
    private PasswordDialog dialog;
    private PunchInOperations operations;

    public PasswordListener(MainFrame frame, PasswordDialog dialog, PunchInOperations operations)
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
                ChangePasswordInfo psws = this.dialog.getPasswords();
                
                if(!psws.getNewPsw1().equals(psws.getNewPsw2()))
                {
                    this.frame.ShowMessageDialog("New passwords not same");
                }
                else if(!this.operations.checkPassword(psws.getOldPsw()))
                {
                    this.frame.ShowMessageDialog("Old password not match");
                }
                else if(!this.operations.changePassword(psws.getOldPsw(), psws.getNewPsw1()))
                {
                    this.frame.ShowMessageDialog("Password not changed due to some unexpected issue");
                }
                else
                {
                    this.frame.ShowMessageDialog("Password updated");
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
