package mvc.data.resp;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import mvc.data.enums.StatusCode;

/**
 * <p>
 * [Resp]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/04/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Resp {
    
    
    /** 回應訊息 */
    private String info;
    /** 狀態碼 */
    @JsonProperty("statusCode")
    private Integer status;
    /** 資料 */
    private Object data;
    /** 回應時間 */
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date responseTime;
    
    
    public Resp(StatusCode statusCode) {
        super();
        this.info = statusCode.getMsg();
        this.status = statusCode.getCode();
        this.responseTime = new Date();
    }

    public Resp(StatusCode statusCode, Object data) {
        this(statusCode);
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "Resp [info=" + info + ", status=" + status + ", data=" + data + ", responseTime=" + responseTime + "]";
    }

}
