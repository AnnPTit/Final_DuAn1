/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.Mau;
import java.util.List;

/**
 *
 * @author HP
 */
public interface MauSacService {
    public List<Mau> getAll();
    String add(Mau ms);
    String update(Mau ms, Integer id);
    String delete(Mau ms, Integer id);
}