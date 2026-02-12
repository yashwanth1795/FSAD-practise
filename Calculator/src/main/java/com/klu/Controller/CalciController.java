package com.klu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.Service.CalciService;

@RestController
@RequestMapping("/Calculator")
public class CalciController {
	@Autowired
	public CalciService Cal;
	//addition -requestPaaram
	// URl :http://localhost:4541/Calculator/add/
	    @RequestMapping("/add")
	    public int add(@RequestParam int a, @RequestParam int b ) {
	        return Cal.add(a, b);
	    }
	    @RequestMapping("/sub")
	    public int sub(@RequestParam int a, @RequestParam int b) {
	        return Cal.sub(a, b);
	    }
	    @RequestMapping("/mul")
	    public int mul(@RequestParam int a, @RequestParam int b) {
	        return  Cal.mul(a, b);
	    }
	  //addition -PathVariable
	 // URl :http://localhost:4541/Calculator/divide/
	    @RequestMapping("/divide/{a}/{b}")
	    public int divide(@PathVariable  int a,@PathVariable int b) {

	        if (b != 0) {
	            return Cal.divide(a, b);
	        } else {
	            throw new ArithmeticException("Cannot divide by zero");
	        }
	    }
	    @RequestMapping("/rem/{a}/{b}")
	    public int rem(@PathVariable int a, @PathVariable int b) {
	    	return Cal.Rem(a,b);
	    }
	}


