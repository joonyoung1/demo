package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutRequestController {
    ArrayList<Integer> ans;

    public PutRequestController() {
        ans = new ArrayList<Integer>();
        ans.add(1);
        ans.add(2);
        ans.add(3);
    }

    @PutMapping("/change/{id}")
    void change(@PathVariable int id) {
        System.out.println(ans);
        ans.set(id, 45);
        System.out.println(ans);
    }
}
