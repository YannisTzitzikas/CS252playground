/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontistirio0608Grafika.mvcCalculator;

/**
 *
 * @author micha
 */
// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class CalculatorModel {

	// Holds the value of the sum of the numbers
	// entered in the view
	
	private int calculationValue;
	
	public void addTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber + secondNumber;
		
	}
	
	public int getCalculationValue(){
		
		return calculationValue;
		
	}
	
}
