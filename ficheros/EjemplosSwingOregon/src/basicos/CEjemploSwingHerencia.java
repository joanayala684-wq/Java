package basicos;

import javax.swing.*;  

public class CEjemploSwingHerencia extends JFrame {  
    CEjemploSwingHerencia() {  
        JButton boton = new JButton("Haz clic");  
        boton.setBounds(130, 100, 100, 40);  

        // Añadir el botón al marco
        add(boton);  

        // Configuración del JFrame
        setSize(400, 500);  
        setLayout(null);  
        setVisible(true);  
    }  

    public static void main(String[] args) {  
        new CEjemploSwingHerencia();  
    }  
}
