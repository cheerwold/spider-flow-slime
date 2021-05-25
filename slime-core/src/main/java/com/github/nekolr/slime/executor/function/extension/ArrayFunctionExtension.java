package com.github.nekolr.slime.executor.function.extension;

import org.apache.commons.lang3.StringUtils;
import com.github.nekolr.slime.annotation.Comment;
import com.github.nekolr.slime.annotation.Example;
import com.github.nekolr.slime.executor.FunctionExtension;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ArrayFunctionExtension implements FunctionExtension {

    @Override
    public Class<?> support() {
        return Object[].class;
    }

    @Comment("获取数组的长度")
    @Example("${arrayVar.size()}")
    public static int size(Object[] objs) {
        return objs.length;
    }

    @Comment("将数组用 separator 拼接起来")
    @Example("${arrayVar.join('-')}")
    public static String join(Object[] objs, String separator) {
        return StringUtils.join(objs, separator);
    }

    @Comment("将数组拼接起来")
    @Example("${arrayVar.join()}")
    public static String join(Object[] objs) {
        return StringUtils.join(objs);
    }

    @Comment("将数组转为 List")
    @Example("${arrayVar.toList()}")
    public static List<?> toList(Object[] objs) {
        return Arrays.asList(objs);
    }

}
