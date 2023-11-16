package br.com.api.service.mathservice;

import org.springframework.stereotype.Service;

import br.com.api.exception.UnsupportedMathOperationException;
import br.com.api.utils.MathUtils;

@Service
public class MathServiceDivide {

	public Double divide(String numberOne, String numberTwo) throws Exception {
		if (!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		if (MathUtils.isZero(numberTwo)) {
			throw new UnsupportedMathOperationException("Please inform a value different from zero for numberTwo!");
		}

		return MathUtils.convertToDouble(numberOne) / MathUtils.convertToDouble(numberTwo);
	}

}
