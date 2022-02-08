package com.mcmurray.springweatherapi.controller;

/**
 * Represents a token. Useful so tokens can be verified which would be helpful if tokens had more
 * strict requirements.
 */
public class Token {
  private final String value;

  public Token(String value) {
    this.value = value;
  }

  /**
   * Determines if the token is valid (20 characters in length).
   * @return If the token is valid, return true, otherwise return false
   */
  public boolean isValid() {
    return this.value.length() == 20;
  }
}
