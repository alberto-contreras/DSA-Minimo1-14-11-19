package edu.upc.dsa;

public class Obj {
    private String idObj;
    private String tipo;
    public Obj (){}
    public Obj(String id, String tip){
        this.idObj = id;
        this.tipo = tip;

    }

    public String getIdObj() {
        return idObj;
    }

    public void setIdObj(String idObj) {
        this.idObj = idObj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
