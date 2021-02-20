package hutech.com.myapplication.manager

enum class ErrorCode {
    USERNOTEXISTS,
    USERINCORRECT,
    CONNECTFAIL;

    fun message() : String {
        return when (this) {
            USERNOTEXISTS -> "Tên đăng nhập không tồn tại"
            USERINCORRECT -> "Sai tên đăng nhập hoặc mật khẩu"
            CONNECTFAIL -> "Kết nối thất bại"
        }
    }

}