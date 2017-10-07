package ru.javawebinar.topjava.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

public class UserMealsUtil {

	public static void main(String[] args) {
		List<UserMeal> mealList = Arrays.asList(
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
		getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000).forEach(System.out::println);
	}

	public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime,
			LocalTime endTime, int caloriesPerDay) {
		List<UserMealWithExceed> result = new ArrayList<>();
		for (UserMeal meal1 : mealList) {
			if (TimeUtil.isBetween(meal1.getDateTime().toLocalTime(), startTime, endTime)) {
				int sumCalories = 0;
				for (UserMeal meal2 : mealList) {
					if (Objects.equals(meal1.getDateTime().toLocalDate(), meal2.getDateTime().toLocalDate())) {
						sumCalories += meal2.getCalories();
					}
				}
				result.add(new UserMealWithExceed(meal1, sumCalories > caloriesPerDay));
			}
		}
		return result;
	}
}
