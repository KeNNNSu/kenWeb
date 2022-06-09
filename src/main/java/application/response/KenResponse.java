package application.response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.controller.JournalController;
import application.response.enums.StatusCode;

/**
 * <p>
 * [KenResponse]
 * </p>
 * 
 * @author ken
 * @since 2022/06/01
 */
public class KenResponse {

    private static Logger logger = LogManager.getLogger(KenResponse.class);

    private String message;
    private Object data;
    private StatusCode statusCode;

    private KenResponse() {
        super();
    }

    public KenResponse(String message, Object data, StatusCode statusCode) {
        this();
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "KenResponse [message=" + message + ", data=" + data + ", statusCode=" + statusCode.name() + "]";
    }

}
