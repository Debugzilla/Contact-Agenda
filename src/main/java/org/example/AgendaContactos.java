package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgendaContactos {
    private List<Contact> contactos = new ArrayList<>();

    public AgendaContactos() {
        contactos = new ArrayList<>();
    }

    // Método para buscar un contacto por nombre
    public Contact findContactByName(String nombre) {
        for (Contact contact : contactos) {
            if (contact.getNombre().equalsIgnoreCase(nombre)) {
                return contact; // Retorna el contacto si coincide el nombre
            }
        }
        return null; // Retorna null si no encuentra el contacto
    }

    // Método para añadir un contacto (interfaz gráfica)
    public void AñadirContacto(JFrame ventana, JTextArea textArea) {
        // Crear un panel de entrada con campos de texto
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);
        JLabel lblApellido = new JLabel("Apellido:");
        JTextField txtApellido = new JTextField(20);
        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField(20);
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);
        JLabel lblDireccion = new JLabel("Dirección:");
        JTextField txtDireccion = new JTextField(20);



        // Añadir los componentes al panel
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(new JLabel()); // Espacio vacío


// Mostrar el formulario en un cuadro de diálogo modal
        int result = JOptionPane.showConfirmDialog(
                ventana,
                panel,
                "Añadir Contacto",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        // Acciones si el usuario selecciona "OK"
        if (result == JOptionPane.OK_OPTION) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String telefonoStr = txtTelefono.getText();
            String email = txtEmail.getText();
            String direccion = txtDireccion.getText();

            // Validar que los campos no estén vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || telefonoStr.isEmpty() || email.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Intentar convertir el teléfono a número entero
            String telefono;
            try {
                telefono = telefonoStr; // Convertir teléfono a entero
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Por favor, ingrese un número válido para el teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear una nueva instancia de Contact
            Contact newContact = new Contact(nombre, apellido, telefono, email, direccion);

            // Añadir el nuevo contacto a la lista de contactos
            contactos.add(newContact);

            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(ventana, "Contacto agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Actualizar el JTextArea
            textArea.append(
                    String.format("Nombre: %s, Apellido: %s, Teléfono: %d, Email: %s, Dirección: %s%n",
                            nombre, apellido, telefono, email, direccion)
            );
        }
    }

    public void EditarContcto(JFrame ventana, JTextArea textArea){

        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "No hay contactos para editar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear JComboBox o JList con los contactos
        String[] nombresContactos = new String[contactos.size()];
        for (int i = 0; i < contactos.size(); i++) {
            nombresContactos[i] = contactos.get(i).getNombre() + " " + contactos.get(i).getApellido();
        }

        JComboBox<String> comboBox = new JComboBox<>(nombresContactos);
        int opcion = JOptionPane.showConfirmDialog(ventana, comboBox, "Selecciona un contacto", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.CANCEL_OPTION) {
            return;  // Si se cancela, salir
        }

        // Paso 2: Obtener el contacto seleccionado
        int indiceSeleccionado = comboBox.getSelectedIndex();
        Contact contactoSeleccionado = contactos.get(indiceSeleccionado);

        // Paso 3: Mostrar formulario con los datos actuales del contacto
        JTextField txtNombre = new JTextField(contactoSeleccionado.getNombre());
        JTextField txtApellido = new JTextField(contactoSeleccionado.getApellido());
        JTextField txtTelefono = new JTextField(contactoSeleccionado.getTelefono());
        JTextField txtEmail = new JTextField(contactoSeleccionado.getEmail());
        JTextField txtDireccion = new JTextField(contactoSeleccionado.getDireccion());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2));
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Apellido:"));
        panelFormulario.add(txtApellido);
        panelFormulario.add(new JLabel("Teléfono:"));
        panelFormulario.add(txtTelefono);
        panelFormulario.add(new JLabel("Email:"));
        panelFormulario.add(txtEmail);
        panelFormulario.add(new JLabel("Dirección:"));
        panelFormulario.add(txtDireccion);

        int opcionEdicion = JOptionPane.showConfirmDialog(ventana, panelFormulario, "Editar Contacto", JOptionPane.OK_CANCEL_OPTION);

        if (opcionEdicion == JOptionPane.CANCEL_OPTION) {
            return;  // Si se cancela, salir
        }

        // Paso 4: Validar los campos
        if (txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty() ||
                txtTelefono.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "Todos los campos deben estar completos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!txtTelefono.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(ventana, "El teléfono debe ser un número válido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Paso 5: Actualizar el contacto en la lista
        contactoSeleccionado.setNombre(txtNombre.getText());
        contactoSeleccionado.setApellido(txtApellido.getText());
        contactoSeleccionado.setTelefono(txtTelefono.getText());
        contactoSeleccionado.setEmail(txtEmail.getText());
        contactoSeleccionado.setDireccion(txtDireccion.getText());

        // Paso 6: Actualizar JTextArea con los nuevos datos
        StringBuilder sb = new StringBuilder();
        for (Contact contacto : contactos) {
            sb.append(contacto.toString()).append("\n");
        }
        textArea.setText(sb.toString());

        // Paso 7: Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(ventana, "Contacto actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }




    // Paso 1: Mostrar lista de contactos para seleccionar uno a editar
       // Crear un panel con lista desplegable (JComboBox o JList) para seleccionar un contacto
       // Si no hay contactos, mostrar mensaje de error y salir






    }
