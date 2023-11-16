package br.com.api.service.mathservice;

import org.springframework.stereotype.Service;

import br.com.api.exception.UnsupportedMathOperationException;
import br.com.api.utils.MathUtils;

@Service
public class MathServiceSquareRoot {

	public Double sqrt(String strNumber) throws Exception {
		if (!MathUtils.isNumeric(strNumber)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		if (0D > MathUtils.convertToDouble(strNumber)) {
			throw new UnsupportedMathOperationException("Please inform a number equal or greater then zero!");
		}

		return Math.sqrt(MathUtils.convertToDouble(strNumber));

	}

}
