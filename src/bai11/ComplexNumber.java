package bai11;

/**
 * ComplexNumber class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class ComplexNumber {
  private double real;
  private double virtual;

  public ComplexNumber(double real, double virtual) {
    this.real = real;
    this.virtual = virtual;
  }

  public double getReal() {
    return real;
  }

  public void setReal(double real) {
    this.real = real;
  }

  public double getVirtual() {
    return virtual;
  }

  public void setVirtual(double virtual) {
    this.virtual = virtual;
  }

  @Override
  public String toString() {
    return "ComplexNumber{" + real + (virtual >= 0 ? "+" : "") + virtual + "i}";
  }

  public ComplexNumber plus(ComplexNumber other) {
    return new ComplexNumber(
        this.real + other.getReal(),
        this.virtual + other.getVirtual()
    );
  }

  public ComplexNumber multiply(ComplexNumber other) {
    return new ComplexNumber(
        (this.real * other.getReal()) - (this.virtual * other.getVirtual()),
        (this.real * other.getVirtual()) - (this.virtual * other.getReal())
    );
  }
}
