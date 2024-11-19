package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AgendaContactos {
    String nombre;
    int option;

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

        scanner.nextLine();
        // Pedir al usuario que seleccione el contacto a editar mediante su nombre.
        System.out.println("Selecciona el nombre del contacto a editar: ");
        nombre = scanner.nextLine();

        // Buscar el contacto por el nombre
        Contact ContactToEdit = findContactByName(nombre);

        if (ContactToEdit != null) {
            // Si la nota fue encontrada, pedir al usuario que modifique los campos
            System.out.println("Contacto encontrado. ¿Qué te gustaría cambiar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Dirección");
            System.out.println("4. Teléfono");
            System.out.println("5. Email");

            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Introduce el nuevo nombre: ");
                    scanner.nextLine();
                    ContactToEdit.setNombre(scanner.nextLine());
                    System.out.println("Nombre modificado correctamente.");
                    break;
                case 2:
                    System.out.println("Introduce el nuevo apellido: ");
                    scanner.nextLine();
                    ContactToEdit.setApellido(scanner.nextLine());
                    System.out.println("Apellido modificado correctamente.");
                    break;
                case 3:
                    System.out.println("Introduce la nueva dirección: ");
                    scanner.nextLine();
                    ContactToEdit.setDireccion(scanner.nextLine());
                    System.out.println("Dirección modificada correctamente.");
                    break;
                case 4:
                    System.out.println("Introduce el nuevo teléfono: ");
                    scanner.nextLine();
                    ContactToEdit.setTelefono(scanner.nextInt());
                    System.out.println("Teléfono modificado correctamente.");
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Introduce el nuevo email: ");
                    ContactToEdit.setEmail(scanner.nextLine());
                    System.out.println("Email modificado correctamente.");
                    break;




            }




                }


        }
    public void EliminarContacto(Scanner scanner){

        scanner.nextLine();
        System.out.println("Introduce el contacto a eliminar: ");
        nombre = scanner.nextLine();

        Contact ContactToDelete = findContactByName(nombre);

        if(ContactToDelete != null){
            contactos.remove(ContactToDelete);
            System.out.println("Contacto eliminado correctamente.");
        }else{
            System.out.println("La lista de contactos está vacía.");
        }

    }

    public void ViewContacts(Scanner scanner){


        System.out.println("Introduce el nombre del contacto que quieres buscar: ");
        scanner.nextLine();
        nombre = scanner.nextLine();

        Contact ContactToView = findContactByName(nombre);

        if(ContactToView != null){
            System.out.println("Nombre: "+ContactToView.getNombre());
            System.out.println("Apellido: "+ContactToView.getApellido());
            System.out.println("Dirección: "+ContactToView.getDireccion());
            System.out.println("Teléfono: "+ContactToView.getTelefono());
            System.out.println("Email: "+ContactToView.getEmail());
        }else{
            System.out.println("La lista de contactos está vacía.");
        }




    }

    public void ViewAllContacts(Scanner scanner){
        if(contactos != null && !contactos.isEmpty()){
            for(Contact contacto : contactos){
                System.out.println("Nombre: "+contacto.getNombre());
                System.out.println("Apellido: "+contacto.getApellido());
                System.out.println("Dirección: "+contacto.getDireccion());
                System.out.println("Teléfono: "+contacto.getTelefono());
                System.out.println("Email: "+contacto.getEmail());
            }

        }else{
            System.out.println("No hay contactos disponibles");
        }





    }



    }

