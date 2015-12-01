package org.eclipse.jgit.util;

/**
 * @author chris
 * @since 4.2
 *
 */
public class StdErrLogger {
	private String cls;

	/**
	 * @param cls
	 */
	public StdErrLogger(String cls) {
		this.cls = cls;
	}

	/**
	 * @param o
	 * @return null
	 */
	public static String o2s(Object o) {
		return ((o == null) ? "null" : o.toString());
	}

	/**
	 * @return null
	 */
	public boolean isDebugEnabled() {
		return true;
	}

	/**
	 * @param lvl
	 * @param s
	 */
	public void log(String lvl, String s) {
		System.err.println(cls + " [" + lvl + "]: " + s);
	}

	/**
	 * @param string
	 */
	public void debug(String string) {
		log("DEBUG", string);
	}

	/**
	 * @param string
	 * @param obj1
	 */
	public void debug(String string, Object obj1) {
		log("DEBUG", string.replaceFirst("\\{\\}", o2s(obj1)));
	}

	/**
	 * @param string
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 */
	public void debug(String string, Object obj1, Object obj2, Object obj3) {
		log("DEBUG",
				string.replaceFirst("\\{\\}", o2s(obj1))
						.replaceFirst("\\{\\}", o2s(obj2))
						.replaceFirst("\\{\\}", o2s(obj3)));
	}

	/**
	 * @param string
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 */
	public void debug(String string, Object obj1, Object obj2, Object obj3,
			Object obj4) {
		log("DEBUG",
				string.replaceFirst("\\{\\}", o2s(obj1))
						.replaceFirst("\\{\\}", o2s(obj2))
						.replaceFirst("\\{\\}", o2s(obj3))
						.replaceFirst("\\{\\}", o2s(obj4)));
	}
}
