package com.trainer.utils;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.trainer.dto.Excersice;

public class FilterUtils {

	public static void filter(List<Excersice> excersices, Integer coachId) {
		CollectionUtils.filter(excersices, new org.apache.commons.collections4.Predicate<Excersice>(){

			@Override
			public boolean evaluate(Excersice object) {
				return object.getCoachId() == coachId;
			}
		});
	}
}
