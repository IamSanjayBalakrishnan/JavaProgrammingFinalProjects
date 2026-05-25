package pl.edu.vistula.sanjay.firstrestapi.product.api.response;

public class ErrorMessageResponse {
    private String message;

    public ErrorMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}