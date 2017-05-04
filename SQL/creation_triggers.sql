CREATE OR REPLACE TRIGGER trigger_PBDM_idF BEFORE INSERT ON PBDM_Film FOR EACH ROW
DECLARE
	idm INTEGER;
BEGIN
	SELECT max(id) INTO idm FROM PBDM_Film;
	IF idm IS NOT NULL
	THEN 
		idm:=idm+1; 
		:new.id := idm;
	ELSE
		:new.id :=0;
	END IF;
END;
/
CREATE OR REPLACE TRIGGER trigger_PBDM_idJ BEFORE INSERT ON PBDM_JeuVideo FOR EACH ROW
DECLARE
	idm INTEGER;
BEGIN
	SELECT max(id) INTO idm FROM PBDM_JeuVideo;
	IF idm IS NOT NULL
	THEN 
		idm:=idm+1; 
		:new.id := idm;
	ELSE
		:new.id :=0;
	END IF;
END;
/

CREATE OR REPLACE TRIGGER trigger_PBDM_idA BEFORE INSERT ON PBDM_Acteur FOR EACH ROW
DECLARE
	idm INTEGER;
BEGIN
	SELECT max(id) INTO idm FROM PBDM_Acteur;
	IF idm IS NOT NULL
	THEN 
		idm:=idm+1; 
		:new.id := idm;
	ELSE
		:new.id :=0;
	END IF;
END;
/
CREATE OR REPLACE TRIGGER trigger_PBDM_idR BEFORE INSERT ON PBDM_Realisateur FOR EACH ROW
DECLARE
	idm INTEGER;
BEGIN
	SELECT max(id) INTO idm FROM PBDM_Realisateur;
	IF idm IS NOT NULL
	THEN 
		idm:=idm+1; 
		:new.id := idm;
	ELSE
		:new.id :=0;
	END IF;
END;
/
CREATE OR REPLACE TRIGGER trigger_PBDM_idSa BEFORE INSERT ON PBDM_Saison FOR EACH ROW
DECLARE
	idm INTEGER;
BEGIN
	SELECT max(id) INTO idm FROM PBDM_Saison;
	IF idm IS NOT NULL
	THEN 
		idm:=idm+1; 
		:new.id := idm;
	ELSE
		:new.id :=0;
	END IF;
END;
/

CREATE OR REPLACE TRIGGER trigger_PBDM_idSe BEFORE INSERT ON PBDM_Serie FOR EACH ROW
DECLARE
	idm INTEGER;
BEGIN
	SELECT max(id) INTO idm FROM PBDM_Serie;
	IF idm IS NOT NULL
	THEN 
		idm:=idm+1; 
		:new.id := idm;
	ELSE
		:new.id :=0;
	END IF;
END;
/

