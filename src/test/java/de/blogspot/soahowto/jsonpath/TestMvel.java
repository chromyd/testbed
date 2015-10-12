package de.blogspot.soahowto.jsonpath;

import com.jayway.jsonpath.JsonPath;
import org.junit.Ignore;
import org.junit.Test;
import org.mvel2.MVEL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMvel {
	@Test
	public void hello() {
		MVEL.eval("System.out.println('Hello, world');");
	}

	@Test
	public void testFooks() {
		final String json = "[{loso:1, pength: \"abc\"},{loso:2, pength: \"def\"}]";
		List<Map<String,Object>> fooks = JsonPath.parse(json).read("$");

		Map<String, Object> vars = new HashMap();
		vars.put("fooks", fooks);
		MVEL.eval("System.out.println('1st loso: ' + fooks[0].loso + ' pength: ' + fooks[0].pength);", vars);
		MVEL.eval("System.out.println('2nd loso: ' + fooks[1].loso + ' pength: ' + fooks[1].pength);", vars);
	}

	@Test
	@Ignore
	public void jsonPath() {
		String mvelSource = "import com.jayway.jsonpath.JsonPath;\n"
				+ "import java.util.List;\n"
				+ "fooks = JsonPath.parse(json).read('$', List.class);\n"
				+ "System.out.println('first: ' + fooks[0].loso);\n";
		final String json = "[{loso:1, pength: \"abc\"},{loso:2, pength: \"def\"}]";
		Map<String, Object> fook = new HashMap();
		fook.put("loso", 55);
		List<Map<String,Object>> fooks = new ArrayList();
		fooks.add(fook);

		Map<String, Object> vars = new HashMap();
		//vars.put("fooks", fooks);
		vars.put("json", json);
		MVEL.eval(mvelSource, vars);
	}
}
