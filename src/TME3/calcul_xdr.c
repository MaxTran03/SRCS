/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "calcul.h"

bool_t
xdr_data (XDR *xdrs, data *objp)
{
	register int32_t *buf;

	 if (!xdr_int (xdrs, &objp->c1))
		 return FALSE;
	 if (!xdr_char (xdrs, &objp->c2))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_bichaine (XDR *xdrs, bichaine *objp)
{
	register int32_t *buf;

	int i;
	 if (!xdr_vector (xdrs, (char *)objp->s1, 80,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	 if (!xdr_vector (xdrs, (char *)objp->s2, 80,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	return TRUE;
}
