package sawkiewicz.task1;

public class Answer {
    private String responce;
    private String message;

    public Answer(String responce, String message) {
        this.responce = responce;
        this.message = message;
    }

    public Answer() {
    }

    public void setResponce(String responce) {
        this.responce = responce;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponce() {
        return responce;
    }

    public String getMessage() {
        return message;
    }
}
