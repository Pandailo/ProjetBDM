DROP INDEX PBDM_indexF;
DROP INDEX PBDM_indexJ;
DROP INDEX PBDM_indexS;
DROP INDEX PBDM_indexA;
DROP INDEX PBDM_indexR;
DROP INDEX PBDM_indexSF;
DROP INDEX PBDM_indexSJ;
DROP INDEX PBDM_indexSS;

CREATE INDEX PBDM_indexF ON PBDM_Film(nom) INDEXTYPE IS CTXSYS.CONTEXT;
CREATE INDEX PBDM_indexJ ON PBDM_JeuVideo(nom) INDEXTYPE IS CTXSYS.CONTEXT;
CREATE INDEX PBDM_indexS ON PBDM_Serie(nom) INDEXTYPE IS CTXSYS.CONTEXT;
CREATE INDEX PBDM_indexA ON PBDM_Acteur(nom) INDEXTYPE IS CTXSYS.CONTEXT;
CREATE INDEX PBDM_indexR ON PBDM_Realisateur(nom) INDEXTYPE IS CTXSYS.CONTEXT;
CREATE INDEX PBDM_indexSF ON PBDM_Film(synopsis) INDEXTYPE IS CTXSYS.CONTEXT;
CREATE INDEX PBDM_indexSJ ON PBDM_JeuVideo(synopsis) INDEXTYPE IS CTXSYS.CONTEXT;
CREATE INDEX PBDM_indexSS ON PBDM_Serie(synopsis) INDEXTYPE IS CTXSYS.CONTEXT;
