package by.bsuir;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MaxController {
	
	@RequestMapping(value="/Max", method=RequestMethod.POST)
	@ResponseBody
    public int compare(@RequestBody int[] values) {
		FindMax comparator = new FindMax();
		int result = comparator.compare(values);
		return result;
    }
}