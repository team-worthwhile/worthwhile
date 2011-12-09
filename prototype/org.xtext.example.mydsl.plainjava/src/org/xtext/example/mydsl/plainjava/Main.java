package org.xtext.example.mydsl.plainjava;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.xtext.example.mydsl.MyDslStandaloneSetup;

import com.google.inject.Injector;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello there! Loading required packages ...");
		
		String testString = "Integer a:= 4\nInteger b := 10\nwhle(a < b) {\na := a + 1\n}\n";
		Injector guiceInjector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		IParser parser = guiceInjector.getInstance(IParser.class);
		
		System.out.println("Parsing ...");
		IParseResult result = parser.parse(new StringReader(testString));
		
		System.out.println("Getting syntax errors ...");
		Iterable<INode> errors = result.getSyntaxErrors();
		EObject root = result.getRootASTElement();
		
		System.out.println("Finished parsing. Here are the results:");
		for(INode singleError : errors) {
			System.out.println("Error: " + singleError.getSyntaxErrorMessage().getMessage());
			System.out.println("Line " + singleError.getStartLine() + ", Offset " + singleError.getOffset());
		}
	}

}
