package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Agenda de contactos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 300);

        // Crear diseño simple
        ventana.setLayout(new BorderLayout()); // Usar BorderLayout para una distribución más común

        // Instancia de la agenda de contactos
        AgendaContactos agenda = new AgendaContactos();

        // Crear panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(6, 1, 10, 10)); // 6 botones con espaciado

        // Crear botones para las opciones
        JButton btnAñadir = new JButton("Añadir Contacto");
        JButton btnEditar = new JButton("Editar Contacto");
        JButton btnEliminar = new JButton("Eliminar Contacto");
        JButton btnBuscar = new JButton("Buscar Contacto");
        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        JButton btnSalir = new JButton("Salir");

        // Agregar botones al panel
        panelPrincipal.add(btnAñadir);
        panelPrincipal.add(btnEditar);
        panelPrincipal.add(btnEliminar);
        panelPrincipal.add(btnBuscar);
        panelPrincipal.add(btnMostrarTodos);
        panelPrincipal.add(btnSalir);

        // Agregar panel a la ventana
        ventana.add(panelPrincipal, BorderLayout.CENTER);

        // Crear área de texto para mostrar resultados
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        ventana.add(scrollPane, BorderLayout.SOUTH);

        // Acciones para los botones
        btnAñadir.addActionListener(e -> {

            agenda.AñadirContacto(ventana, textArea);


        });

        btnEditar.addActionListener(e -> {
            agenda.EditarContacto(ventana, textArea);

        });

        btnEliminar.addActionListener(e -> {
            agenda.EliminarContacto(ventana, textArea);
        });

        btnBuscar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(ventana, "Introduce el nombre del contacto a buscar:");
            if (nombre != null) {
                // Lógica para buscar contacto
                textArea.append("Resultado de búsqueda para: " + nombre + "\n");
            }
        });

        btnMostrarTodos.addActionListener(e -> {
            // Lógica para mostrar todos los contactos
            textArea.append("Mostrando todos los contactos...\n");
        });

        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(ventana, "Saliendo del programa. ¡Adiós!");
            System.exit(0);
        });

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
