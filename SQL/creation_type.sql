--CREATION DES TYPES
CREATE TYPE PBDM_MediaVideo_Type AS OBJECT 
(dateSortie date, nom VARCHAR2(25), synopsis VARCHAR2(25))
NOT FINAL;
/
CREATE TYPE PBDM_Prenom_Type AS OBJECT(prenom VARCHAR2(25));
/
CREATE TYPE PBDM_PrenomsV_Type AS VARRAY(3) OF PBDM_Prenom_Type;
/
CREATE TYPE PBDM_Personne_Type AS OBJECT(
dateNaiss DATE,nom VARCHAR2(25), prenoms PBDM_PrenomsV) NOT FINAL;
/
CREATE TYPE PBDM_Acteur_Type UNDER PBDM_Personne_Type;
/
CREATE TYPE PBDM_Realisateur_Type UNDER PBDM_Personne_Type;
/
CREATE TYPE PBDM_JeuVideo_Type UNDER PBDM_MediaVideo_Type(note INTEGER,photoC ORDIMAGE);
/
CREATE TYPE PBDM_Film_Type UNDER PBDM_MediaVideo_Type (bandeA VARCHAR2(25), bandeO VARCHAR2(25));
/
CREATE TYPE PBDM_Episode_Type UNDER PBDM_MediaVideo_Type (duree INTEGER, nomE VARCHAR2(25), numero INTEGER);
/
CREATE TYPE PBDM_Saison_Type AS OBJECT (nbE INTEGER, bandeA VARCHAR2(25));
/
CREATE TYPE PBDM_Serie_Type AS OBJECT (affiche StillImage, bandeA VARCHAR2(25),nombreS INTEGER);
/
