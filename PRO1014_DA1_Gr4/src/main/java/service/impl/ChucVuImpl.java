package service.impl;

import java.util.List;
import model.ChucVu;
import repository.ChucVuRepository;
import service.ChucVuService;

/**
 *
 * @author fallinluv2003
 */
public class ChucVuImpl implements ChucVuService{
    
    private ChucVuRepository cvRepo = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return cvRepo.getAll();
    }
    
}
