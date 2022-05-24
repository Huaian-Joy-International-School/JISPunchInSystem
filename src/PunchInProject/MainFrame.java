/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author huihu
 */
public class MainFrame extends JFrame {
    
    private PunchInOperations operations;
    
    public MainFrame(PunchInOperations operations)
    {
        this.operations = operations;
        this.Init();
    }
    
    private void Init()
    {
        Container pane = this.getContentPane();
        pane.add(this.getStudentPanel(), BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(this.getTeacherPanel(), BorderLayout.SOUTH);
        
        this.setPreferredSize(new Dimension(800, 600));
        this.setTitle("Punch In System");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private JPanel getStudentPanel()
    {
        final JPanel stuPanel = new JPanel();
        stuPanel.setLayout(new GridLayout((int)Math.ceil(Students.all.length / 4.0) ,4));
        for(int i = 0; i< Students.all.length; i++)
        {
            JButton btn = new JButton(Students.all[i]);            
            btn.setPreferredSize(new Dimension(200, 50));
            ActionListener listener= new PunchInActionListener(this, this.operations);
            btn.addActionListener(listener);
            stuPanel.add(btn);
        }
        return stuPanel;        
    }
    
    private JPanel getTeacherPanel()
    {
        final JPanel teaPanel = new JPanel();
        teaPanel.setLayout(new GridLayout(1,3));
        TeacherActionListener listener = new TeacherActionListener(this, this.operations);
        
        JButton btnChange = new JButton("Change Password");
        btnChange.setPreferredSize(new Dimension(200, 50));
        btnChange.addActionListener(listener);
        teaPanel.add(btnChange);
        
        JButton btnReset = new JButton("Reset");
        btnReset.setPreferredSize(new Dimension(200, 50));
        btnReset.addActionListener(listener);
        teaPanel.add(btnReset);
        
        JButton btnQuery = new JButton("Query");
        btnQuery.setPreferredSize(new Dimension(200, 50));
        btnQuery.addActionListener(listener);
        teaPanel.add(btnQuery);
        
        return teaPanel; 
    }
    
    public void ShowMessageDialog(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);        
    }
    
    public String ShowInputDialog(String msg)
    {
        return JOptionPane.showInputDialog(msg);
    }
}
