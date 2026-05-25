package basicos;
import javax.swing.*;  

public class BEjemploSwingConstructor {  
    JFrame frame;  

    BEjemploSwingConstructor() {  
        frame = new JFrame(); // Crear un JFrame
        JButton boton = new JButton("Haz clic"); // Crear un botón
        boton.setBounds(130, 100, 100, 40);  

        // Añadir el botón al marco
        frame.add(boton);  

        // Configuración del JFrame
        frame.setSize(400, 500);  
        frame.setLayout(null);  
        frame.setVisible(true);  
    }  

    public static void main(String[] args) {  
        new BEjemploSwingConstructor();  
    }  
}