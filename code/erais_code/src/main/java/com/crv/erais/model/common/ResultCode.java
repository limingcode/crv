package com.crv.erais.model.common;

/**
 * @author zph
 * @date 2018-10-09
 *  API 统一返回状态码
 */
public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(0, "成功"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(401, "登陆信息过期，请重新登陆！"),
    PERMISSION_UNAUTHORIZED_ACCESS(402, "非本人待办信息,禁止查看详情和操作！"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    PARAM_IS_LENGTH(10005, "当前参数长度有误"),

    /* 用户错误：400-499*/

    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    USER_PASSWORD_ERROR(20006, "账号不存在或密码错误"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),
    RMAS_Code_EXIST(30002,"编码不允许重复"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    SYSTEM_ERROR(40002, "系统异常"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATA_PERMISSION_NO_ACCESS(50004,"禁止操作数据"),

    /* 接口错误：60001-69999 */
//    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
//    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
//    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效");
//    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
//    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),



    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public static String getMessage(Integer code){
        for(ResultCode resultCode:ResultCode.values()){
            if(code.equals(resultCode.getCode())){
                return resultCode.getMessage();
            }
        }
        return  null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
