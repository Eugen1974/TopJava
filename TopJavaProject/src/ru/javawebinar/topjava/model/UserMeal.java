package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

import ru.javawebinar.topjava.util.TimeUtil;

public class UserMeal {

	private final LocalDateTime dateTime;
	private final String description;
	private final int calories;

	public UserMeal(LocalDateTime dateTime, String description, int calories) {
		this.dateTime = dateTime;
		this.description = description;
		this.calories = calories;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}

	public int getCalories() {
		return calories;
	}

	@Override
	public String toString() {
		return "UserMeal [dateTime=" + dateTime.format(TimeUtil.PATTERN_1) + ", description=" + description
				+ ", calories=" + calories + "]";
	}
}