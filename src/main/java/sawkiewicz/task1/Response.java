package sawkiewicz.task1;

public class Response {
    private String response;
    private String message;

    public Response(String response, String message) {
        this.response = response;
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public String getMessage() {
        return message;
    }
}
