package br.com.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.service.mathservice.MathServiceAverage;
import br.com.api.service.mathservice.MathServiceDivide;
import br.com.api.service.mathservice.MathServiceMult;
import br.com.api.service.mathservice.MathServiceSquareRoot;
import br.com.api.service.mathservice.MathServiceSubtract;
import br.com.api.service.mathservice.MathServiceSum;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/math")
@RequiredArgsConstructor
public class MathController {

	private final AtomicLong counter = new AtomicLong();

	private final MathServiceSum serviceSum;
	private final MathServiceSubtract serviceSubtract;
	private final MathServiceMult serviceMult;
	private final MathServiceDivide serviceDivide;
	private final MathServiceSquareRoot serviceSquareRoot;
	private final MathServiceAverage serviceAverage;

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) throws Exception {
		return serviceSum.sum(numberOne, numberTwo);

	}

	@GetMapping("/subtract/{numberOne}/{numberTwo}")
	public Double subtract(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) throws Exception {
		return serviceSubtract.subtract(numberOne, numberTwo);

	}

	@GetMapping("/divide/{numberOne}/{numberTwo}")
	public Double divide(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) throws Exception {
		return serviceDivide.divide(numberOne, numberTwo);

	}

	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) throws Exception {
		return serviceMult.mult(numberOne, numberTwo);

	}

	@GetMapping("/average/{numberOne}/{numberTwo}")
	public Double average(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) throws Exception {
		return serviceAverage.average(numberOne, numberTwo);

	}

	@GetMapping("/sqrt/{number}")
	public Double sqrt(@PathVariable(name = "number") String number) throws Exception {
		return serviceSquareRoot.sqrt(number);

	}

}
