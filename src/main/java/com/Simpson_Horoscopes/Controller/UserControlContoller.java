/**
 * 
 */
package com.Simpson_Horoscopes.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
@RestController
@RequestMapping("/api")
public class UserControlContoller {
  @ResponseBody
  @PostMapping("/logout")
  public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
      return new ResponseEntity<String>("Logout Successfully", HttpStatus.OK);
    }
    return new ResponseEntity<String>("Logout Error", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
