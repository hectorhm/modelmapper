package com.example.appcontroller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.example.utils.MapperUtil;

/**
 * Generic mapper to DTOs.
 */
@Component("appControllerBase")
public class AppControllerBase {

    @Autowired
    MapperUtil mapperUtil;

    public <S, D> D mapTo(S source, Class<D> dest) {
        return mapperUtil.mapTo(source, dest);
    }

    public <S, D> List<D> toList(List<S> source, Type dest) {
        return mapperUtil.toList(source, dest);
    }

    public <S, D> Page<D> toPage(Page<S> source, Type dest) {
        List<D> list = mapperUtil.toList(source.getContent(), dest);
        return new PageImpl<>(list, source.getPageable(), source.getTotalElements());
    }

}