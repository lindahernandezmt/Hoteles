/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mintic.usa.ciclo3.ejemplosoring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lindi
 */
@Repository
public class ReservasRepositorio {

    @Autowired
    private InterfaceReservas crud4;

    public List<Reservas> getAll() {
        return (List<Reservas>) crud4.findAll();
    }

    public Optional<Reservas> getReservation(int id) {
        return crud4.findById(id);
    }

    public Reservas save(Reservas reservation) {
        return crud4.save(reservation);
    }

    public void delete(Reservas reservation) {
        crud4.delete(reservation);
    }

    public List<Reservas> ReservasStatusRepositorio (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<Reservas> ReservasTiempoRepositorio (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ClienteContador> getClientesRepositorio(){
         List<ClienteContador> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservasByClientes();
         for(int i=0; i<report.size(); i++){
             res.add(new ClienteContador((Long)report.get(i)[1],(Clientes) report.get(i)[0]));
         }
         return res;
     }

}
