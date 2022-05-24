/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PunchInProject;

/**
 *
 * @author huihu
 */
public class ChangePasswordInfo {
    
    private String oldPsw;
    private String newPsw1;
    private String newPsw2;
    
    public ChangePasswordInfo(char[] old, char[] new1, char[] new2)
    {
        this.oldPsw = this.arrayToString(old);
        this.newPsw1 = this.arrayToString(new1);
        this.newPsw2 = this.arrayToString(new2);
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
    
    public String getOldPsw()
    {
        return this.oldPsw;
    }
    
    public String getNewPsw1()
    {
        return this.newPsw1;
    }
    
    public String getNewPsw2()
    {
        return this.newPsw2;
    }
    
}
