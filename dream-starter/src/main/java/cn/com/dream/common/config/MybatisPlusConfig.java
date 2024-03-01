package cn.com.dream.common.config;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.DM);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }

    public static void main(String[] args) {
        List<String> dataList = new ArrayList<>();
        List<String> collect = dataList.stream().map(item -> item + "1").collect(Collectors.toList());
        Map<String, String> collect1 = collect.stream().collect(Collectors.toMap(Function.identity(), Function.identity(), (a, b) -> a));
        String s = collect1.get("1");
        System.out.println("1");
    }
}