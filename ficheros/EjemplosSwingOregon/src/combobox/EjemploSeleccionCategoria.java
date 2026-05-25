package combobox;

import javax.swing.*;    
import java.awt.event.*;    

public class EjemploSeleccionCategoria {    
    JFrame frame;    

    EjemploSeleccionCategoria() {    
        frame = new JFrame("Selección de Categoría");   

        final JLabel etiqueta = new JLabel();          
        etiqueta.setHorizontalAlignment(JLabel.CENTER);  
        etiqueta.setSize(400, 100);  

        String[] categorias = {"Electrónica", "Ropa", "Alimentos", "Libros", "Muebles"};        
        final JComboBox<String> comboBox = new JComboBox<>(categorias);    
        comboBox.setBounds(50, 100, 150, 30);    

        JButton botonMostrar = new JButton("Seleccionar");  
        botonMostrar.setBounds(220, 100, 100, 30);  

        frame.add(comboBox);  
        frame.add(etiqueta);  
        frame.add(botonMostrar);    

        frame.setLayout(null);    
        frame.setSize(400, 300);    
        frame.setVisible(true);       

        botonMostrar.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
                String categoriaSeleccionada = "Categoría seleccionada: " + comboBox.getSelectedItem();  
                etiqueta.setText(categoriaSeleccionada);  
            }  
        });           
    }    

    public static void main(String[] args) {    
        new EjemploSeleccionCategoria();         
    }    
}