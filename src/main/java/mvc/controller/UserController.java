package mvc.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import mvc.data.resp.Resp;
import mvc.utils.JsonUtils;
import mvc.data.enums.StatusCode;
import mvc.model.dto.UserDto;
import mvc.model.vo.UserVo;
import mvc.service.UserService;
import mvc.service.impl.UserServiceImpl;

/**
 * <p>
 * [User 控制層]
 * </p>
 * 
 * <pre>
 * -檢查參數 - 主要邏輯 - 資料轉換(接前端資料) - 處理異常(回傳前端處理狀態)
 * 
 * [RESTful API]
 * -[C]reate     /add?name=xx&age=19...
 * -[R]ead-find  /find?name=xx&....
 * -[R]ead-query /query?name=xx&....
 * -[U]pdate     /update?id=xxx&name=xxxx&age=18...
 * -[D]elete     /delete?id=xx
 * 
 * -Create      POST   /user
 * -Read-find   GET    /user/{id}
 * -Read-query  GET    /user/all
 * -Update      PUT    /user/{id}
 * -Delete      DELETE /user/{id}
 * </pre>
 * 
 * @author ken
 * @since 2022/04/04
 */
@Path("/k_user")
public class UserController {

    private UserService userService;

    public UserController() {
        super();
        this.userService = new UserServiceImpl();
    }

    @POST
    @Produces("application/json;charset=UTF-8")
    public String add(@FormParam("account") String account, @FormParam("password") String password) {
        Resp resp = null;
        try {
            UserDto userDto = new UserDto();
            userDto.setAccount(account);
            userDto.setPassword(password);
            boolean result = userService.add(userDto);
            StatusCode statusCode = (result ? StatusCode.S201 : StatusCode.E401);
            resp = new Resp(statusCode, result);
            System.out.println("新增資料: " + resp);
            return JsonUtils.toJson(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.toJson(new Resp(StatusCode.E499));
        }
    }

    @GET
    @Path("/all")
    @Produces("application/json;charset=UTF-8")
    public String query() throws Exception {
        Resp resp = null;
        try {
            List<UserVo> userVoList = userService.query();
            StatusCode statusCode = StatusCode.SUCCESS;
            resp = new Resp(statusCode, userVoList);
            System.out.println("查詢資料: " + resp);
            return JsonUtils.toJson(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.toJson(new Resp(StatusCode.E499));
        }
    }

    @GET
    @Path("/{uid}")
    @Produces("application/json;charset=UTF-8")
    public String findByUid(@PathParam("uid") String uid) {
        Resp resp = null;
        try {
            UserDto userVo = userService.findByUid(uid);
            StatusCode statusCode = (userVo != null ? StatusCode.SUCCESS : StatusCode.E499);
            resp = new Resp(statusCode, userVo);
            System.out.println("查詢資料-byUid: " + resp);
            return JsonUtils.toJson(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.toJson(new Resp(StatusCode.E499));
        }
    }

    @GET
    @Path("/by/{account}")
    @Produces("application/json;charset=UTF-8")
    public String findByAccount(@PathParam("account") String account) {
        Resp resp = null;
        try {
            UserDto userVo = userService.findByAccount(account);
            StatusCode statusCode = (userVo != null ? StatusCode.SUCCESS : StatusCode.E499);
            resp = new Resp(statusCode, userVo);
            System.out.println("查詢資料-byAccount: " + resp);
            return JsonUtils.toJson(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.toJson(new Resp(StatusCode.E499));
        }
    }

    @PUT
    @Path("/{uid}")
    @Produces("application/json;charset=UTF-8")
    public String modify(@PathParam("uid") String uid, @FormParam("password") String password) {
        Resp resp = null;
        try {
            UserDto userDto = new UserDto();
            userDto.setPassword(password);
            boolean result = userService.modify(uid, userDto);
            StatusCode statusCode = (result ? StatusCode.S202 : StatusCode.E402);
            resp = new Resp(statusCode, result);
            System.out.println("修改資料: " + resp);
            return JsonUtils.toJson(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.toJson(new Resp(StatusCode.E499));
        }
    }

    @DELETE
    @Path("/{uid}")
    @Produces("application/json;charset=UTF-8")
    public String remove(@PathParam("uid") String uid) {
        Resp resp = null;
        try {
            boolean result = userService.remove(uid);
            StatusCode statusCode = (result ? StatusCode.S203 : StatusCode.E403);
            resp = new Resp(statusCode, result);
            System.out.println("刪除資料: " + resp);
            return JsonUtils.toJson(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.toJson(new Resp(StatusCode.E499));
        }
    }

}
