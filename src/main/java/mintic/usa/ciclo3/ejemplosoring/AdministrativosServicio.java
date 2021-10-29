/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mintic.usa.ciclo3.ejemplosoring;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lindi
 */
@Service
public class AdministrativosServicio {
    @Autowired
     private AdministrativosRepositorio metodosCrud;
     
     public List<Administrativos> getAll(){
        return metodosCrud.getAll();
    }
     
      public Optional<Administrativos> getAdmin (int adminId) {
        return metodosCrud.getAdmin(adminId);
    }

    public Administrativos save(Administrativos admin){
        if(admin.getIdAdmin()==null){
            return metodosCrud.save(admin);
        }else{
            Optional<Administrativos> e= metodosCrud.getAdmin(admin.getIdAdmin());
            if(e.isPresent()){
                return metodosCrud.save(admin);
            }else{
                return admin;
            }
        }
    }

    public Administrativos update(Administrativos admin){
        if(admin.getIdAdmin()!=null){
            Optional<Administrativos> e= metodosCrud.getAdmin(admin.getIdAdmin());
            if(e != null){
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                if(admin.getPassword()!=null){
                    e.get().setPassword(admin.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public boolean deleteAdmin(int adminId) {
        Boolean aBoolean = getAdmin (adminId).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
