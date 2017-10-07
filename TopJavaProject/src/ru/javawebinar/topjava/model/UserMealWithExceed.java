package ru.javawebinar.topjava.model;

public class UserMealWithExceed {

	private final UserMeal userMeal;
	private final boolean exceed;

	public UserMealWithExceed(UserMeal userMeal, boolean exceed) {
		this.userMeal = userMeal;
		this.exceed = exceed;
	}

	@Override
	public String toString() {
		return "UserMealWithExceed [userMeal=" + userMeal + ", exceed=" + exceed + "]";
	}
}
