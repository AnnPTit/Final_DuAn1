/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.DanhMuc;
import java.util.List;

/**
 *
 * @author HP
 */
public interface DanhMucService {
    public List<DanhMuc> getAll();
    String add(DanhMuc dm);
    String update(DanhMuc dm, Integer id);
    String delete(DanhMuc dm, Integer id);
}
