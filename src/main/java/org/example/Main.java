package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        //instancia de agenda de contactos
        AgendaContactos agenda = new AgendaContactos();


        do {
            DisplayMenu();
            System.out.println();
            System.out.print("Selecciona una de las opciones posibles: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:

                    System.out.println("Has seleccionado añadir contactos");
                    agenda.AñadirContacto(scanner);
                    break;
                case 2:
                    System.out.println("2. Has seleccionado editar contactos");
                    agenda.EditarContacto(scanner);
                    break;
                case 3:
                    System.out.println("3. Has seleccionado eliminar contactos");
                    agenda.EliminarContacto(scanner);
                    break;
                case 4:
                    System.out.println("4. Has seleccionado buscar contactos");
                    agenda.ViewContacts(scanner);
                    break;
                case 5:
                    System.out.println("5. Has seleccionado mostrar todos los contactos\"");
                    agenda.ViewAllContacts(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    //NoteManager.saveToDatabase(scanner);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");

            }

        } while (opcion != 6);

    }


    public static void DisplayMenu() {
        System.out.println();
        System.out.println("Menú de opciones del gestor de contactos:");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Editar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Buscar contacto");
        System.out.println("5. Mostrar todos los contactos");
        System.out.println("6. Salir");

    }
}