package botones;

import java.awt.event.*;  
import javax.swing.*;    

public class BBotonConAccion {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("Ejemplo de JButton con ActionListener");  
        JTextField texto = new JTextField();  
        texto.setBounds(50, 50, 150, 20);  
        JButton boton = new JButton("Haz clic aqu�");  
        boton.setBounds(50, 100, 120, 30);  

        boton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                texto.setText("�Bienvenido a Java!");  
            }  
        });  

        frame.add(boton);  
        frame.add(texto); 
        //ancho alto
        frame.setSize(400, 400);  
        frame.setLayout(null);  
        frame.setVisible(true);  
    }  
}

