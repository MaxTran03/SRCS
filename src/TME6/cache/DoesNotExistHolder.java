package TME6.cache;

/**
* cache/DoesNotExistHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache.idl
* jeudi 24 mars 2016 17 h 10 CET
*/

public final class DoesNotExistHolder implements org.omg.CORBA.portable.Streamable
{
  public DoesNotExist value = null;

  public DoesNotExistHolder ()
  {
  }

  public DoesNotExistHolder (DoesNotExist initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DoesNotExistHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DoesNotExistHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DoesNotExistHelper.type ();
  }

}
