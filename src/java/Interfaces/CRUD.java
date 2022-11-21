package Interfaces;

import Modelo.Pessoa;
import java.util.List;

public interface CRUD {

    public List listar();

    public Pessoa list(int id);

    public boolean add(Pessoa a);
    
    public boolean eliminar(int id);
    
    public boolean edit(Pessoa a);

}
