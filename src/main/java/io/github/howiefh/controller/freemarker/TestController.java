package io.github.howiefh.controller.freemarker;

import io.github.howiefh.service.freemarker.Exercises;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	//http://localhost/test/4/if/testIf
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/test/{folder}/{file}/{methodName}")
	public String test(@PathVariable("folder") String folder, @PathVariable("file") String file,
			@PathVariable("methodName") String methodName, Model model) throws Exception {
		
		if (StringUtils.isNotBlank(methodName) && !"null".equals(methodName)) {
			Exercises exercises = new Exercises();
			Class clazz = exercises.getClass();
			Method method = clazz.getMethod(methodName, Model.class);
			method.invoke(exercises, model);
		}
		return folder + "/" + file;
	}
}
