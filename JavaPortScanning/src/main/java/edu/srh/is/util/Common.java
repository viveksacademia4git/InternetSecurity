package edu.srh.is.util;

/**
 * Utility for common functionalities.
 * 
 * @author Vivek Yadav
 */
public final class Common {

	private Common() {}


	/**
	 * Appends the two string objects
	 * @param obj1 {@link Object}
	 * @param obj2 {@link Object}
	 * @return strAppended {@link String}
	 */
	public static String append(Object obj1, Object obj2) {
		return new StringBuilder().append(obj1).append(obj2).toString();
	}


	/**
	 * Appends the three string objects
	 * @param obj1 {@link Object}
	 * @param obj2 {@link Object}
	 * @param obj3 {@link Object}
	 * @return strAppended {@link String}
	 */
	public static String append(Object obj1, Object obj2, Object obj3) {
		return new StringBuilder().append(obj1).append(obj2).append(obj3).toString();
	}


	/**
	 * Appends the four string objects
	 * @param obj1 {@link Object}
	 * @param obj2 {@link Object}
	 * @param obj3 {@link Object}
	 * @param obj4 {@link Object}
	 * @return strAppended {@link String}
	 */
	public static String append(Object obj1, Object obj2, Object obj3, Object obj4) {
		return new StringBuilder().append(obj1).append(obj2).append(obj3).append(obj4).toString();
	}


	/**
	 * Appends the four string objects
	 * @param obj... {@link Object}
	 * @return strAppended {@link String}
	 */
	public static String append(Object...objs) {
		StringBuilder sb = new StringBuilder();
		if(objs==null) {
			return "";
		}
		int len = objs.length;
		if(len==0) {
			return "";
		}
		for(int i=0; i<len; i++) {
			sb.append(objs[i]);
		}
		return sb.toString();
	}


	/**
	 * Checks the range of the given integer falls between the minimum and maximum integers. 
	 * @param min {@linkplain int}
	 * @param num {@linkplain int}
	 * @param max {@linkplain int}
	 * @return rangeCheckFlag {@linkplain boolean}
	 */
	public static boolean range(int min, int num, int max) {
		return min<=num && num<=max;
	}


	/**
	 * Checks the range of the given floating number falls between <br/>
	 * the minimum and maximum double floating numbers. 
	 * @param min {@linkplain float}
	 * @param num {@linkplain float}
	 * @param max {@linkplain float}
	 * @return rangeCheckFlag {@linkplain boolean}
	 */
	public static boolean range(float min, float num, float max) {
		return min<=num && num<=max;
	}


	/**
	 * Checks the range of the given double floating number falls <br/>
	 * between the minimum and maximum double floating numbers. 
	 * @param min {@linkplain double}
	 * @param num {@linkplain double}
	 * @param max {@linkplain double}
	 * @return rangeCheckFlag {@linkplain boolean}
	 */
	public static boolean range(double min, double num, double max) {
		return min<=num && num<=max;
	}


	/**
	 * Returns true if the given object is null or blank
	 * @param obj {@link Object}
	 * @return result {@linkplain boolean}
	 */
	public static boolean nullOrEmpty(Object obj) {
		return obj==null || "".equals(obj.toString());
	}


	/**
	 * Returns true if the given object is null or blank (after trim)
	 * @param obj {@link Object}
	 * @return result {@linkplain boolean}
	 */
	public static boolean nullOrEmptyTrim(Object obj) {
		return obj==null || "".equals(obj.toString().trim());
	}


	/**
	 * Returns true if the given object is not an integer
	 * @param String {@link String}
	 * @return isNaN {@linkplain boolean}
	 */
	public static boolean isNaN(String str) {
		if(str==null || "".equals(str.trim()))
			return true;
		return !str.matches("-?(0|[1-9]\\d*)");
	}


	/**
	 * Returns true if the given object is not an integer
	 * @param String {@link String}
	 * @return isNumber {@linkplain boolean}
	 */
	public static boolean isPositiveNumber(String str) {
		if(str==null || "".equals(str.trim()))
			return false;
		return str.matches("(0|[1-9]\\d*)");
	}

}
