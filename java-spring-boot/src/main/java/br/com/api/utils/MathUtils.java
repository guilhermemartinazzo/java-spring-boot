package br.com.api.utils;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class MathUtils {

	private MathUtils() {

	}

	public static boolean isNumeric(String strNumber) {
		String number = strNumber.replaceAll(",", ".");
		return NumberUtils.isCreatable(number);
	}

	public static Double convertToDouble(String strNumber) {
		if (!StringUtils.isEmpty(strNumber)) {
			String number = strNumber.replaceAll(",", ".");
			if (isNumeric(number)) {
				return Double.parseDouble(number);
			}

		}
		return BigDecimal.ZERO.doubleValue();

	}

	public static boolean isZero(String strNumber) {
		return convertToDouble(strNumber).equals(0D);
	}
}
