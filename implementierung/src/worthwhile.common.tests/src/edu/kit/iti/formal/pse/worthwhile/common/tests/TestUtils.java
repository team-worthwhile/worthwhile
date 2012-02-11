package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Some utilities for unit testing.
 * 
 * @author Joachim
 * 
 */
public final class TestUtils {

	/**
	 * Loads a test program from a resource.
	 * 
	 * @param resourceClass
	 *                The class from which to get the resource
	 * @param fileName
	 *                The file name
	 * @return The test program as a String
	 * @throws IOException
	 *                 if the file failed to load.
	 */
	public static String loadTestProgram(final Class<?> resourceClass, final String fileName) throws IOException {
		InputStream stream = resourceClass.getResourceAsStream("/" + fileName);

		if (stream == null) {
			throw new IOException("Cannot find file: " + fileName);
		}

		return new Scanner(stream).useDelimiter("\\A").next();
	}

	/**
	 * Private constructor to prevent instantiation.
	 */
	private TestUtils() {
	}

}
