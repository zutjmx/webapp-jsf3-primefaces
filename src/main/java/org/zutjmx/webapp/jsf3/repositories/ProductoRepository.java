package org.zutjmx.webapp.jsf3.repositories;

import org.zutjmx.webapp.jsf3.entities.Producto;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto>{
    List<Producto> listarPorNombre(String nombre);
}
