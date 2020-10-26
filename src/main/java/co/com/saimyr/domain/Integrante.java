package co.com.saimyr.domain;

public class Integrante {
    private String nombre;
    private String parentezco;
    private double ingresos;

    public Integrante() {
    }

    public Integrante(String nombre, String parentezco, double ingresos) {
        this.nombre = nombre;
        this.parentezco = parentezco;
        this.ingresos = ingresos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentezco() {
        return parentezco;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
}
