import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class Main {
    final static JFrame frame = new JFrame();
    final static PageTwo two = new PageTwo();
    final static Register begin = new Register();
    final static javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
    static User user;
    public static void main(String[] args) {
        user = null;
        try {   
            FileInputStream file = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            user = (User)in.readObject();
            in.close();
            file.close();
        } 
        catch(IOException ex) {  
            begin.setVisible(true);
            while(!Register.verified) {System.out.print(""); }
		    try {
			    FileOutputStream file = new FileOutputStream("data.ser");
			    ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(user);
                out.close();
			    file.close(); }
		    catch (IOException ep){}
        }
        catch(ClassNotFoundException eee) {
            begin.setVisible(true);
            while(!Register.verified) {}
		    try {
			    FileOutputStream file = new FileOutputStream("data.ser");
			    ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(user);
                out.close();
			    file.close(); }
		    catch (IOException ep) {}
        }
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu2 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu3 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("Home");
        jMenuBar1.add(jMenu1);
        jMenu1.setBackground(Color.white);
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.getContentPane().removeAll();
                frame.setPreferredSize(new Dimension(1180,710));
                frame.setJMenuBar(jMenuBar1);
                frame.add(new PageOne(user));
                frame.revalidate();
                frame.repaint();
                frame.pack();
            }
        });

        jMenu2.setText("Tasks");
        jMenuBar1.add(jMenu2);
        jMenu2.setBackground(Color.white);
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.getContentPane().removeAll();
                frame.setPreferredSize(new Dimension(1190,710));
                frame.setJMenuBar(jMenuBar1);
                frame.add(two);
                frame.revalidate();
                frame.repaint();
                frame.pack();
            }
        });

        jMenu3.setText("Close");
        jMenuBar1.add(jMenu3);
        jMenu3.setBackground(Color.white);

        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              try {
			          FileOutputStream file = new FileOutputStream("data.ser");
			          ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(user);
                out.close();
			          file.close(); }
		          catch (IOException ep) {}
              System.exit(0);
            }
        });

        jMenu4.setText("Terminate");
        jMenuBar1.add(jMenu4);
        jMenu4.setBackground(Color.white);
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to terminate?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    return;
                }
                Path path = FileSystems.getDefault().getPath("data.ser");
                try { Files.deleteIfExists(path); } 
                catch (IOException x) { 
                    JOptionPane.showMessageDialog(null, "Could not terminate. Please retry.");
                    return;
                }
                path = FileSystems.getDefault().getPath("Planned_Events.txt");
                try { Files.deleteIfExists(path); } 
                catch (IOException x) { 
                    JOptionPane.showMessageDialog(null, "Could not terminate. Please retry.");
                    return;
                }
                System.exit(0);
            }
        }); 

        frame.setJMenuBar(jMenuBar1);
        frame.setSize(1180,710);
        frame.add(new PageOne(user));
        frame.setVisible(true);

    }
}
