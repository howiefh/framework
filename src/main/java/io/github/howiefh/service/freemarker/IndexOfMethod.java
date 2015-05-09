package io.github.howiefh.service.freemarker;

import java.util.List;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * <p>官方例子，自定义method；</p>
 * 参考：<a href="file:///F:/360/Learn/freemarker/resource/freemarker-2.3.20/documentation/_html/pgui_datamodel_method.html">pgui_datamodel_method</a>
 * @author yejq
 */
public class IndexOfMethod implements TemplateMethodModelEx {

	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List args) throws TemplateModelException {
		if (args.size() != 2) {
			throw new TemplateModelException("Wrong arguments");
		}
		for (Object object : args) {
			System.out.println(object.getClass());
		}
		return new SimpleNumber(((String)args.get(1)).indexOf((String)args.get(0)));
	}

}
