package TME7;

import javax.ejb.Remote;


@Remote
public interface SessionCalcItf extends CalcItf {

  public double add(double d);

  public double sub(double d);

  public double mult(double d);

  public double div(double d) throws DivByZeroException;

  public void eraseMemory();

  public void killSession();

}
