/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.NSX;
import java.util.List;
/**
 *
 * @author HP
 */
public interface NSXService {
    public List<NSX> getAll();
    String add(NSX nsx);
    String update(NSX nsx, Integer id);
    String delete(NSX nsx, Integer id);
}
