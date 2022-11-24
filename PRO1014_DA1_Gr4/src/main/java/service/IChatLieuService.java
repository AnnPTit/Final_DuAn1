/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.ChatLieu;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IChatLieuService {
    public List<ChatLieu> getAll();
    String add(ChatLieu cl);
    String update(ChatLieu cl, Integer id);
    String updateTrangThai(Integer id);
}
