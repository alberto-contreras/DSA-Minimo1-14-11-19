package edu.upc.dsa;

import java.util.List;

public interface GameManager {
    public void addUser (String idUser, String nombre, String apellidos);
    public User modifUser (String idUser, String newName, String newApellido);
    public int numUsers ();
    public User consUser (String idUser);
    public void addObject (String idUser, String idObj, String typeObj);
    public List<Obj> consObj (String idUser);
    public int numObjUser(String idUser);
    public List<User> usersOrdAlf() throws EmptyUserList;
    public void liberar();
}
