package utilities;

import model.NhanVien;

/**
 *
 * @author fallinluv2003
 */
public class Auth {
    public static NhanVien nv = null;
    
    public static void clear() {
        Auth.nv = null;
    }
    
    public static boolean isLogin() {
        return Auth.nv != null;
    }
    
    
}
