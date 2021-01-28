/**
 * 
 */
package com.Simpson_Horoscopes.Logics;

import java.time.LocalDate;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
public class horoscopLogic {
  public static String getHoroscopAnimal(LocalDate birthday) {
    int year = birthday.getYear();
    switch (year % 12) {
      case 0:
        return "Monkey";
      case 1:
        return "Rooster";
      case 2:
        return "Dog";
      case 3:
        return "Pig";
      case 4:
        return "Rat";
      case 5:
        return "Ox";
      case 6:
        return "Tiger";
      case 7:
        return "Rabbit";
      case 8:
        return "Dragon";
      case 9:
        return "Snake";
      case 10:
        return "Horse";
      case 11:
        return "Sheep";
      default:
        break;
    }
    return null;
  }

  public static String getHoroscopStarSign(LocalDate birthday) {
    int day = birthday.getDayOfMonth();
    int month = birthday.getMonthValue();
    if (month == 12 && day >= 22 || month == 1 && day < 20) {
      return "Capricorn";
    } else if (month == 1 && day >= 20 || month == 2 && day < 19) {
      return "Aquarius";
    } else if (month == 2 && day >= 19 || month == 3 && day < 21) {
      return "Pisces";
    } else if (month == 3 && day >= 21 || month == 4 && day < 20) {
      return "Aries";
    } else if (month == 4 && day >= 20 || month == 5 && day < 21) {
      return "taurus";
    } else if (month == 5 && day >= 21 || month == 6 && day < 21) {
      return "Gemini";
    } else if (month == 6 && day >= 21 || month == 7 && day < 23) {
      return "Cancer";
    } else if (month == 7 && day >= 23 || month == 8 && day < 23) {
      return "Leo";
    } else if (month == 8 && day >= 23 || month == 9 && day < 23) {
      return "Virgo";
    } else if (month == 9 && day >= 23 || month == 10 && day < 23) {
      return "Libra";
    } else if (month == 10 && day >= 23 || month == 11 && day < 22) {
      return "Scorpio";
    } else if (month == 11 && day >= 22 || month == 12 && day < 22) {
      return "Sagittarius";
    }
    return "";
  }
}
