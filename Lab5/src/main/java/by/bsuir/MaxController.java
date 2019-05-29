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
public class MaxController {
	
	@RequestMapping(value="/Lab5_maxnumber", method=RequestMethod.POST)
	@ResponseBody
    public int compare(@RequestBody List<Integer> values) {
	
		return values.stream()
				.max(Comparator.comparing(Integer::valueOf))
                .get();
		/*
		int maxValue = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > maxValue) 
				maxValue = values[i];
		}	
        return maxValue;
    }
    */
	}
}