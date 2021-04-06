package com.example.springLab.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class AppealsCounter {

    private int counter;

    public AppealsCounter(){
        this.counter = 0;
    }

    public  void addCounter(){
        this.counter++;
    }
}
