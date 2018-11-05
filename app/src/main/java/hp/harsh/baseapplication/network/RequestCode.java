package hp.harsh.baseapplication.network;

/**
 * Created by Harsh on 2/9/2016.
 */
public class RequestCode {

    // Response Variable
    public static final int SUCCESS_CODE = 200;
    public static final int NOT_FOUND_CODE = 404;
    public static final int NO_CONTENT_CODE = 204;
    public static final int INTERNAL_ERROR_CODE = 500;
    public static final int BAD_REQUEST_CODE = 400;
    public static final int CONFLICT_CODE = 409;
    public static final int UNAUTHORIZED_CODE = 401;

    // Network Request code
    public static final int CODE_USER_LOGIN = 1;
    public static final int CODE_USER_REGISTER = 2;
    public static final int CODE_USER_FORGOT_PASSWORD = 3;
    public static final int CODE_USER_RESET_PASSWORD = 4;
    public static final int CODE_USER_NEW_MAINTENANCE = 5;
    public static final int CODE_USER_GET_ALL_MAINTENANCE = 6;
    public static final int CODE_USER_NOTIFICATION = 6;
}
