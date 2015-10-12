package de.blogspot.soahowto.jsonpath;

import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestJsonPath {

	@Test
	public void testFook() {
		final String json = "[{loso:1, pength: \"abc\"},{loso:2, pength: \"def\"}]";
		Fook fook = JsonPath.parse(json).read("$[0]", Fook.class);
		Assert.assertEquals(1, fook.getLoso());
		Assert.assertEquals("abc", fook.getPength());
	}

	@Test
	public void testFooks() {
		final String json = "[{loso:1, pength: \"abc\"},{loso:2, pength: \"def\"}]";
		List<Map<String,Object>> fooks = JsonPath.parse(json).read("$");
		Map<String, Object> fook = fooks.get(1);
		Assert.assertEquals(2, fook.get("loso"));
		Assert.assertEquals("def", fook.get("pength"));
	}

}
