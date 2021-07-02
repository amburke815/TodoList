package model;

public class Utils {

  public static <Z> Z checkNotNull(Z toCheck, String toThrow) {
    if (toCheck == null) {
      throw new IllegalArgumentException(toThrow);
    }

    return toCheck;
  }

  public static <Z> Z constructorNotNull(Z toCheck, String nameOfClass, String nameOfArgument) {
    return checkNotNull(toCheck,
        "Cannot construct a " + nameOfClass + "with a null " + nameOfArgument);
  }


  public static int checkIntBetween(int toCheck, int lowerBoundIncl, int upperBoundIncl) {
    if (lowerBoundIncl > upperBoundIncl) {
      throw new IllegalArgumentException("lower bound must be lower or equal to higher bound");
    }

    if (toCheck < lowerBoundIncl || toCheck > upperBoundIncl) {
      throw new IllegalArgumentException("Bounding error: " + toCheck + " must be in the inclusive "
          + "range [" + lowerBoundIncl + "," + upperBoundIncl + "].");
    }

    return toCheck;
  }

}
