/**
 * 
 */
package com.Simpson_Horoscopes.Repository;

import java.time.LocalDate;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
public interface BirthdayRepository {
  LocalDate getValidBirthday(String birthdayString);

  String getBirth_Day(LocalDate birthday);

  String getChineseZodiac(LocalDate birthday);

  String getStarSign(LocalDate birthday);
}
