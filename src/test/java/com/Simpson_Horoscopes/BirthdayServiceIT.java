/**
 * 
 */
package com.Simpson_Horoscopes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.Simpson_Horoscopes.Controller.SimpsonHoroscopesContoller;
import com.Simpson_Horoscopes.Service.BirthdayService;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
@ContextConfiguration(classes = {SimpsonHoroscopesContoller.class, BirthdayService.class})
@AutoConfigureMockMvc
@WebMvcTest
class BirthdayServiceIT {
  private static final String test_user = "admin123";
  @Autowired
  MockMvc mockmvc;
  String bd1 = LocalDate.of(1979, 7, 14).format(DateTimeFormatter.ISO_DATE);
  String bd2 = LocalDate.of(2018, 1, 23).format(DateTimeFormatter.ISO_DATE);
  String bd3 = LocalDate.of(1972, 3, 17).format(DateTimeFormatter.ISO_DATE);
  String bd4 = LocalDate.of(1945, 12, 2).format(DateTimeFormatter.ISO_DATE);
  String bd5 = LocalDate.of(2003, 8, 4).format(DateTimeFormatter.ISO_DATE);

  @Test
  void testGetBirt_day() {
    testGetBirth_day(bd1, "SATURDAY");
    testGetBirth_day(bd2, "TUESDAY");
    testGetBirth_day(bd3, "FRIDAY");
    testGetBirth_day(bd4, "SUNDAY");
    testGetBirth_day(bd5, "MONDAY");
  }

  @Test
  void testPostChineseZodiacSign() {
    testPostChineseZodiacSign(bd1, "Sheep");
    testPostChineseZodiacSign(bd2, "Dog");
    testPostChineseZodiacSign(bd3, "Rat");
    testPostChineseZodiacSign(bd4, "Rooster");
    testPostChineseZodiacSign(bd5, "Sheep");
  }

  @Test
  void testPostStarSign() {
    testPostStarSign(bd1, "Cancer");
    testPostStarSign(bd2, "Aquarius");
    testPostStarSign(bd3, "Pisces");
    testPostStarSign(bd4, "Sagittarius");
    testPostStarSign(bd5, "Leo");
  }

  private void testGetBirth_day(String birthdayString, String expectedResult) {
    try {
      MvcResult mvcr = mockmvc.perform(MockMvcRequestBuilders.get("/api/birthday/day")
          .with(user(test_user)).with(csrf()).content(birthdayString)
          .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk()).andReturn();
      String result = mvcr.getResponse().getContentAsString();
      assertNotNull(result);
      assertEquals(result, expectedResult);
    } catch (Exception e) {
      e.getMessage();
    }
  }

  private void testPostChineseZodiacSign(String birthday, String actualResult) {
    try {
      MvcResult mvcr =
          mockmvc
              .perform(MockMvcRequestBuilders.post("/api/birthday/chineseZodiac")
                  .with(user(test_user)).with(csrf()).content(birthday)
                  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk()).andReturn();
      String result = mvcr.getResponse().getContentAsString();
      assertNotNull(result);
      assertEquals(result, actualResult);
    } catch (Exception e) {
      e.getMessage();
    }
  }

  private void testPostStarSign(String birthday, String actualResult) {
    try {
      MvcResult mvcr = mockmvc.perform(MockMvcRequestBuilders.post("/api/birthday/starSign")
          .with(user(test_user)).with(csrf()).content(birthday)
          .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk()).andReturn();
      String result = mvcr.getResponse().getContentAsString();
      assertNotNull(result);
      assertEquals(result, actualResult);
    } catch (Exception e) {
      e.getMessage();
    }
  }
}
