--CREATION DES TypeS
CREATE Type PBDM_MediaVideo_Type AS OBJECT 
(dateSortie date, nom VARCHAR2(25), synopsis VARCHAR2(25)) 
NOT FINAL;
/
CREATE Type PBDM_Prenom_Type AS OBJECT(prenom VARCHAR2(25));
/
CREATE Type PBDM_PrenomsV_Type AS VARRAY(3) OF PBDM_Prenom_Type;
/
CREATE Type PBDM_Personne_Type AS OBJECT(
dateNaiss DATE,nom VARCHAR2(25), prenoms PBDM_PrenomsV) NOT FINAL;
/
CREATE Type PBDM_Acteur_Type UNDER PBDM_Personne_Type;
/
CREATE Type PBDM_Realisateur_Type;
/
CREATE Type PBDM_JeuVideo_Type UNDER PBDM_MediaVideo_Type(note INTEGER,photoC ORDIMAGE);
/
CREATE Type PBDM_Film_Type UNDER PBDM_MediaVideo_Type (bandeA VARCHAR2(25), bandeO VARCHAR2(25),realisateur REF PBDM_Realisateur_Type);
/
CREATE Type PBDM_Episode_Type UNDER PBDM_MediaVideo_Type (duree INTEGER, nomE VARCHAR2(25), numero INTEGER);
/
CREATE TYPE PBDM_Serie_Type;
/
CREATE Type PBDM_Saison_Type AS OBJECT (nbE INTEGER, bandeA VARCHAR2(25),saison REF PBDM_Serie_Type);
/
CREATE TYPE PBDM_SaisonRef_Type AS OBJECT(serieRef REF PBDM_Serie_Type);
/
CREATE TYPE PBDM_Saisons_Type AS TABLE OF PBDM_SaisonRef_Type;
/
CREATE Type PBDM_Serie_Type AS OBJECT (affiche StillImage, bandeA VARCHAR2(25),nombreS INTEGER,saisons PBDM_Saisons_Type);
/
CREATE Type PBDM_FilmRef_Type AS OBJECT (filmRef REF PBDM_Film_Type);
/
CREATE Type PBDM_Films_Type AS TABLE OF PBDM_FilmRef_Type;
/
CREATE Type PBDM_Realisateur_Type UNDER PBDM_Personne_Type (filmsR PBDM_Films_Type);
/
