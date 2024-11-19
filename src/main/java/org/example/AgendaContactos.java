package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AgendaContactos {

    private List<Contact> contactos = new ArrayList<>(); //inicialización directa de la lista

    public AgendaContactos(){
        contactos = new ArrayList<>();
        //contactos = new ArrayList<>(); //creamos la lista de contactos vacia
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




    public void AñadirContacto(Scanner scanner){

        System.out.println("Ingrese el nombre:");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el telefono:");
        int telefono = scanner.nextInt();

        System.out.println("Ingrese el email:");
        String email = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese la dirección: ");
        String direccion = scanner.nextLine();

        // Crear una nueva instancia de Note:
        Contact newContact = new Contact(nombre, apellido, telefono, email, direccion);
        //Añadir el contacto a lista_de_contactos
        contactos.add(newContact);

        System.out.println("Contacto agregado correctamente.");
    }

    public void EditarContacto(Scanner scanner){

       // Pedir criterio de búsqueda (nombre, teléfono, etc.)
        //Llamar a BuscarContacto
        //Si contacto encontrado:
        //Pedir nuevos datos
        //Llamar a EditarContacto

        // Pedir al usuario que seleccione el contacto a editar mediante su nombre.
        System.out.println("Para editar el contacto puede buscarlo por: ");
        System.out.println("1. Nombre ");
        System.out.println("2. Apellido ");
        System.out.println("3. Telefono ");
        System.out.println("4. Email ");

        int option;

        option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println("Vamos a buscar los contactos coincidentes por nombre");

                System.out.println();

                System.out.println("Introduzca el nombre que quiere buscar: ");
                scanner.nextLine();
                String nombre = scanner.nextLine();

                // Buscar el contacto por el nombre
                Contact ContactToEdit = findContactByName(nombre);

                if (ContactToEdit != null) {
                    // Si la nota fue encontrada, pedir al usuario que modifique los campos
                    System.out.println("Contacto encontrado. ¿Qué te gustaría cambiar?");
                    System.out.println("1. Nombre");
                    System.out.println("2. Apellido");
                    System.out.println("3. Dirección");
                    System.out.println("4. Teléfono");
                    System.out.println("4. Email");

                    option = scanner.nextInt();

                    switch (option){
                        case 1:
                            System.out.println("Introduce el nuevo nombre: ");
                            scanner.nextLine();
                            ContactToEdit.setNombre(scanner.nextLine());
                            System.out.println("Contacto modificado correctamente.");
                            break;
                    }




                }




        }











    }












}
