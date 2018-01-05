package com.qbt.common.spring.enmus;
public enum ClientTypeEnum
{
  TOUCH("1"), DESKTOP("2"), MOBILE("3");

  String value;

  private ClientTypeEnum(String value) { this.value = value; }

  public String getValue() {
    return this.value;
  }

  public static ClientTypeEnum get(String value) {
    if (value == null) {
      return null;
    }
    for (ClientTypeEnum ct : values()) {
      if (ct.value.equals(value)) {
        return ct;
      }
    }
    return null;
  }
}