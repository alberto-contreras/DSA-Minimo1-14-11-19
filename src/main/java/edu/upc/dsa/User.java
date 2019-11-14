package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class User {//PARA QUE FUNCIONE CON JERSEY CONSTRUCTOR VACIO + GETTERS Y SETTERS/
    private String idUser;
    private String nombre;
    private String apellido;
    private List<Obj> misObj;
    public User(){ }
    public User(String a, String b, String c){
        this.idUser = a;
        this.nombre = b;
        this.apellido = c;
        this.misObj = new LinkedList<Obj>();
    }
    public void addObj(Obj a){
        misObj.add(a);
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Obj> getMisObj() {
        return misObj;
    }

    public void setMisObj(List<Obj> misObj) {
        this.misObj = misObj;
    }
}


