/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author dell-pc
 */
public class Map {
    private Scanner m;
    private int coloums=30;
    private int rows=30;
    private char MAP[][]=new char[coloums][rows];
    public String Map[]=new String[31];
    private Image grass,wall,finish,start,tree,Armour,clock,bicon;
    public Map()
    {
        ImageIcon img=new ImageIcon("Newgrass2.png");
        grass=img.getImage();
        img=new ImageIcon("stonewall.jpg");
        wall=img.getImage();
        img =new ImageIcon("FinishLine.jpg");
        finish=img.getImage();
        img=new ImageIcon("start.jpg");
        start=img.getImage();
         img=new ImageIcon("Greenwall.jpg");
        tree=img.getImage();
         img=new ImageIcon("Aon.png");
        Armour=img.getImage();
        img=new ImageIcon("tgif.gif");
       clock=img.getImage();
        img=new ImageIcon("B2.png");
       bicon=img.getImage();
        openFile();
        readFile();
        closeFile();
       
    }
    public Image getGrass()
    {
        return grass;
    }
    public Image getWall()
    {
        return wall;
    }
     public Image getgrassWall()
    {
        return tree;
    }
      public Image getArmour()
    {
        return Armour;
    }
      
       public Image getclock()
    {
        return clock;
    }
          public Image getbicon()
    {
        return bicon;
    }
    
    public Image getFinishLine(){
        return finish;
    }
     public Image getStartLine(){
        return start;
    }
    public String getMap(int x,int y)
    {
     String index=Map[y].substring(x,x+1);
     return index;
    }
    public void set(int x,int y){
        char f[]=Map[y].toCharArray();
        f[x]='g';
       Map[y]=String.valueOf(f);
    }
    
    public void setflag(int x,int y){
        char f[]=Map[y].toCharArray();
        f[x]='Z';
       Map[y]=String.valueOf(f);
    }
    
   
    
   
    
    
    public void openFile()
    {
        try{
        m=new Scanner(new File("Map.txt"));
                }catch(Exception e)
                {
                    System.out.println("Error Loading Map");
                }
    }
    public void readFile()
    {
        while(m.hasNext())
        {
            for (int i=0;i<31;i++){
                Map[i]=m.next();
            }
        }
    }
   
    public void closeFile()
    {
        m.close();
    }
    
 
} 
