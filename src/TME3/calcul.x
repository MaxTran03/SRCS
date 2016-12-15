struct data{
	int c1;
	char c2;
};

struct bichaine{
	char s1[80];
	char s2[80];
};

program CALCUL{
	version V1{
		int mulpar2(int) = 1;
		void affiche_champs(struct data) = 2;
		string concat(struct bichaine) = 3;
		void plusum() = 4;
	} = 1;
} = 0x2134567;
