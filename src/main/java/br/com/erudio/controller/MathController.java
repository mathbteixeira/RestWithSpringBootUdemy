package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.util.math.MathUtils;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		MathUtils.validateNumbers(numberOne, numberTwo);
		Double sum = MathUtils.performMathOperation(numberOne, numberTwo, MathUtils.SUM);
		return sum;
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		MathUtils.validateNumbers(numberOne, numberTwo);
		Double sub  = MathUtils.performMathOperation(numberOne, numberTwo, MathUtils.SUB);
		return sub;
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		MathUtils.validateNumbers(numberOne, numberTwo);
		Double mult  = MathUtils.performMathOperation(numberOne, numberTwo, MathUtils.MULT); 
		return mult;
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		MathUtils.validateNumbers(numberOne, numberTwo);
		Double div  = MathUtils.performMathOperation(numberOne, numberTwo, MathUtils.DIV);
		return div;
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		MathUtils.validateNumbers(numberOne, numberTwo);
		Double mean  = MathUtils.performMathOperation(numberOne, numberTwo, MathUtils.MEAN); 
		return mean;
	}
	
	@RequestMapping(value = "/square/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		MathUtils.validateNumber(number);
		Double squareRoot = MathUtils.performMathOperation(number, null, MathUtils.SQRT); 
		return squareRoot;
	}

}