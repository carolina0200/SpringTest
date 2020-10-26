package co.com.saimyr.domain;

import java.util.List;

public class Solicitud {
    private String id;
    private int sisben;
    private List<Integrante> integrantes;

    public Solicitud() {
    }

    public Solicitud(String id, int sisben, List<Integrante> integrantes) {
        this.id = id;
        this.sisben = sisben;
        this.integrantes = integrantes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSisben() {
        return sisben;
    }

    public void setSisben(int sisben) {
        this.sisben = sisben;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
}
