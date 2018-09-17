package com.epam.esauto.util;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ApiSaxParser extends org.xml.sax.helpers.DefaultHandler {
	private static final String LINK = "link";
	private static final String ATTR = "rel";
	private static final String VALUE_ATTR = "alternate";
	private static final String VALUE_HREF = "href";
	private static final int TWO = 2;

	private ArrayList<String> listOfUrl = new ArrayList<>();

	public ArrayList<String> getUrls() {
		return listOfUrl;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if ((qName.equals(LINK)) && (attributes.getValue(ATTR).equals(VALUE_ATTR))) {
			listOfUrl.add(attributes.getValue(VALUE_HREF).substring(TWO));
		}
	}

	public void endElement(String uri, String localName, String qName) {
	}

	public void startDocument() {
	}

	public void endDocument() {
	}
}