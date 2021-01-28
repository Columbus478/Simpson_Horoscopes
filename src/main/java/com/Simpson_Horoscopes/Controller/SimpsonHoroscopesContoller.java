/**

 * 
 */
package com.Simpson_Horoscopes.Controller;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.Simpson_Horoscopes.Service.BirthdayService;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
@RestController
@RequestMapping(path = "/api/birthday")
public class SimpsonHoroscopesContoller {
  private static final Logger logger = LogManager.getLogger(SimpsonHoroscopesContoller.class);
  @Autowired
  private BirthdayService birthdayService;

  @ResponseBody
  @GetMapping(path = "/day", produces = "application/json")
  public ResponseEntity<String> getBirth_Day(@RequestBody String birthdayString) {
    String response = null;
    LocalDate birthday = birthdayService.getValidBirthday(birthdayString);
    if (birthday == null) {
      logger.info("getValidBirthday returned:{}", birthday);
    } else {
      response = birthdayService.getBirth_Day(birthday);
      logger.info("SimpsonHoroscopesContoller.getBirthWeek Response body: {}", response);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(path = "/chineseZodiac", produces = "application/json")
  public ResponseEntity<String> getChineseZodiac(@RequestBody String birthdayString) {
    String response = null;
    LocalDate birthday = birthdayService.getValidBirthday(birthdayString);
    if (birthday == null) {
      logger.info("getValidBirthday returned:{}", birthday);
    } else {
      response = birthdayService.getChineseZodiac(birthday);
      logger.info("SimpsonHoroscopesContoller.getChineseZodiac Response body: {}", response);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(path = "/starSign", produces = "application/json")
  public ResponseEntity<String> getStarSign(@RequestBody String birthdayString) {
    String response = null;
    LocalDate birthday = birthdayService.getValidBirthday(birthdayString);
    if (birthday == null) {
      logger.info("getValidBirthday returned:{}", birthday);
    } else {
      response = birthdayService.getStarSign(birthday);
      logger.info("SimpsonHoroscopesContoller.getStarSign Response body: {}", response);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
