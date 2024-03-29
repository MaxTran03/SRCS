package TME6.cache;


/**
* cache/FileSystemHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache.idl
* jeudi 24 mars 2016 17 h 10 CET
*/

abstract public class FileSystemHelper
{
  private static String  _id = "IDL:cache/FileSystem:1.0";

  public static void insert (org.omg.CORBA.Any a, FileSystem that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static FileSystem extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (FileSystemHelper.id (), "FileSystem");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static FileSystem read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_FileSystemStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, FileSystem value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static FileSystem narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof FileSystem)
      return (FileSystem)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _FileSystemStub stub = new _FileSystemStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static FileSystem unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof FileSystem)
      return (FileSystem)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _FileSystemStub stub = new _FileSystemStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
