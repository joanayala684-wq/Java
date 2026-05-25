package etiquetas;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class BEtiquetaConAccion extends JFrame implements ActionListener {  
    JTextField campoTexto; 
    JLabel etiquetaDato;
    JLabel etiquetaResultado;  
    JButton botonBuscarIP;  

    BEtiquetaConAccion() {  
    	
    	etiquetaDato = new JLabel("Introduce una url:");
    	etiquetaDato.setBounds(50 , 5 , 100 , 20);
        campoTexto = new JTextField();  
        campoTexto.setBounds(50, 50, 150, 20);  

        etiquetaResultado = new JLabel();  
        etiquetaResultado.setBounds(50, 100, 300, 20);  

        botonBuscarIP = new JButton("Buscar IP");  
        botonBuscarIP.setBounds(50, 150, 120, 30);  
        botonBuscarIP.addActionListener(this);  

        add(etiquetaDato);
        add(campoTexto);  
        add(etiquetaResultado);  
        add(botonBuscarIP);  

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setSize(400, 300);  
        setLayout(null);  
        setVisible(true);  
    }  

    public void actionPerformed(ActionEvent e) {  
        try {  
            String host = campoTexto.getText();  
            String ip = java.net.InetAddress.getByName(host).getHostAddress();  
            etiquetaResultado.setText("La IP de " + host + " es: " + ip);  
        } catch (Exception ex) {  
            etiquetaResultado.setText("Error: " + ex.getMessage());  
        }  
    }  

    public static void main(String[] args) {  
        new BEtiquetaConAccion();  
    }  
}
