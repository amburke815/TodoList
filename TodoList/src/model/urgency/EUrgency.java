package model.urgency;

import java.awt.Color;
import model.Utils;

public enum EUrgency {
  LOW(Color.GREEN), MEDIUM(Color.YELLOW), HIGH(Color.RED), OVERDUE(Color.BLACK);

  private final Color color;
  private EUrgency(Color color) {
    this.color = Utils.constructorNotNull(color, "EUrgency", "color");
  }
}
