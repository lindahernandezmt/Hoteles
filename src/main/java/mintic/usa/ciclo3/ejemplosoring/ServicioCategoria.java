package mintic.usa.ciclo3.ejemplosoring;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author lindi
 */
@Service
public class ServicioCategoria {

    @Autowired
    private CategoriaRepositorio metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isPresent()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria) {
        if (categoria.getId() != null) {

            Optional<Categoria> catAux = metodosCrud.getCategoria(categoria.getId());

            if (catAux != null ) {

                if (categoria.getName() != null) {
                    catAux.get().setName(categoria.getName());
                }

                if (categoria.getDescription() != null) {
                    catAux.get().setDescription(categoria.getDescription());
                }

                return metodosCrud.save(catAux.get());
            }
        }
        return categoria;
    }

   

    public boolean deletecategoria(int categoriaId) {
        Boolean d = getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
