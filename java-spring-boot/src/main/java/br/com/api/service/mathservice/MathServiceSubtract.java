package br.com.api.service.mathservice;

import org.springframework.stereotype.Service;

import br.com.api.exception.UnsupportedMathOperationException;
import br.com.api.utils.MathUtils;

@Service
public class MathServiceSubtract {

	public Double subtract(String numberOne, String numberTwo) throws Exception {
		if (!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}

		return MathUtils.convertToDouble(numberOne) - MathUtils.convertToDouble(numberTwo);
	}

}