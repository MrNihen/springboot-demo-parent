package com.nihen.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 修改自定义消息转换器,使用fastjson代替jackson
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/03 0:38
 */
@Configuration
public class FastjsonConfig implements WebMvcConfigurer {
    /**
     * 使用阿里 FastJson 作为JSON MessageConverter
     * @param converters 消息转换器列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
         /*
         先把JackSon的消息转换器删除.
         SpringBoot2.0后，有些东西改变了。在SpringBoot 1.X时代，整合fastjson是可以不排除JackSon消息转换器的。
         但在SpringBoot2.X时代，必须要排除JackSon消息转换器。
         备注: (1)源码分析可知，返回json的过程为:
                    Controller调用结束后返回一个数据对象，for循环遍历conventers，找到支持application/json的HttpMessageConverter，
                    然后将返回的数据序列化成json。
                    具体参考org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor的
                    writeWithMessageConverters方法
               (2)由于是list结构，我们添加的fastjson在最后。因此必须要将jackson的转换器删除，不然会先匹配上jackson，导致没使用fastjson
        */
        for (int i = converters.size() - 1; i >= 0; i--) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                converters.remove(i);
            }
        }
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig config = new FastJsonConfig();
        //修改配置返回内容的过滤
        config.setSerializerFeatures(
                // 保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的null转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的null转成0
                SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的null转成[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的null转成false
                SerializerFeature.WriteNullBooleanAsFalse,
                //@JSONField(format = "yyyy年MM月dd日")
                //private Date birthDay;
                //时间格式化，在实体类中添加注解自定义时间格式
                SerializerFeature.WriteDateUseDateFormat,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));

        // 添加支持的MediaTypes;不添加时默认为*/*,也就是默认支持全部
        // 但是MappingJackson2HttpMessageConverter里面支持的MediaTypes为application/json
        // 参考它的做法, fastjson也只添加application/json的MediaType
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        //将fastjson添加到视图消息转换器列表内
        converters.add(converter);
        }
    }
