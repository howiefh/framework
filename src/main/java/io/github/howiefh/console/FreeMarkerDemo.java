package io.github.howiefh.console;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.*;

import java.util.*;
import java.io.*;


public class FreeMarkerDemo {
	public static void main(String[] args) throws Exception {
		/* 在整个应用的生命周期中，这个工作你应该只做一次。 */
		/* 创建和调整配置。 */
		Configuration cfg = new Configuration();
		File file = new File("templates");
		cfg.setDirectoryForTemplateLoading(file);
		// cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setObjectWrapper(new BeansWrapper());
		cfg.setTemplateExceptionHandler(new MyTemplateExceptionHandler());
		/* 在整个应用的生命周期中，这个工作你可以执行多次 */
		/* 获取或创建模板 */
		Template temp = cfg.getTemplate("test.ftl");

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
		TemplateHashModel staticModels = wrapper.getStaticModels();
		TemplateHashModel fileStatics = (TemplateHashModel) staticModels
				.get("java.io.File");
		/* 创建数据模型 */
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("user", "王五");
		root.put("html", "<div>haha</div>");
		root.put("File", fileStatics);
		root.put("date", new Date());
		root.put("enums", BeansWrapper.getDefaultInstance().getEnumModels());
		root.put("person", new Person(1, "Jack"));
		root.put("test", new Test("Tom"));
		root.put("indexOf", new IndexOfMethod());
		root.put("upper", new UpperDirective());
		root.put("doc", freemarker.ext.dom.NodeModel.parse(new File("templates/test.xml")));
		Map<String, String> latest = new HashMap<String, String>();
		root.put("latestProduct", latest);
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");
		/* 将模板和数据模型合并 */
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);
		out.flush();
	}

	public static class Test {
		private String name;

		public Test(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}

class MyTemplateExceptionHandler implements TemplateExceptionHandler {
	public void handleTemplateException(TemplateException te, Environment env,
			java.io.Writer out) throws TemplateException {
		try {
			out.write("[ERROR: " + te.getMessage() + "]");
		} catch (IOException e) {
			throw new TemplateException("Failed to print error message. Cause: " + e, env);
		}
	}
}

class IndexOfMethod implements TemplateMethodModelEx{
	public TemplateModel exec(List args) throws TemplateModelException {
		if (args.size() != 2) {
			throw new TemplateModelException("Wrong arguments");
		}
		String str = args.get(1).toString();
		String kStr = args.get(0).toString();
		return new SimpleNumber(str.indexOf(kStr));
	}
}

/**
 * FreeMarker 的用户自定义指令在逐步改变 它嵌套内容的输出转换为大写形式
 * <p>
 * <b>指令内容</b>
 * </p>
 * <p>
 * 指令参数：无
 * <p>
 * 循环变量：无
 * <p>
 * 指令嵌套内容：是
 */
class UpperDirective implements TemplateDirectiveModel {
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 检查参数是否传入
		if (!params.isEmpty()) {
			throw new TemplateModelException(
					"This directive doesn't allow parameters.");
		}
		if (loopVars.length != 0) {
			throw new TemplateModelException(
					"This directive doesn't allow loop variables.");
		}
		// 是否有非空的嵌入内容
		if (body != null) {
			// 执行嵌入体部分，和 FTL 中的<#nested>一样，除了
			// 我们使用我们自己的 writer 来代替当前的 output writer.
			body.render(new UpperCaseFilterWriter(env.getOut()));
		} else {
			throw new RuntimeException("missing body");
		}
	}

	/**
	 * {@link Writer}改变字符流到大写形式， 而且把它发送到另外一个{@link Writer}中。
	 */
	private static class UpperCaseFilterWriter extends Writer {
		private final Writer out;

		UpperCaseFilterWriter(Writer out) {
			this.out = out;
		}

		public void write(char[] cbuf, int off, int len) throws IOException {
			char[] transformedCbuf = new char[len];
			for (int i = 0; i < len; i++) {
				transformedCbuf[i] = Character.toUpperCase(cbuf[i + off]);
			}
			out.write(transformedCbuf);
		}

		public void flush() throws IOException {
			out.flush();
		}

		public void close() throws IOException {
			out.close();
		}
	}
}
