package com.sabre.hospitality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.junit.Assert;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class RestAssert {

	public static void assertHasSelfAndTemplateLinks(JsonNode linksSection,
			String expectedRequestUrl, String expectetTemplateUrl) {

		assertHasLink(linksSection.get(0),
				new Link().relation("self").url(expectedRequestUrl));
		assertHasLink(linksSection.get(1), new Link().relation("linkTemplate")
				.url(expectetTemplateUrl));
	}

	public static void assertHasSelfAndTemplateLinks(String response,
			String expectedRequestUrl, String expectetTemplateUrl)
			throws Exception {
		JsonPath self = JsonPath.compile("$.Links[?].href",
				Filter.filter(Criteria.where("rel").is("self")));
		JsonPath template = JsonPath.compile("$.Links[?].href",
				Filter.filter(Criteria.where("rel").is("linkTemplate")));

		assertValue(expectedRequestUrl, self.read(response));
		assertValue(expectetTemplateUrl, template.read(response));

	}

	public static void assertHasLink(JsonNode linkNode, Link link) {

		assertEquals(link.getRelation(), linkNode.path("rel").getTextValue());
		assertEquals(link.getUrl(), linkNode.path("href").getTextValue());
	}

	public static void assertHasLinkInLinks(ArrayNode arrayNode, Link link) {
		boolean found = false;
		StringBuilder sb = new StringBuilder();
		for (JsonNode node : arrayNode) {
			boolean relationEqual = false, hrefEqual = false;
			String rel = node.path("rel").getTextValue();
			String href = node.path("href").getTextValue();
			relationEqual = link.getRelation().equals(rel);

			hrefEqual = link.getUrl().equals(href);
			if (relationEqual && hrefEqual) {
				found = true;
				return;
			}
			sb.append(String.format("[rel=%s ,href=%s]", rel, href))
					.append(",");
		}
		assertTrue(String.format(
				"Link with rel (%s) and href (%s) not found. Founded %s",
				link.getRelation(), link.getUrl(), sb), found);

	}

	public static class Link {
		String relation;
		String url;

		public String getRelation() {
			return relation;
		}

		public Link relation(String relation) {
			this.relation = relation;
			return this;
		}

		public String getUrl() {
			return url;
		}

		public Link url(String url) {
			this.url = url;
			return this;
		}

	}

	public static void assertValue(Object expectedValue, Object actualValue)
			throws ParseException {
		if ((actualValue instanceof List) && !(expectedValue instanceof List)) {
			@SuppressWarnings("rawtypes")
			List actualValueList = (List) actualValue;
			if (actualValueList.size() == 0) {
				Assert.fail("No matching value for JSON path ");
			}
			if (actualValueList.size() != 1) {
				Assert.fail("Got a list of values " + actualValue
						+ " instead of the value " + expectedValue);
			}
			actualValue = actualValueList.get(0);
		} else if (actualValue != null && expectedValue != null) {

			assertEquals("For JSON path  type of value",
					expectedValue.getClass(), actualValue.getClass());
		}
		assertEquals("JSON path", expectedValue, actualValue);
	}
}
