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
public class ResetDialog extends JDialog{
    
    private PunchInOperations operations;
    private MainFrame frame;
    private JPasswordField txtPsw;
    
    public ResetDialog(MainFrame frame, PunchInOperations operations)
    {
        super(frame, "Reset Punch In Information", true);
        
        this.frame = frame;
        this.operations = operations;
        this.txtPsw = new JPasswordField();

        this.Init();
    }
    
    public String getPassword()
    {
        return this.arrayToString(this.txtPsw.getPassword());
    }
    
    private String arrayToString(char[] chars)
    {
        String s = "";
        
        if(chars!=null)
        {
            for(char c : chars)
            {
                s+= c;
            }
        }
        return s;
    }
    
    private void Init()
    {
        Container pane = this.getContentPane();       
        pane.add(this.getTextBoxesPanel(), BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(this.getButtonsPanel(), BorderLayout.SOUTH);       
        
        this.setPreferredSize(new Dimension(400, 150));
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);        
        this.setVisible(true);
    }
    
    private JPanel getTextBoxesPanel()
    {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 60));
        panel.add(this.getPassWordPanel("Password", this.txtPsw));
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
        ResetListener listener = new ResetListener(this.frame, this, this.operations);
    
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
