package ec.edu.ups.projectgames.security;

public class SecurityConstants {
    public static final String SECRET = "oursecretkey";
    public static final long EXPIRATION_TIME = 1_800_000; // 1 days = 86400_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/securities/register";
    public static final String SIGN_IN_URL = "/securities/login";
    public static final String GET_USER = "/securities/username/";

}
