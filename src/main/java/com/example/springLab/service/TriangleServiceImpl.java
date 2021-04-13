package com.example.springLab.service;

import com.example.springLab.classes.ResultOfTriangle;
import com.example.springLab.classes.Triangle;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@AllArgsConstructor
public class TriangleServiceImpl implements TriangleService {

    private final Logger logger = LoggerFactory.getLogger(TriangleServiceImpl.class);
    private final AppealsCounter appealsCounter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);



    public ResultOfTriangle calculate(Triangle triangle) throws InterruptedException {

        executorService.submit(appealsCounter);
        if (triangle.checkingTriangle()) {

            logger.info( Thread.currentThread().getName() + ". Perimeter and square have been calculate SUCCESSFULLY");
            return new ResultOfTriangle(
                    true,
                    triangle.findPerimeter(),
                    triangle.findSquare()

            );

        } else {
            logger.error("ERROR. Triangle doesn't exist!");
            return new ResultOfTriangle(
                    false,
                    0,
                    0
            );
        }

    }
}
