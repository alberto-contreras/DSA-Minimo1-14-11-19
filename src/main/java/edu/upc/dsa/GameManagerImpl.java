package edu.upc.dsa;

import com.sun.tools.internal.ws.processor.generator.CustomExceptionGenerator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class GameManagerImpl implements GameManager {
    private static GameManagerImpl instance;
    protected Logger log = LogManager.getLogger(GameManagerImpl.class);

    //ESTRUCTURAS
    private HashMap<String, User> users;

    private GameManagerImpl() {
        //CONSTRUCTOR PRIVADO INICIALIZA CON EL GET INSTANCE
        this.users = new HashMap<>();
    }

    public static GameManagerImpl getInstance() {
        if (instance == null) instance = new GameManagerImpl();
        return instance;
    }


    public void addUser(String idUser, String nombre, String apellidos) {
        log.info("Estos son los parametros del nuevo user:" + idUser + "/" + nombre + "/" + apellidos);
        User u = new User(idUser, nombre, apellidos);
        users.put(idUser, u);
        log.info("Usuario: " + idUser + " añadido correctamente");

    }

    public User modifUser(String idUser, String newName, String newApellido) {
        log.info("Estos son los parametros que modificaremos del user:" + idUser + "/" + newName + "/" + newApellido);
        User aux = users.get(idUser);
        aux.setNombre(newName);
        aux.setApellido(newApellido);
        users.put(idUser, aux);
        log.info("Modificaciones hechas correctamente:" + users.get(idUser).getNombre());
        return aux;

    }

    public int numUsers() {
        log.info("Num Users:" + users.size());
        return users.size();
    }

    public User consUser(String idUser) {
        log.info("Has consultado el Users:" + idUser);
        return users.get(idUser);
    }


    public void addObject(String idUser, String idObj, String typeObj) {
        log.info("Objeto que le vamos a añadir al user con id:" + idUser + "/" + typeObj);
        Obj aux = new Obj(idObj, typeObj);
        User aux1 = users.get(idUser);
        aux1.addObj(aux);
        log.info("Objeto añadido");

    }

    public List<Obj> consObj(String idUser) {
        log.info("Consultas los Obj del users:" + idUser);
        User u = users.get(idUser);
        return u.getMisObj();
    }

    public int numObjUser(String idUser) {
        User u = users.get(idUser);
        log.info("Num Obj users:" + idUser + "  " + u.getMisObj().size());
        return u.getMisObj().size();
    }


    public List<User> usersOrdAlf()  {
        List<User> clon = new ArrayList<>(users.values());
        if(clon.size()==0) {log.error("No hay users en el sistema ");}
        else {
            Collections.sort(clon, new Comparator<User>() {
                public int compare(User s1, User s2) {
                    return s1.getNombre().compareTo(s2.getNombre());
                }
            });
        }
        log.info("Num users que han sido ordenados alfabeticamente: "+clon.size());
        return clon;
    }
    public void liberar() {
        this.users.clear();

    }
}
