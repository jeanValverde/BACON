/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.bacon.service;

import com.restaurante.bacon.dao.IProveedorDao;
import com.restaurante.bacon.dto.Proveedor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe
 */
@Service
public class ProveedorService {
    
    @Autowired
    IProveedorDao provedorDao;
    
    public Proveedor addProveedor(Proveedor proveedor){
        return this.provedorDao.save(proveedor);
    }
}
