package com.lifegraph.team20.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
  @NotBlank
  private String email;

  @NotBlank
  private String password;

}