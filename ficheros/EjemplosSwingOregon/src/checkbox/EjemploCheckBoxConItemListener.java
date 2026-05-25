package checkbox;

import javax.swing.*;  
import java.awt.event.*;    

public class EjemploCheckBoxConItemListener {    
    EjemploCheckBoxConItemListener() {    
        JFrame frame = new JFrame("Ejemplo de JCheckBox con ItemListener");    
        final JLabel label = new JLabel();            
        label.setHorizontalAlignment(JLabel.CENTER);    
        label.setSize(400, 100);    

        JCheckBox checkBox1 = new JCheckBox("C++");    
        checkBox1.setBounds(150, 100, 80, 50);    

        JCheckBox checkBox2 = new JCheckBox("Java");    
        checkBox2.setBounds(150, 150, 80, 50);    

        frame.add(checkBox1);  
        frame.add(checkBox2);  
        frame.add(label);    

        checkBox1.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {                 
                label.setText("C++ Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));    
            }    
        });    

        checkBox2.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {                 
                label.setText("Java Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));    
            }    
        });    

        frame.setSize(400, 400);    
        frame.setLayout(null);    
        frame.setVisible(true);    
    }    

    public static void main(String[] args) {    
        new EjemploCheckBoxConItemListener();    
    }    
}