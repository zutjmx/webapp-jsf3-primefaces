package org.zutjmx.webapp.jsf3.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.zutjmx.webapp.jsf3.entities.Categoria;

import java.util.List;

@RequestScoped
public class CategoriaRepositoryImpl implements CrudRepository<Categoria>{
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Categoria> listar() {
        return entityManager
                .createQuery("from Categoria",Categoria.class)
                .getResultList();
    }

    @Override
    public Categoria porId(Long id) {
        return entityManager
                .find(Categoria.class,id);
    }

    @Override
    public void guardar(Categoria categoria) {
        if(categoria.getId() != null && categoria.getId() > 0) {
            entityManager.merge(categoria);
        } else {
            entityManager.persist(categoria);
        }
    }

    @Override
    public void eliminar(Long id) {
        Categoria categoria = porId(id);
        entityManager.remove(categoria);
    }
}
