package com.alt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
@Api(value = "Alticci ", description = "Rest Controller")
@RestController
@RequestMapping("/app")
public class AlticciController {

	@GetMapping("/alticci/{n}")
	public List<Integer> alticciv2(@PathVariable int n){
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 
		// condicoes iniciais
		hmap.put(0, 0); hmap.put(1, 1);	hmap.put(2, 1);	
		if(n ==0 ) {hmap.clear();hmap.put(0, 0);} // se n for zero
		if(n ==1 ) {hmap.clear();hmap.put(0, 0);hmap.put(1, 1);} // se n for 1
		if(n ==2 ) {hmap.clear();hmap.put(0, 0);hmap.put(1, 1);hmap.put(2, 1);} // se n for 2		
		if (n > 2) // se n maior que 2			
			for (int i = 3; i < n + 1; i++) {
				hmap.put(i, hmap.get(i - 3) + hmap.get(i - 2));
			}
		//devolve lista com resultados 
		return new ArrayList<Integer>(hmap.values());
	}
	

}
