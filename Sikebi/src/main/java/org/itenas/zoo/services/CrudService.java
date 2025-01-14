/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itenas.zoo.services;

import java.util.List;
import org.itenas.zoo.model.Tiket;

/**
 *
 * @author HP
 * @param <T>
 */
public interface CrudService<T> {
    void create(T object);
    T findOne(String id);
    List<T> findAll();
    void update(String id, T object);
    boolean delete(String id);

    public void create(Tiket tiket);

    public void update(String id, Tiket tiket);
}
