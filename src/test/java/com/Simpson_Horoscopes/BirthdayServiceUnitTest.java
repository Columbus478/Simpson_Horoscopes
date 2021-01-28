/**
 * 
 */
package com.Simpson_Horoscopes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.Simpson_Horoscopes.Service.BirthdayService;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
public class BirthdayServiceUnitTest {
  BirthdayService birthdayService = new BirthdayService();

  @Test
  void testGetBirthdayWeek() {
    String BDW = birthdayService.getBirthWeek(LocalDate.of(1979, 7, 14));
    assertEquals("SATURDAY", BDW);
    BDW = birthdayService.getBirthWeek(LocalDate.of(2018, 1, 23));
    assertEquals("TUESDAY", BDW);
    BDW = birthdayService.getBirthWeek(LocalDate.of(1972, 3, 17));
    assertEquals("FRIDAY", BDW);
    BDW = birthdayService.getBirthWeek(LocalDate.of(1945, 12, 2));
    assertEquals("SUNDAY", BDW);
    BDW = birthdayService.getBirthWeek(LocalDate.of(2003, 8, 4));
    assertEquals("MONDAY", BDW);
  }

  @Test
  void testgetChineseZodiac() {
    String BDW = birthdayService.getChineseZodiac(LocalDate.of(1979, 7, 14));
    assertEquals("Sheep", BDW);
    BDW = birthdayService.getChineseZodiac(LocalDate.of(2018, 1, 23));
    assertEquals("Dog", BDW);
    BDW = birthdayService.getChineseZodiac(LocalDate.of(1972, 3, 17));
    assertEquals("Rat", BDW);
    BDW = birthdayService.getChineseZodiac(LocalDate.of(1945, 12, 2));
    assertEquals("Rooster", BDW);
    BDW = birthdayService.getChineseZodiac(LocalDate.of(2003, 8, 4));
    assertEquals("Sheep", BDW);
    BDW = birthdayService.getChineseZodiac(LocalDate.of(1990, 11, 7));
    assertEquals("Horse", BDW);
  }

  @Test
  void testGetBirthStarSign() {
    String BDW = birthdayService.getStarSign(LocalDate.of(1990, 11, 7));
    assertEquals("Scorpio", BDW);
    BDW = birthdayService.getStarSign(LocalDate.of(1979, 7, 14));
    assertEquals("Cancer", BDW);
    BDW = birthdayService.getStarSign(LocalDate.of(2018, 1, 23));
    assertEquals("Aquarius", BDW);
    BDW = birthdayService.getStarSign(LocalDate.of(1972, 3, 17));
    assertEquals("Pisces", BDW);
    BDW = birthdayService.getStarSign(LocalDate.of(1945, 12, 2));
    assertEquals("Sagittarius", BDW);
    BDW = birthdayService.getStarSign(LocalDate.of(2003, 8, 4));
    assertEquals("Leo", BDW);
  }

}
