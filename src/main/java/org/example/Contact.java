package org.example;

public class Contact {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;

    //definimos el constructor para inicializar los valores
    public Contact(String nombre,String apellido, String telefono, String email, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;

    }


    public String getNombre() {
        return nombre != null ? nombre : "nombre vacío"; //valor por defecto si es null
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido != null ? apellido : "apellido vacío"; //valor por defecto si es null
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email != null ? email : "email vacío"; //valor por defecto si es null
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion != null ? direccion : "dirección vacío"; //valor por defecto si es null
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }





    //metodo para transformar el contacto en formato texto
    public String ToString(){
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Telefono: " + telefono + "\n" +
                "Email: " + email + "\n" +
                "Direccion: " + direccion;

    }






}