package gml4u.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

public class JDomParsingUtils {

	private static final Logger LOGGER = Logger.getLogger(JDomParsingUtils.class.getName());

	/**
	 * Builds a document based on the provided path/filename
	 * @param file - String
	 * @return Document
	 */
	public static Document buildDocument(String file) {
		try {
			SAXBuilder saxBuilder = new SAXBuilder("org.apache.xerces.parsers.SAXParser");
			Document document = saxBuilder.build(file);
			return document;
		}
		catch (IOException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		} catch (JDOMException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
	
	/**
	* Builds a document based on the provided string which contains a XML document
	* @param inputString - String
	* @return Document
	*/
	public static Document buildDocumentFromString(String inputString){
		try {
			SAXBuilder saxBuilder = new SAXBuilder("org.apache.xerces.parsers.SAXParser");
			Document document = saxBuilder.build(new StringReader(inputString));
			return document;
		}
		catch (IOException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		} catch (JDOMException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}	
	
	/**
	 * Returns a single element of node based on a document and XPath expression
	 * @param document - Document
	 * @param expression - String
	 * @return Object
	 */
	public static Object selectSingleNode(Document document, String expression) {
		try {
			Object result = XPath.selectSingleNode(document, expression);
			return result;
		}
		catch (JDOMException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}

	/**
	 * Returns a list of element or node base on a document and XPath expression
	 * @param document - Document
	 * @param expression - String
	 * @return List<?>
	 */
	public static List<?> selectNodes(Document document, String expression) {
		try {
			List<?> result = XPath.selectNodes(document, expression);
			return result;
		}
		catch (JDOMException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
}
