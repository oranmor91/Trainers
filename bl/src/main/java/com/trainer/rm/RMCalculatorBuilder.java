package com.trainer.rm;

import com.trainer.entity.RMData;

public class RMCalculatorBuilder{

	private RMData rmData = null;
	
	private Integer result = null;
	
	private RMCalculatorBuilder(RMData rmData) {
		this.rmData = rmData;
	}
	
	public static RMCalculatorBuilder instance(RMData rmData) {
		return new RMCalculatorBuilder(rmData);
	}
	
	public RMCalculatorBuilder simpleRmCalculator() {
		result = (int) (rmData.getData() * 0.7);
		return this;
	}
	
	public RMCalculatorBuilder advanceRmCalculator() {
		result = (int) (rmData.getData() * 0.8);
		return this;
	}
	
	public Integer build() {
		return result;
	}

}
