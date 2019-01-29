//ackage com.itrex.skeleton.springmvc.exception;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//
//@Data
//public class ApiException extends RuntimeException {
//
//    @AllArgsConstructor
//    public enum Message {
//        USER_EXISTS_ERROR("User with email = [%s] already exists"),
//        INVALID_CREDS("Username or password is incorrect"),
//        NO_USER_ID_IN_TOKEN("Cannot find user id in token"),
//        USER_NOT_FOUND("Cannot find user"),
//        INVALID_AUTH("Missing or invalid authorization header"),
//        INVALID_VERIFICATION_KEY("Verification key is invalid"),
//        INVALID_RESET_PWD_KEY("Reset password key is invalid"),
//        PASSWORDS_DO_NOT_MATCH("Confirm password does not match");
//
//        @Getter
//        String text;
//    }
//
//    private HttpStatus httpStatus;
//    private String message;
//
//    public ApiException(String msg, HttpStatus status) {
//        super(msg);
//        this.message = msg;
//        this.httpStatus = status;
//    }
//}
//
//примеры
//
//        import lombok.Builder;
//        import lombok.Data;
//
//@Data
//@Builder
//public class MvcException extends RuntimeException {
//    private String message;
//    private String viewName;
//
//    public MvcException(String message, String viewName) {
//        super(message);
//        this.message = message;
//        this.viewName = viewName;
//    }
//}