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
public class MensajesServicio {
  @Autowired
    private MensajesRepositorio metodosCrud;

    public List<Mensajes> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensajes> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public Mensajes save(Mensajes message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensajes> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public Mensajes update(Mensajes message){
        if(message.getIdMessage()!=null){
            Optional<Mensajes> e= metodosCrud.getMessage(message.getIdMessage());
            if(e != null){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}