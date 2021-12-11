import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;  

public class design{
  public static void main(String[] args) {  

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane ().setBackground(new Color(254, 223, 149));
    
    JButton b=new JButton(new ImageIcon("C:\\Users\\asus\\Desktop\\jvprj\\1.jpg"));   
    b.setBounds(80,150,200,200);  
    b.setBorderPainted(false);
    b.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        System.out.println("ghjk");
        new design2("ENCRYPT");
      }  
      });
    frame.add(b); 

    JButton b1=new JButton(new ImageIcon("C:\\Users\\asus\\Desktop\\jvprj\\2.jpg"));   
    b1.setBounds(320,150,200,200);
    b1.setBorderPainted(false);
    b1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
          //your actions
          new design2("DECRYPT");
      }
  });
    frame.add(b1);   

    JLabel l1=new JLabel("Encrypt/Decrypt");  
    l1.setFont(new Font("Serif", Font.ITALIC, 50));
    l1.setBounds(120,40, 10000,60);  
    frame.add(l1);

    frame.setSize(600,450);  
    frame.setLayout(null);  
    frame.setResizable(false);
    frame.setVisible(true);
}  }