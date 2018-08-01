package com.trainer.utils;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

import com.trainer.dto.BaseDto;

public class FilterUtils {

	public static <T extends BaseDto>  void filter(Collection<T> dtos, Integer coachId) {
		CollectionUtils.filter(dtos, new org.apache.commons.collections4.Predicate<T>(){

			@Override
			public boolean evaluate(T object) {
				return object.getCoachId() == coachId;
			}
		});
	}
}
