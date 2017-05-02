CREATE OR REPLACE TYPE BODY PBDM_Personne_Type AS
	INSTANTIABLE FINAL MEMBER FUNCTION afficheP RETURN VARCHAR2 IS 
	retour VARCHAR2(500);
	dateNaiss VARCHAR2(25);
	nom VARCHAR2(25);
	prenom PBDM_Prenom_Type;
	begin
		prenom:=self.prenoms(1);
		retour:=retour||prenom.prenom;
		DBMS_OUTPUT.PUT_LINE(retour);
		prenom:=self.prenoms(2);
		retour:=retour||prenom.prenom;
		prenom:=self.prenoms(3);
		retour:=retour||prenom.prenom;
		nom:=self.nom;
		retour := retour||nom;
		dateNaiss:=self.dateNaiss;
		retour := retour||dateNaiss;
	return retour;
	end afficheP;
	INSTANTIABLE NOT FINAL MEMBER FUNCTION affiche RETURN VARCHAR2 IS
	begin
		return self.afficheP;
	end affiche;
END;
/
CREATE OR REPLACE TYPE BODY PBDM_Acteur_Type AS
	MEMBER FUNCTION afficheA RETURN VARCHAR2 IS
	retour VARCHAR2(500);	
	begin
		retour:=self.afficheP;
	end afficheA;
	OVERRIDING MEMBER FUNCTION affiche RETURN VARCHAR2 IS
	retour VARCHAR2(525);
	begin
		retour:=self.afficheA;
		retour:=retour||self.taille;
	end affiche;
END;
/

