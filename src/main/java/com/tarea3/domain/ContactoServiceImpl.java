/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea3.domain;
import com.tarea3.Service.ContactoService;
import com.tarea3.dao.ContactoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoServiceImpl implements ContactoService {

  @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional(readOnly =true)
    public List<Contacto> getContacto() {
        return (List<Contacto>)contactoDao.findAll();
    }

    @Override
     @Transactional
    public void save(Contacto contacto) {
       contactoDao.save(contacto);
    }

    @Override
    @Transactional(readOnly =true)
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }
}
