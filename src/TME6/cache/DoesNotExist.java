package TME6.cache;


/**
* cache/DoesNotExist.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache.idl
* jeudi 24 mars 2016 17 h 10 CET
*/

public final class DoesNotExist extends org.omg.CORBA.UserException
{
  public String r = null;

  public DoesNotExist ()
  {
    super(DoesNotExistHelper.id());
  } // ctor

  public DoesNotExist (String _r)
  {
    super(DoesNotExistHelper.id());
    r = _r;
  } // ctor


  public DoesNotExist (String $reason, String _r)
  {
    super(DoesNotExistHelper.id() + "  " + $reason);
    r = _r;
  } // ctor

} // class DoesNotExist
