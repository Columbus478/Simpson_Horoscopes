/**
 * 
 */
package com.Simpson_Horoscopes.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.Simpson_Horoscopes.Logics.horoscopLogic;
import com.Simpson_Horoscopes.Repository.BirthdayRepository;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
@Service
public class BirthdayService implements BirthdayRepository {
  private static final Logger logger = LogManager.getLogger(BirthdayService.class);
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public LocalDate getValidBirthday(String birthdayString) {
    if (birthdayString == null) {
      logger.info("birthday must not be empty.");
    }
    LocalDate birthday = null;
    try {
      birthday = LocalDate.parse(birthdayString, formatter);
      return birthday;
    } catch (Exception e) {
      logger.info("Must include birthday is this format: yyyy-MM-dd.\nError with:{}",
          e.getMessage());
    }
    return birthday;
  }

  @Override
  public String getBirth_Day(LocalDate birthday) {
    return birthday.getDayOfWeek().toString();
  }

  @Override
  public String getChineseZodiac(LocalDate birthday) {
    return horoscopLogic.getHoroscopAnimal(birthday);
  }

  @Override
  public String getStarSign(LocalDate birthday) {
    return horoscopLogic.getHoroscopStarSign(birthday);
  }

  @ExceptionHandler(RuntimeException.class)
  public static ResponseEntity<Exception> handleBirthdayServiceException(RuntimeException ex) {
    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);

  }

}
