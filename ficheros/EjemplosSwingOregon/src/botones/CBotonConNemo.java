package botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;    

public class CBotonConNemo {    
    CBotonConNemo() {    
        JFrame frame = new JFrame("Ejemplo de JButton con Mnemónico");    
        JButton boton = new JButton("Guardar (Alt+S)");    
        JLabel texto = new JLabel();  
        texto.setBounds(50, 50, 150, 20);  
        boton.setBounds(100, 100, 150, 40);    
        boton.setMnemonic('S');  // Establece 'Alt+S' como mnemónico
        boton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                texto.setText("¡Guardado!");  
            }  
        });  

        frame.add(texto);
        frame.add(boton);    
        frame.setSize(300, 200);    
        frame.setLayout(null);    
        frame.setVisible(true);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }    

    public static void main(String[] args) {    
        new CBotonConNemo();    
    }    
}