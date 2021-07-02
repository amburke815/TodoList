package model.date;

import javax.swing.JCheckBox;
import model.Utils;
import model.todolistitem.TodoListItem;

public class TodoDate {
  private static final int THIS_YEAR = 2021;
  private static final int MIDNIGHT = 12;

  private final int year;
  private final int month;
  private final int day;
  private final int hour;
  private final int minute;
  private final boolean isAM;

  /**
   * Sets the time to midnight (the first minute of that day)
   * @param month
   * @param day
   */
  public TodoDate(int month, int day) {
    this.year = THIS_YEAR;
    this.month = Utils.checkIntBetween(month, 1, 12);
    this.day = Utils.checkIntBetween(day, 1, 31);
    this.hour = MIDNIGHT;
    this.minute = 0;
    this.isAM = true;
  }

  // TODO: add more constructors, possibly a builder


}
