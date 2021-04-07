package com.example.springLab.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

@Data
@AllArgsConstructor
@Cacheable("triangleResult")
public class ResultOfTriangle {

    final private boolean isTriangleExist;
    final private float perimeter;
    final private float square;

}
