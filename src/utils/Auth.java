package utils;

import entity.Nhanvien;

public class Auth {
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static Nhanvien user = null;

    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        Auth.user = null;
    }

    /**
     * Kiểm tra xem đăng nhập hay chưa
     */
    public static boolean isLogin() {
        return Auth.user != null;
    }

    /**
     * Kiểm tra xem có phải là quản lý hay không
     */
    public static boolean isManager() {
        return Auth.isLogin() && "VT01".equals(user.getMaVaitro());
    }

    /**
     * Kiểm tra xem có phải là nhân viên lễ tân hay không
     */
    public static boolean isReceptionist() {
        return Auth.isLogin() && "VT02".equals(user.getMaVaitro());
    }

    /**
     * Kiểm tra xem có phải là admin hay không
     */
    public static boolean isAdmin() {
        return Auth.isLogin() && "VT03".equals(user.getMaVaitro());
    }
}
