package parser;

public class ErrorFlag {

    private static boolean error = false;
    private static String message = "";

    public static boolean getFlag() {
        return error;
    }

    public static String getMsg() {
        return message;
    }

    public static void setMsg(String msg) {
        message = msg;
    }

    public static void setFlag() {
        error = true;
    }

    public static void reset() {
        error = false;
    }

}