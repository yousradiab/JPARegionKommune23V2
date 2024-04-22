package com.example.jparegionkommune23v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(path = "exp/")
public class ExceptController {

    @GetMapping("/")
    public String hello() {
        return "hej";

    }

    @GetMapping("/file2/{filename}")
    public String getFile2(@PathVariable String filename) {
        String fileContent = "x";
        try {
            FileInputStream fs = new FileInputStream("c:/AFile/" + filename);
            try {
                byte[] bytes = fs.readAllBytes();
                fileContent = new String(bytes);
            } catch (IOException io) {
                fs.close();
            }
            System.out.println(fileContent);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
        return fileContent;
    }

    @GetMapping("/div2/{divnum}")
    public int getdivnum2(@PathVariable int divnum) {
        int i1 = 0;
        try {
            i1 = 100 / divnum;
        } catch (ArithmeticException ae) {
            System.out.println("du dividerede med 0 " + ae.getMessage());
        }
        return i1;
    }

    @GetMapping("/div/{divnum}")
    public int getdivnum(@PathVariable int divnum) {
        int i1 = 100 / divnum;
        return i1;
    }

    @GetMapping("/loop/{loopnum}")
    public int getloop(@PathVariable int loopnum) {
        int x = 0;
        for (int i = 0; i<loopnum; i++) {
            x++;
        }
        return x;
    }


}
