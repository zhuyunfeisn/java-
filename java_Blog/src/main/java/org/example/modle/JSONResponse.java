package org.example.modle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * http响应json数据，前后端统一约定的格式
 * 前端响应的状态码都是200，进入ajax的success来使用
 * 操作成功：(success:true,  data :xxx)
 * 操作失败：（success：false  code：xxx， message：xxx）
 */
@Setter
@Getter
@ToString
public class JSONResponse {
    //业务操作是否成功
    private boolean success;
    //业务操作的消息码,一般来说，出现错误的错误码才有意义
    private String code;
    //业务操作的错误信息，给用户看的信息
    private String message;
    //业务数据：业务操作成功时，给前端ajax，success方法使用，解析响应json数据，渲染网页信息
    private Object data;

}
