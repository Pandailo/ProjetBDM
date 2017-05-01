--CREATION DES TYPES
DROP TYPE PBDM_MediaVideo_Type FORCE;
DROP TYPE PBDM_Episode_Type FORCE;
DROP TYPE PBDM_Saison_Type FORCE;
DROP TYPE PDBM_Prenom_Type FORCE;
DROP TYPE PBDM_PrenomsV_Type FORCE;
DROP TYPE PBDM_Personne_Type FORCE;
DROP TYPE PBDM_Acteur_Type FORCE;
DROP TYPE PBDM_Realisateur_Type FORCE;
DROP TYPE PBDM_JeuVideo_Type FORCE;
DROP TYPE PBDM_Film_Type FORCE;
DROP TYPE PBDM_Serie_Type FORCE;
DROP TYPE PBDM_SaisonRef_Type FORCE;
DROP TYPE PBDM_Saisons_Type FORCE;
DROP TYPE PBDM_Serie_Type FORCE;
DROP TYPE PBDM_FilmRef_Type FORCE;
DROP TYPE PBDM_Films_Type FORCE;
DROP TYPE PBDM_MedVidActeur_Type;

CREATE Type PBDM_MediaVideo_Type AS OBJECT 
(id NUMBER,dateSortie date, nom VARCHAR2(50), synopsis VARCHAR2(255)) 
NOT FINAL;
/
CREATE TYPE PBDM_Episode_Type;
/
CREATE TYPE PBDM_Saison_Type;
/
CREATE Type PBDM_Prenom_Type AS OBJECT(prenom VARCHAR2(25));
/
CREATE Type PBDM_PrenomsV_Type AS VARRAY(3) OF PBDM_Prenom_Type;
/
CREATE Type PBDM_Personne_Type AS OBJECT(id NUMBER,dateNaiss DATE,nom VARCHAR2(25), prenoms PBDM_PrenomsV_Type,INSTANTIABLE NOT FINAL MEMBER PROCEDURE affiche) NOT FINAL;
/
CREATE Type PBDM_Acteur_Type UNDER PBDM_Personne_Type(INSTANTIABLE FINAL OVERRIDING MEMBER PROCEDURE affiche);
/
CREATE Type PBDM_JeuVideo_Type UNDER PBDM_MediaVideo_Type(note INTEGER,photoC ORDIMAGE);
/
CREATE Type PBDM_Film_Type UNDER PBDM_MediaVideo_Type (id NUMBER,bandeA ORDVideo, bandeO ORDAudio,realisateur REF PBDM_Realisateur_Type);
/
CREATE Type PBDM_Episode_Type UNDER PBDM_MediaVideo_Type (duree INTEGER, nomE VARCHAR2(25), numero INTEGER,saison REF PBDM_Saison_Type);
/
CREATE TYPE PBDM_Serie_Type;
/
CREATE TYPE PBDM_Episodes_Type AS TABLE OF PBDM_Episode_type;
/
CREATE Type PBDM_Saison_Type AS OBJECT (id NUMBER,nbE INTEGER, bandeA VARCHAR2(25),serie REF PBDM_Serie_Type,episodes episodes_type);
/
CREATE TYPE PBDM_SaisonRef_Type AS OBJECT(serieRef REF PBDM_Serie_Type);
/
CREATE TYPE PBDM_Saisons_Type AS TABLE OF PBDM_SaisonRef_Type;
/
CREATE Type PBDM_Serie_Type AS OBJECT (id NUMBER,affiche StillImage, bandeA VARCHAR2(25),nombreS INTEGER,saisons PBDM_Saisons_Type);
/
CREATE Type PBDM_FilmRef_Type AS OBJECT (filmRef REF PBDM_Film_Type);
/
CREATE Type PBDM_Films_Type AS TABLE OF PBDM_FilmRef_Type;
/
CREATE Type PBDM_Realisateur_Type UNDER PBDM_Personne_Type (id NUMBER,filmsR PBDM_Films_Type,INSTANTIABLE FINAL OVERRIDING MEMBER PROCEDURE affiche);
/
--CREATE TYPE PBDM_MedVidActeur_Type AS OBJECT(ActeurMA REF PBDM_Acteur_Type,MedVidMA REF PBDM_MediaVideo_Type);
/


