package by.bsuir;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {
	
	//Максимальное число из массива
	@RequestMapping(value="/Lab5_maxNumber", method=RequestMethod.POST)
	@ResponseBody
    public int maxInt(@RequestBody List<Integer> values) {
		return values.stream()
				.max(Comparator.comparing(Integer::intValue))
                		.get();
	}
	
	//Есть две коллекции с целочисленными элементами. Одну из них изменить таким образом, 
	//чтобы содержала поэлементную сумму, вторую – поэлементную разность.
	@RequestMapping(value="/Lab6_addAndSubract", method=RequestMethod.POST)
	@ResponseBody
	 public List<Integer> reducingByElement(@RequestBody List<Integer> firstList, List<Integer> secondList) {
		List<Integer> result = new ArrayList<Integer>();
		
		result.add(firstList.stream()
					.mapToInt(Integer::intValue)
					.sum()); 
		
		result.add(secondList.stream()
				  	.reduce(0, (a, b) -> a - b));
		
		return result;
	}
	
	//Преобразовать массив строк в массив чисел
	@RequestMapping(value="/Lab6_strToInt", method=RequestMethod.POST)
	@ResponseBody
	 public List<Integer> stringToInt(@RequestBody List<String> list) {
		return list.stream()
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
							
	}
	
	//Найти строку с максимальной длиной
	@RequestMapping(value="/Lab6_maxLength", method=RequestMethod.POST)
	@ResponseBody
	 public String maxString(@RequestBody List<String> list) {
		return list.stream()
				.max(Comparator.comparing(String::length))
                		.get();
							
	}
}
