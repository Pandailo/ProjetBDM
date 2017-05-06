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
CREATE OR REPLACE TYPE BODY PBDM_JeuVideo_Type AS
	MEMBER FUNCTION compareImage(idJ IN INTEGER,pond_AvgColor IN DOUBLE PRECISION, pond_colorhisto IN DOUBLE PRECISION, pond_poscol IN DOUBLE PRECISION,pond_text IN DOUBLE PRECISION) RETURN DOUBLE PRECISION IS
		Simg1 SI_StillImage;
		Simg2 SI_StillImage;
		img1 ORDImage;
		bl BLOB;
		sig SI_FeatureList;
		score DOUBLE PRECISION;
	BEGIN
		SELECT image INTO img1 FROM PBDM_JeuVideo WHERE id=idJ;
		bl:=img1.source.localData;
		Simg1:=new SI_StillImage(bl);
		bl:=self.image.source.localData;
		Simg2:=new SI_StillImage(bl);
		sig:=new SI_FeatureList(new SI_AverageColor(Simg1),pond_AvgColor,new SI_ColorHistogram(Simg1),pond_colorhisto,new SI_PositionalColor(Simg1), pond_poscol,new SI_Texture(Simg1),pond_text);
		score:=sig.SI_Score(Simg2);
		return score;
	END compareImage;
END;
/
CREATE OR REPLACE TYPE BODY PBDM_Film_Type AS 
	MEMBER FUNCTION compareImage(idF IN INTEGER) RETURN DOUBLE PRECISION IS
		Simg1 SI_StillImage;
		Simg2 SI_StillImage;
		img1 ORDImage;
		bl BLOB;
		sig SI_FeatureList;
		score DOUBLE PRECISION;
	BEGIN
		SELECT image INTO img1 FROM PBDM_Film WHERE id=idF;
		bl:=img1.source.localData;
		Simg1:=new SI_StillImage(bl);
		bl:=self.image.source.localData;
		Simg2:=new SI_StillImage(bl);
		sig:=new SI_FeatureList(new SI_AverageColor(Simg1),1.0,new SI_ColorHistogram(Simg1),1.0,new SI_PositionalColor(Simg1),1.0,new SI_Texture(Simg1),1.0);
		score:=sig.SI_Score(Simg2);
		return score;
	END compareImage;
END;
/
CREATE OR REPLACE TYPE BODY PBDM_Saison_Type AS 
	MEMBER FUNCTION compareImage(idS IN INTEGER) RETURN DOUBLE PRECISION IS
		Simg1 SI_StillImage;
		Simg2 SI_StillImage;
		img1 ORDImage;
		bl BLOB;
		sig SI_FeatureList;
		score DOUBLE PRECISION;
	BEGIN
		SELECT image INTO img1 FROM PBDM_Saison WHERE id=idS;
		bl:=img1.source.localData;
		Simg1:=new SI_StillImage(bl);
		bl:=self.image.source.localData;
		Simg2:=new SI_StillImage(bl);
		sig:=new SI_FeatureList(new SI_AverageColor(Simg1),1.0,new SI_ColorHistogram(Simg1),1.0,new SI_PositionalColor(Simg1),1.0,new SI_Texture(Simg1),1.0);
		score:=sig.SI_Score(Simg2);
		return score;
	END compareImage;
END;
/	
CREATE OR REPLACE TYPE BODY PBDM_Serie_Type AS 
	MEMBER FUNCTION compareImage(idS IN INTEGER) RETURN DOUBLE PRECISION IS
		Simg1 SI_StillImage;
		Simg2 SI_StillImage;
		img1 ORDImage;
		bl BLOB;
		sig SI_FeatureList;
		score DOUBLE PRECISION;
	BEGIN
		SELECT image INTO img1 FROM PBDM_Serie WHERE id=idS;
		bl:=img1.source.localData;
		Simg1:=new SI_StillImage(bl);
		bl:=self.image.source.localData;
		Simg2:=new SI_StillImage(bl);
		sig:=new SI_FeatureList(new SI_AverageColor(Simg1),1.0,new SI_ColorHistogram(Simg1),1.0,new SI_PositionalColor(Simg1),1.0,new SI_Texture(Simg1),1.0);
		score:=sig.SI_Score(Simg2);
		return score;
	END compareImage;
END;
/
CREATE OR REPLACE FUNCTION compare(idJ IN INTEGER,idJ2 IN INTEGER,pond_AvgColor IN DOUBLE PRECISION,pond_colorhisto IN DOUBLE PRECISION,pond_poscol IN DOUBLE PRECISION,pond_text IN DOUBLE PRECISION) RETURN DOUBLE PRECISION IS
		jv PBDM_JeuVideo_Type;
		score DOUBLE PRECISION;
	BEGIN
		SELECT VALUE(j) INTO jv FROM PBDM_JeuVideo j WHERE j.id=idJ;
		score:=jv.compareImage(idJ2,pond_AvgColor,pond_colorhisto,pond_poscol,pond_text);
		RETURN score;
	END compare;
/
CREATE OR REPLACE FUNCTION compareF(idF IN INTEGER,idF2 IN INTEGER)
	f PBDM_Film_Type;
	score DOUBLE PRECISION;
	BEGIN
		SELECT VALUE(f) INTO f FROM PBDM_Film f WHERE f.id=idF;
		score:=f.compareImage(idF2);
		RETURN score;
	END compareF;
/
CREATE OR REPLACE FUNCTION compareSa(idS IN INTEGER,idS2 IN INTEGER)
	f PBDM_Saison_Type;
	score DOUBLE PRECISION;
	BEGIN
		SELECT VALUE(f) INTO f FROM PBDM_Saison f WHERE f.id=idF;
		score:=f.compareImage(idF2);
		RETURN score;
	END compareF;
/
CREATE OR REPLACE FUNCTION compareSe(idS IN INTEGER,idS2 IN INTEGER)
	f PBDM_Serie_Type;
	score DOUBLE PRECISION;
	BEGIN
		SELECT VALUE(f) INTO f FROM PBDM_Serie f WHERE f.id=idF;
		score:=f.compareImage(idF2);
		RETURN score;
	END compareF;
/