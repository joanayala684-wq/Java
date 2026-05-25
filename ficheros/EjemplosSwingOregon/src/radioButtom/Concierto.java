package Concierto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {    
    JFrame frame;    
    JTextField tfEntradas, tfCodigo;  
    JButton botonCalcular;  
    JLabel lblCiudad, lblEntradas, lblTipo, lblCodigo, lblResultado;
    JComboBox<String> comboBoxCiudades;
    JRadioButton r1, r2, r3;
    ButtonGroup grupoTipo;
    JCheckBox chkPulsera;

    public main() {    
        frame = new JFrame("Venta de Entradas de Concierto");    
        frame.setSize(450, 500);  
        frame.setLayout(null);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Selección de Ciudad
        lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setBounds(30, 30, 100, 30);
        frame.add(lblCiudad);

        String[] ciudades = {"Madrid", "Santander", "Bilbao"}; // Corregido "Satander"       
        comboBoxCiudades = new JComboBox<>(ciudades);    
        comboBoxCiudades.setBounds(180, 30, 150, 30);    
        frame.add(comboBoxCiudades);        

        // 2. Número de Entradas
        lblEntradas = new JLabel("Nº Entradas:");
        lblEntradas.setBounds(30, 80, 100, 30);
        frame.add(lblEntradas);

        tfEntradas = new JTextField();   
        tfEntradas.setBounds(180, 80, 150, 30);  
        frame.add(tfEntradas);  
        
        // 3. Tipo de Entrada (RadioButtons)
        lblTipo = new JLabel("Tipo de zona:");
        lblTipo.setBounds(30, 130, 100, 30);
        frame.add(lblTipo);

        r1 = new JRadioButton("Pista");    
        r2 = new JRadioButton("Grada");    
        r3 = new JRadioButton("Palco");    
        r1.setBounds(180, 130, 70, 30);
        r2.setBounds(250, 130, 70, 30);
        r3.setBounds(320, 130, 70, 30);
        
        // ¡Importante! Agruparlos para que solo se pueda elegir uno
        grupoTipo = new ButtonGroup();
        grupoTipo.add(r1);  
        grupoTipo.add(r2); 
        grupoTipo.add(r3);  
        r1.setSelected(true); // Seleccionado por defecto
        
        frame.add(r1);  
        frame.add(r2); 
        frame.add(r3);  

        // 4. Código de Descuento
        lblCodigo = new JLabel("Código Descuento:");
        lblCodigo.setBounds(30, 190, 130, 30);
        frame.add(lblCodigo);

        tfCodigo = new JTextField();   
        tfCodigo.setBounds(180, 190, 150, 30);  
        frame.add(tfCodigo);

        // 5. Checkbox Pulsera
        chkPulsera = new JCheckBox("¿Desea pulsera conmemorativa? (+5€)");    
        chkPulsera.setBounds(30, 240, 300, 30);  
        frame.add(chkPulsera);  
        
        // 6. Botón Calcular
        botonCalcular = new JButton("Calcular Precio");
        botonCalcular.setBounds(30, 300, 370, 40);
        frame.add(botonCalcular);

        // 7. Etiqueta para mostrar el resultado
        lblResultado = new JLabel("Total a pagar: 0.00 €", SwingConstants.CENTER);
        lblResultado.setBounds(30, 360, 370, 40);
        lblResultado.setFont(lblResultado.getFont().deriveFont(16.0f)); // Letra más grande
        frame.add(lblResultado);

        // --- LÓGICA DEL CÁLCULO ---
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPrecio();
            }
        });

        // Hacer la ventana visible al final de añadir los componentes
        frame.setVisible(true);  
    }    

    private void calcularPrecio() {
        try {
            // Validar y leer número de entradas
            int numEntradas = Integer.parseInt(tfEntradas.getText().trim());
            if (numEntradas <= 0) {
                JOptionPane.showMessageDialog(frame, "Introduce un número válido de entradas.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Determinar precio base según la zona
            double precioBase = 0;
            if (r1.isSelected()) precioBase = 50.0;       // Pista
            else if (r2.isSelected()) precioBase = 40.0;  // Grada
            else if (r3.isSelected()) precioBase = 80.0;  // Palco

            // Variación según la ciudad (ejemplo)
            String ciudad = (String) comboBoxCiudades.getSelectedItem();
            if (ciudad.equals("Madrid")) {
                precioBase += 10; // Madrid es más caro
            }

            // Calcular subtotal
            double total = precioBase * numEntradas;

            // Extra por pulsera
            if (chkPulsera.isSelected()) {
                total += (5.0 * numEntradas);
            }

            // Aplicar descuento por código
            String codDescuento = tfCodigo.getText().trim();
            if (codDescuento.equalsIgnoreCase("PROMO10")) {
                total = total * 0.90; // 10% de descuento
            }

            // Mostrar resultado en la interfaz
            lblResultado.setText(String.format("Total a pagar: %.2f €", total));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, introduce un número entero en las entradas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {    
        // Es buena práctica lanzar la GUI en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new main();         
            }
        });
    }    
}