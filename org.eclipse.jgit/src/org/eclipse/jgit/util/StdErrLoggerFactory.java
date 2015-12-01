package org.eclipse.jgit.util;

/**
 * @since 4.2
 */
public class StdErrLoggerFactory {
	/**
	 * @param name
	 * @return null
	 */
	public static StdErrLogger getLogger(Class name) {
		return new StdErrLogger(name.getSimpleName());
	}
}
