package com.example.swagger.domain.base;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Malu
 */
@Data
public class AjaxResult extends HashMap<String, Object> implements Serializable {
    public enum Type {
        /**
         * 成功
         */
        SUCCESS(0),
        /**
         * 失败
         */
        FAILED(1);
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

    public AjaxResult() {
    }

    public AjaxResult(Type result, String msg) {
        super.put(CODE_TAG, result.value);
        super.put(MSG_TAG, msg);
    }

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


}
