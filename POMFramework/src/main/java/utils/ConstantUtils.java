package utils;

public enum ConstantUtils {

    USERONE("anshulc55@rediff.com","Test@1234");

    private final String username;
    private final String password;
   ConstantUtils(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
