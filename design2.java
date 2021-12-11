import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.*;  

public class design2{
    File file;
    design2(String msg) {  

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane ().setBackground(new Color(254, 223, 149));
    
    JLabel l1=new JLabel("-::CHOOSE FILE::-");  
    l1.setFont(new Font("Serif", Font.BOLD, 30));
    l1.setBounds(60,40, 10000,60);  
    f.add(l1);

    JTextArea area=new JTextArea();  
    area.setBounds(40,100, 260,25);  
    area.setFont(new Font("Serif", Font.PLAIN, 20));
    f.add(area);  

    JButton b=new JButton(new ImageIcon("C:\\Users\\asus\\Desktop\\jvprj\\search.png"));   
    b.setBounds(305,100,25,25);  
    b.setBorderPainted(false);
    b.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        file=fileChooser.getSelectedFile();
        fileChooser.setBounds(60,100, 10000,60);
        area.setText(file.toString());
      }  
      });
    f.add(b); 

    JLabel l2=new JLabel("-::ENTER KEY::-");  
    l2.setFont(new Font("Serif", Font.BOLD, 30));
    l2.setBounds(70,180, 10000,60);  
    f.add(l2);

    JTextArea area1=new JTextArea();  
    area1.setBounds(40,235, 260,25);  
    area1.setFont(new Font("Serif", Font.PLAIN, 20));
    f.add(area1);  

    JButton b1=new JButton(msg);   
    b1.setBounds(120,300,100,40);
    b1.setBorderPainted(false);
    b1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        //   int key=0;
        //   try {} catch(Exception err){JOptionPane.showMessageDialog(null, "Invalid key");}
        try
        {
            int key=Integer.parseInt(area1.getText());
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                data[i]=(byte)(b^key);
                i++;
            }
            
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
            f.setVisible(false);

        }
        catch(Exception er)
        {
            JOptionPane.showMessageDialog(null, "Invalid File or Key");
        }
      }
  });
  f.add(b1);

    




    

    f.setSize(375,400);  
    f.setLayout(null);  
    f.setResizable(false);
    f.setVisible(true);
}  }