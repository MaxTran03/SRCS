package TME5.Calculatrice;

/**
* Calculatrice/CalculateurHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculatrice.idl
* jeudi 17 mars 2016 17 h 09 CET
*/

public final class CalculateurHolder implements org.omg.CORBA.portable.Streamable
{
  public Calculateur value = null;

  public CalculateurHolder ()
  {
  }

  public CalculateurHolder (Calculateur initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculateurHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculateurHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculateurHelper.type ();
  }

}
