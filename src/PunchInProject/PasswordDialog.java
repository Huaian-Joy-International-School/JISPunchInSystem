/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

/**
 *
 * @author huihu
 */
public class PasswordDialog extends JDialog {
    
    private PunchInOperations operations;
    private MainFrame frame;
    private JPasswordField txtOldPsw;
    private JPasswordField txtNewPsw1;
    private JPasswordField txtNewPsw2;
    
    public PasswordDialog(MainFrame frame, PunchInOperations operations)
    {
        super(frame, "Change Password", true);
        
        this.frame = frame;
        this.operations = operations;
        this.txtOldPsw = new JPasswordField();
        this.txtNewPsw1 = new JPasswordField();
        this.txtNewPsw2 = new JPasswordField();
        this.Init();
    }
    
    public ChangePasswordInfo getPasswords()
    {
        ArrayList<char[]> psws = new ArrayList<char[]>(3);
        psws.add(this.txtOldPsw.getPassword());
        psws.add(this.txtNewPsw1.getPassword());
        psws.add(this.txtNewPsw2.getPassword());
        return new ChangePasswordInfo(this.txtOldPsw.getPassword(), this.txtNewPsw1.getPassword(), this.txtNewPsw2.getPassword());
    }
    
    private void Init()
    {
        Container pane = this.getContentPane();       
        pane.add(this.getTextBoxesPanel(), BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(this.getButtonsPanel(), BorderLayout.SOUTH);       
        
        this.setPreferredSize(new Dimension(400, 250));
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);        
        this.setVisible(true);
    }
    
    private JPanel getTextBoxesPanel()
    {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 150));
        panel.add(this.getPassWordPanel("Old Password", this.txtOldPsw), BorderLayout.NORTH);
        panel.add(this.getPassWordPanel("New Password", this.txtNewPsw1), BorderLayout.CENTER);
        panel.add(this.getPassWordPanel("New Password", this.txtNewPsw2), BorderLayout.SOUTH);
        return panel;
    }
    
    private JPanel getPassWordPanel(String label, JPasswordField txtPsw)
    {
        JPanel panel = new JPanel();
        
        JLabel lblPsw = new JLabel(label);
        lblPsw.setPreferredSize(new Dimension(100, 30));
        panel.add(lblPsw);        
        
        txtPsw.setPreferredSize(new Dimension(200, 30));
        panel.add(txtPsw);
        
        return panel;
    }
    
     private JPanel getButtonsPanel()
    {
        JPanel panel = new JPanel();
        PasswordListener listener = new PasswordListener(this.frame,this, this.operations);
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setPreferredSize(new Dimension(100, 30));
        btnSubmit.addActionListener(listener);
        panel.add(btnSubmit);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(100, 30));
        btnCancel.addActionListener(listener);
        panel.add(btnCancel);
        
        return panel;
    } 
}
