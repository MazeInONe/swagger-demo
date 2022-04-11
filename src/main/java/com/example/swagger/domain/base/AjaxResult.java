package com.example.swagger.domain.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Malu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AjaxResult extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 4387638801693645870L;

    public enum Type {
        /**
         * 成功
         */
        SUCCESS(0),
        /**
         * 失败
         */
        FAILED(-1);
        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    private final String CODE_TAG = "code";
    private final String MSG_TAG = "msg";
    private final String DATA_TAG = "data";

    public AjaxResult(Type result, String msg, Object data) {
        super.put(CODE_TAG, result.value);
        super.put(MSG_TAG, msg);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }


    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(Type.SUCCESS, msg, data);
    }

    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    public static AjaxResult success(Object data) {
        return AjaxResult.success("操作成功", data);
    }

    public static AjaxResult error() {
        return AjaxResult.success("操作失败");
    }

    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(Type.FAILED, msg, data);
    }

    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    public static AjaxResult error(Object data) {
        return AjaxResult.error("操作成功", data);
    }


}
