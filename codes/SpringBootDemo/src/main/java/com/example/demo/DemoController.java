package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // works for @Controller and @ResponseBody
//@RequestMapping(value="/demo")
public class DemoController {
	
	@GetMapping(value="/name",produces="Application/json")
	public String getName() {
		
		return "Devarshi Patidar";
	}

}
