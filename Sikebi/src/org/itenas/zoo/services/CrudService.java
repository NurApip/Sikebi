/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itenas.zoo.services;

import java.util.List;

/**
 *
 * @author HP
 * @param <T>
 */
public interface CrudService {
    void create(T object);
    T findOne(String nip);
    List<T> findAll();
    void update(String nip, T object);
    boolean delete(String nip);
}
