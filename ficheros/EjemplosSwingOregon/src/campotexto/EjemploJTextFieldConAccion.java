package campotexto;

import javax.swing.*;  
import java.awt.event.*;  

public class EjemploJTextFieldConAccion implements ActionListener {  
    JTextField tf1, tf2, tf3;  
    JButton botonSuma, botonResta;  
    JLabel l1;
    EjemploJTextFieldConAccion() {  
        JFrame frame = new JFrame("Ejemplo JTextField con ActionListener");  
      
        tf1 = new JTextField();   
        tf1.setBounds(50, 50, 150, 20);  

        tf2 = new JTextField();  
        tf2.setBounds(50, 100, 150, 20);  

        tf3 = new JTextField();  
        tf3.setBounds(50, 150, 150, 20);  
        tf3.setEditable(false);  // Campo no editable 
        
        l1= new JLabel();  
        l1.setBounds(250, 250, 150, 30);  
        
        botonSuma = new JButton("+");  
        botonSuma.setBounds(50, 200, 50, 50);  
        botonResta = new JButton("-");  
        botonResta.setBounds(120, 200, 50, 50);  

        botonSuma.addActionListener(this);  
        botonResta.addActionListener(this);  

        frame.add(tf1);  
       
        frame.add(tf2);  
        frame.add(tf3);  
        frame.add(botonSuma);  
        frame.add(botonResta);  
        frame.add(l1);  
        
        frame.setSize(300, 300);  
        frame.setLayout(null);  
        frame.setVisible(true);  
    }  

    public void actionPerformed(ActionEvent e) {  
        String s1 = tf1.getText();  
        String s2 = tf2.getText();
        l1.setText("");
        int resultado = 0; 
        int num1 = 0, num2 = 0;
     
        try {
        num1 = Integer.parseInt(s1);  
        num2 = Integer.parseInt(s2);  
        
        }catch(NumberFormatException ex) {
        	l1.setText("introduce un numero valido");  
        	num1=num2=0;
        	
        }
        
        if (e.getSource() == botonSuma) {  
            resultado = num1 + num2;  
        } else if (e.getSource() == botonResta) {  
            resultado = num1 - num2;  
        }  

        tf3.setText(String.valueOf(resultado));  
    }  

    public static void main(String[] args) {  
        new EjemploJTextFieldConAccion();  
    }  
}
