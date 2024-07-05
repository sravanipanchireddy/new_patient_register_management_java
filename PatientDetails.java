import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
import java.util.*; 
public class PatientDetails
{ 
     public  void  patientInfo()
     {
          JFrame f= new JFrame( "Patient Registration Details Form"); 
	    JLabel l1, l2, l3, l4, l5,l6; 
          JTextField t1, t2, t3,t4,t5; 
          JComboBox<String> j1; 
          JButton b1,b2; 
	    l1 = new JLabel("patient name:"); 
          l1.setBounds(50, 50, 100, 30); 
          l2 = new JLabel("patient age:"); 
          l2.setBounds(50, 120, 120, 30); 
          l3 = new JLabel("blood group:"); 
          l3.setBounds(50, 190, 50, 30); 
          l4 = new JLabel("mobile no:"); 
          l4.setBounds(420, 190, 70, 30); 
          l5 = new JLabel("address:"); 
          l5.setBounds(420, 120, 70, 30); 
	    l6 = new JLabel("AadharNo:"); 
          l6.setBounds(420, 50, 70, 30); 
	    t1 = new JTextField(); 
          t1.setBounds(150, 50, 130, 30); 
          t2 = new JTextField(); 
          t2.setBounds(160, 120, 130, 30); 
          t3 = new JTextField(); 
          t3.setBounds(490,190, 130, 30); 
	    t4 = new JTextField(); 
          t4.setBounds(490, 120, 130, 30);
	    t5 = new JTextField(); 
          t5.setBounds(490, 50, 130, 30); 
	    String s1[] = { " ", "A+","B+","AB+","O+", "A-","B-","AB-","O-","Others" }; 
          j1 = new JComboBox<>(s1); 
	    j1.setBounds(120, 190, 100, 30); 
	    b1 = new JButton("Register");
          b1.setBounds(150, 300, 90, 30); 
          b2 = new JButton("close"); 
          b2.setBounds(500, 300, 70, 30); 
          b1.addActionListener(new ActionListener() 
          { 
             public void actionPerformed(ActionEvent e) 
             {  
                   String s1 = t1.getText(); 
                   String s2 = t2.getText(); 
                   String s3 = j1.getSelectedItem() + ""; 
                   String s4 = t3.getText(); 
                   String s5 = t4.getText();
			 String s6 = t5.getText(); 
                   int c=0;
                   if (e.getSource() == b1)
                   { 
                      try 
                      { 
                           
                           File fi=new File("Details.txt");
                           Scanner sc =new Scanner(fi);
                           while(sc.hasNextLine())
                           {
                             if((sc.nextLine()).equals(s6))
                             {
                                 c=1;
                                  
                                 break;
                             }
                           }
                           if(c==0)
                           {
                                if(s6.length()==12)
                                {

                                 
                                 FileWriter w= new FileWriter("Details.txt", true); 
                                 w.write(s1 + "\n"); 
                                 w.write(s2 + "\n"); 
                                 w.write(s3 + "\n"); 
                                 w.write(s4 + "\n"); 
                                 w.write(s5 + "\n");  
                                 w.write(s6 + "\n");
                                  w.close();
                                 JOptionPane.showMessageDialog(f,"Successfully registered"+ " The Details");
                               
                                }
                                else
                                {
                                   JOptionPane.showMessageDialog(f,"invalid Aadhar");
                                }   
                           }
                           else
                           {
                                  JOptionPane.showMessageDialog(null,"Already registered"+ " The Details");
                           }
                           //sc.close();
                        }
                        catch (Exception ae)
                        { 
                           System.out.println(ae); 
                        } 
                      }
                }
                  
            });
            b2.addActionListener(new ActionListener()
            { 
               public void actionPerformed(ActionEvent e) 
               { 
                    f.dispose(); 
               } 
            }); 
            f.addWindowListener(new WindowAdapter()
            { 
                 public void windowClosing(WindowEvent e) 
                 { 
                     System.exit(0); 
                 } 
            }); 
            f.add(l1); 
            f.add(t1); 
            f.add(l2); 
            f.add(t2); 
            f.add(l3); 
            f.add(j1); 
            f.add(l4);
            f.add(t3); 
            f.add(l5); 
            f.add(t4); 
	  f.add(l6); 
            f.add(t5);
            f.add(b1);
            f.add(b2);  
            f.setLayout(null); 
            f.setSize(700, 500); 
            f.getContentPane().setBackground(Color.WHITE);
            f.setVisible(true); 
     } 
     /*public static void main(String args[]) 
     { 
             
     }
     */ 
}