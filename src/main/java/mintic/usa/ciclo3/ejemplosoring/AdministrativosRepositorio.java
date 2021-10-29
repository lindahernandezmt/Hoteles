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
public class AdministrativosRepositorio {
          @Autowired
    private InterfaceAdministrativos crud1;

    public List<Administrativos> getAll(){
        return (List<Administrativos>) crud1.findAll();
    }
    public Optional<Administrativos> getAdmin(int id){
        return crud1.findById(id);
    }

    public Administrativos save(Administrativos admin){
        return crud1.save(admin);
    }
    public void delete(Administrativos admin){
        crud1.delete(admin);
    }
}
