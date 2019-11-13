package edu.upc.dsa;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GestorxyImpl implements Gestorxy {
    private static Gestorxy instance;
   // protected Logger log = LogManager.getLogger(GestorProductosImpl.class);
    private GestorxyImpl(){
       //CONSTRUCTOR PRIVADO INICIALIZA CON EL GET INSTANCE
    }
    public static Gestorxy getInstance(){
        if (instance==null) instance = new GestorxyImpl();
        return instance;
    }

















    public void liberar() {
        //this.estructura.clear();

    }
}
