/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mintic.usa.ciclo3.ejemplosoring;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lindi
 */
@Repository
public class ClientesRepositorio {
          @Autowired
    private InterfaceClientes crud1;

    public List<Clientes> getAll(){
        return (List<Clientes>) crud1.findAll();
    }
    public Optional<Clientes> getCliente(int id){
        return crud1.findById(id);
    }

    public Clientes save(Clientes cliente){
        return crud1.save(cliente);
    }
    public void delete(Clientes cliente){
        crud1.delete(cliente);
    }
}

