/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "calcul.h"

int cpt = 0;

int *mulpar2_1_svc(int *argp, struct svc_req *rqstp){
	static int  result;
	
	/*
	 * insert server code here
	 */
	
	result = (*argp) * 2;
	printf("La multiplication par 2 de %d donne %d\n", *argp, result);
	
	return &result;
}


void *affiche_champs_1_svc(struct data *argp, struct svc_req *rqstp){
	static char * result;

	/*
	 * insert server code here
	 */
	
	printf("La structure est composé de: %d et %c\n", argp->c1, argp->c2);
	
	return (void *) &result;
}


char **concat_1_svc(struct bichaine *argp, struct svc_req *rqstp){
	static char * result;

	/*
	 * insert server code here
	 */
	
	result = strcat(argp->s1, argp->s2);
	
	printf("La concaténation donne %s\n", result);
	
	return &result;
}


void *plusum_1_svc(void *argp, struct svc_req *rqstp){
	static char * result;

	/*
	 * insert server code here
	 */
	 
	 cpt++;
	 printf("Le compteur local est : %d\n", cpt);

	return (void *) &result;
}
