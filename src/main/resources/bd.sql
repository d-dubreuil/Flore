
-- 1. Remise à zéro

DROP TABLE caracteristique IF EXISTS;

DROP TABLE commande IF EXISTS;

DROP TABLE compte_utilisateur IF EXISTS;

DROP TABLE conseil IF EXISTS;

DROP TABLE faune IF EXISTS;

DROP TABLE favoris IF EXISTS;

DROP TABLE flore;

DROP TABLE historique IF EXISTS;

DROP TABLE jardin IF EXISTS;

DROP TABLE paiement IF EXISTS;

DROP TABLE panier IF EXISTS;

DROP TABLE plante_favories IF EXISTS;

DROP TABLE plante_jardin IF EXISTS;

DROP TABLE produit IF EXISTS;

DROP TABLE recherches IF EXISTS;

DROP TABLE referentiel_caracteristique IF EXISTS;

DROP TABLE referentiel_faune IF EXISTS;

DROP TABLE referentiel_utilisateur IF EXISTS;

DROP TABLE selection IF EXISTS;

DROP TABLE utilisateur IF EXISTS;


-- 2. Création Tables sans lien

-- Table: caracteristique

CREATE TABLE caracteristique
(
  id bigint NOT NULL,
  version integer NOT NULL,
  nom character varying(255),
  valeur character varying(255),
  type_carac character varying(255),
  bonus_malus boolean,
  CONSTRAINT caracteristique_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE caracteristique
  OWNER TO postgres;


-- Table: commande

CREATE TABLE commande
(
  id bigint NOT NULL,
  version integer NOT NULL,
  reference integer,
  total real,
  type_envoi character varying(255),
  CONSTRAINT commande_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE commande
  OWNER TO postgres;

	
-- Table: compte_utilisateur

CREATE TABLE compte_utilisateur
(
  id bigint NOT NULL,
  version integer NOT NULL,
  code_postal character varying(255),
  complement character varying(255),
  identifiant character varying(255),
  informations_bancaires character varying(255),
  mail character varying(255),
  mot_de_passe character varying(255),
  nom character varying(255),
  prenom character varying(255),
  rue character varying(255),
  telephone character varying(255),
  ville character varying(255),
  CONSTRAINT compte_utilisateur_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE compte_utilisateur
  OWNER TO postgres;

	
-- Table: conseil

CREATE TABLE conseil
(
  id bigint NOT NULL,
  version integer NOT NULL,
  publication date, 
  nom character varying(255),
  texte character varying(255),
  theme character varying(255),
  CONSTRAINT conseil_pkey PRIMARY KEY (id)

)
WITH (
  OIDS=FALSE
);
ALTER TABLE conseil
  OWNER TO postgres;	

	
-- Table: faune

CREATE TABLE faune
(
  id bigint NOT NULL,
  version integer NOT NULL,
  nom_faune character varying(255),
  CONSTRAINT faune_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE faune
  OWNER TO postgres;


-- Table: favoris

CREATE TABLE favoris
(
  id bigint NOT NULL,
  version integer NOT NULL,
  nom character varying(255),
  CONSTRAINT favoris_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE favoris
  OWNER TO postgres;
	

-- Table: flore

CREATE TABLE flore
(
  id bigint NOT NULL,
  version integer NOT NULL,
  nom character varying(255),
  CONSTRAINT flore_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE flore
  OWNER TO postgres;
  


-- Table: historique

CREATE TABLE historique
(
  id bigint NOT NULL,
  nomrecherche character varying(255),
  recherche character varying(255),
  version integer NOT NULL,
  compteutilisateurid bigint,
  nom_recherche character varying(255),
  CONSTRAINT historique_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE historique
  OWNER TO postgres;
  
  
-- Table: jardin

CREATE TABLE jardin
(
  id bigint NOT NULL,
  nom character varying(255),
  version integer NOT NULL,
  CONSTRAINT jardin_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE jardin
  OWNER TO postgres;


-- Table: paiement

CREATE TABLE paiement
(
  id bigint NOT NULL,
  montant real,
  numerocarte character varying(255),
  version integer NOT NULL,
  cryptogramme character varying(255),
  dt_validite character varying(255),
  numero_carte character varying(255),
  CONSTRAINT paiement_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE paiement
  OWNER TO postgres;
	
	
-- Table: panier

CREATE TABLE panier
(
  id bigint NOT NULL,
  total real,
  version integer NOT NULL,
  CONSTRAINT panier_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE panier
  OWNER TO postgres;

	
-- Table: plante_favories

CREATE TABLE plante_favories
(
)
WITH (
  OIDS=FALSE
);
ALTER TABLE plante_favories
  OWNER TO postgres;
	

-- Table: plante_jardin

CREATE TABLE plante_jardin
(
)
WITH (
  OIDS=FALSE
);
ALTER TABLE plante_jardin
  OWNER TO postgres;


-- Table: produit

CREATE TABLE produit
(
  id bigint NOT NULL,
  fournisseur character varying(255),
  prix real,
  stock integer,
  version integer NOT NULL,
  ref_produit integer,
  CONSTRAINT produit_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE produit
  OWNER TO postgres;


-- Table: recherches

CREATE TABLE recherches
(
)
WITH (
  OIDS=FALSE
);
ALTER TABLE recherches
  OWNER TO postgres;


-- Table: referentiel_caracteristique

CREATE TABLE referentiel_caracteristique
(
  id bigint NOT NULL,
  version integer NOT NULL,
  CONSTRAINT referentiel_caracteristique_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE referentiel_caracteristique
  OWNER TO postgres;
  
 
 -- Table: referentiel_faune

CREATE TABLE referentiel_faune
(
  id bigint NOT NULL,
  version integer NOT NULL,
  CONSTRAINT referentiel_faune_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE referentiel_faune
  OWNER TO postgres;
  
  
 -- Table: referentiel_utilisateur

CREATE TABLE referentiel_utilisateur
(
  id bigint NOT NULL,
  version integer NOT NULL,
  CONSTRAINT referentiel_utilisateur_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE referentiel_utilisateur
  OWNER TO postgres;


-- Table: selection

CREATE TABLE selection
(
  id bigint NOT NULL,
  total integer,
  version integer NOT NULL,
  CONSTRAINT selection_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE selection
  OWNER TO postgres;
  
 -- Table: utilisateur

CREATE TABLE utilisateur
(
  id bigint NOT NULL,
  disc character varying(255),
  version integer NOT NULL,
  CONSTRAINT utilisateur_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE utilisateur
  OWNER TO postgres;
  
 
 -- 3. Ajout liens et clés étrangères 
 
 -- Table caractéristique : 0
 
 -- Table commande : 2 (paiement, panier)
 
ALTER TABLE commande 
	ADD COLUMN paiement_id integer,
	ADD COLUMN panier_id integer;

ALTER TABLE commande
	ADD CONSTRAINT fk_commande_paiement FOREIGN KEY (paiement_id) REFERENCES paiement (id), 
	ADD CONSTRAINT fk_commande_panier FOREIGN KEY (panier_id) REFERENCES panier (id);

-- Table compte_utilisateur : 0 

-- Table conseil : 1 (utilisateur)

ALTER TABLE conseil 
	ADD COLUMN utilisateur_id integer;

ALTER TABLE conseil
	ADD CONSTRAINT fk_conseil_utilisateur FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id);

-- Table faune : 0

-- Table favoris : 1 (compte_utilisateur) 

ALTER TABLE favoris
	ADD COLUMN compte_utilisateur_id integer;

ALTER TABLE conseil
	ADD CONSTRAINT fk_conseil_compteUtilisateur FOREIGN KEY (compte_utilisateur_id) REFERENCES compte_utilisateur (id);

-- Table flore : 0

-- Table historique : 1 (compte_utilisateur)

ALTER TABLE historique
	ADD COLUMN compteUtilisateur_id integer;

ALTER TABLE conseil
	ADD CONSTRAINT fk_historique_compteUtilisateur FOREIGN KEY (compteUtilisateur_id) REFERENCES compte_utilisateur (id);

-- Table jardin : 1 (compte_utilisateur)

ALTER TABLE jardin
	ADD COLUMN compteUtilisateur_id integer;

ALTER TABLE conseil
	ADD CONSTRAINT fk_jardin_compteUtilisateur FOREIGN KEY (compteUtilisateur_id) REFERENCES compte_utilisateur (id);

-- Table paiement : 0

-- Table panier : 1 (utilisateur)

ALTER TABLE panier
	ADD COLUMN utilisateur_id integer;

ALTER TABLE panier
	ADD CONSTRAINT fk_panier_utilisateur FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id);

-- Table plante_favories : 2 (favori, flore)

ALTER TABLE plante_favories 
	ADD COLUMN favoris_id integer,
	ADD COLUMN flore_id integer;

ALTER TABLE plante_favories
	ADD CONSTRAINT fk_planteFavories_favoris FOREIGN KEY (favoris_id) REFERENCES favoris (id), 
	ADD CONSTRAINT fk_planteFavories_flore FOREIGN KEY (flore_id) REFERENCES flore (id);

-- Table plante_jardin : 2 (jardin, flore)

ALTER TABLE plante_jardin
	ADD COLUMN jardin_id integer,
	ADD COLUMN flore_id integer;

ALTER TABLE plante_jardin
	ADD CONSTRAINT fk_planteJardin_favoris FOREIGN KEY (jardin_id) REFERENCES jardin (id), 
	ADD CONSTRAINT fk_planteJardin_flore FOREIGN KEY (flore_id) REFERENCES flore (id);

-- Table produit : 3 (faune, flore, utilisateur) 

ALTER TABLE produit
	ADD COLUMN faune_id integer,
	ADD COLUMN flore_id integer,
	ADD COLUMN utilisateur_id integer;

ALTER TABLE produit
	ADD CONSTRAINT fk_produit_faune FOREIGN KEY (faune_id) REFERENCES faune (id), 
	ADD CONSTRAINT fk_produit_flore FOREIGN KEY (flore_id) REFERENCES flore (id), 
	ADD CONSTRAINT fk_produit_utilisateur FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id);

-- Table recherches : 2 (utilisateur, flore) 

ALTER TABLE recherches
	ADD COLUMN utilisateur_id integer,
	ADD COLUMN flore_id integer;

ALTER TABLE recherches
	ADD CONSTRAINT fk_recherches_utilisateur FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id), 
	ADD CONSTRAINT fk_recherches_flore FOREIGN KEY (flore_id) REFERENCES flore (id);


-- Table référentiel caractéristiques : 2 (caractéristique, flore)

ALTER TABLE referentiel_caracteristique
	ADD COLUMN caracteristique_id integer,
	ADD COLUMN flore_id integer;

ALTER TABLE recherches
	ADD CONSTRAINT fk_referentielCaracteristique_caracteristique FOREIGN KEY (caracteristique_id) REFERENCES caracteristique (id), 
	ADD CONSTRAINT fk_referentielCaracteristique_flore FOREIGN KEY (flore_id) REFERENCES flore (id);

-- Table référentiel  faune : 3 (caractéristique, faune, flore)

ALTER TABLE referentiel_faune
	ADD COLUMN caracteristique_id integer,
	ADD COLUMN faune_id integer,
	ADD COLUMN flore_id integer;

ALTER TABLE recherches
	ADD CONSTRAINT fk_referentielFaune_caracteristique FOREIGN KEY (caracteristique_id) REFERENCES caracteristique (id), 
	ADD CONSTRAINT fk_referentielFaune_faune FOREIGN KEY (faune_id) REFERENCES faune (id),
	ADD CONSTRAINT fk_referentielFaune_flore FOREIGN KEY (flore_id) REFERENCES flore (id);

-- Table référentiel utilisateur : 2 (caractéristique, compte_utilisateur)

ALTER TABLE referentiel_utilisateur
	ADD COLUMN caracteristique_id integer,
	ADD COLUMN compteUtilisateur_id integer;

ALTER TABLE recherches
	ADD CONSTRAINT fk_referentielUtilisateur_caracteristique FOREIGN KEY (caracteristique_id) REFERENCES caracteristique (id), 
	ADD CONSTRAINT fk_referentielUtilisateur_compteUtilisateur FOREIGN KEY (compteUtilisateur_id) REFERENCES compte_utilisateur (id);

-- Table sélection : 2 (panier, produit)
 
ALTER TABLE selection
	ADD COLUMN produit_id integer,
	ADD COLUMN panier_id integer;

ALTER TABLE commande
	ADD CONSTRAINT fk_selection_produit FOREIGN KEY (produit_id) REFERENCES produit (id), 
	ADD CONSTRAINT fk_selection_panier FOREIGN KEY (panier_id) REFERENCES panier (id);

-- Table utilisateur : 1 (compte_utilisateur)

ALTER TABLE utilisateur
	ADD COLUMN compteUtilisateur_id integer;

ALTER TABLE conseil
	ADD CONSTRAINT fk_utilisateur_compteUtilisateur FOREIGN KEY (compteUtilisateur_id) REFERENCES compte_utilisateur (id);


-- 4. Ajout données

-- Caractéristique avec booléen (max 301)
INSERT INTO caracteristique (id, version, nom, type_carac, valeur, bonus_malus)
    VALUES 
	(1, 0, 'pH', 'Sol', 'Très Acide', 'TRUE'),
	(2, 0, 'pH', 'Sol', 'Acide', 'TRUE'),
	(3, 0, 'pH', 'Sol', 'Neutre', 'TRUE'),
    (4, 0, 'pH', 'Sol', 'Basique', 'TRUE'),
    (5, 0, 'Texture', 'Sol', 'Limoneux', 'TRUE'),
    (6, 0, 'Texture', 'Sol', 'Sableux', 'TRUE'),
    (7, 0, 'Texture', 'Sol', 'Argileux', 'TRUE'),
    (8, 0, 'Texture', 'Sol', 'Argileux Sableux', 'TRUE'),
    (9, 0, 'Texture', 'Sol', 'Limoneux Sableux', 'TRUE'),
    (10, 0, 'Texture', 'Sol', 'Argileux Limoneux', 'TRUE'),
    (11, 0, 'Texture', 'Sol', 'Argileux Limoneux Sableux', 'TRUE'),
	(159, 0, 'Texture', 'Sol', 'Humifère', 'TRUE'),
	(175, 0, 'Texture', 'Sol', 'Calcaire', 'TRUE'),
	(12, 0, 'Ensoleillement', 'Condition_Climatique', 'Plein Soleil', 'TRUE'),
	(13, 0, 'Ensoleillement', 'Condition_Climatique', 'Soleil', 'TRUE'),
	(14, 0, 'Ensoleillement', 'Condition_Climatique', 'Mi Ombre', 'TRUE'),
	(15, 0, 'Ensoleillement', 'Condition_Climatique', 'Ombre', 'TRUE'),
	(16, 0, 'Ensoleillement', 'Condition_Climatique', 'Pleine Ombre', 'TRUE'),
	(17, 0, 'Vent', 'Condition_Climatique', 'Peu Résistant', 'TRUE'),
	(18, 0, 'Vent', 'Condition_Climatique', 'Assez Résistant', 'TRUE'),
	(147, 0, 'Vent', 'Condition_Climatique', 'Haie Brise-Vent', 'TRUE'),
	(19, 0, 'Vent', 'Condition_Climatique', 'Très Résistant', 'TRUE'),
	(20, 0, 'Strate', 'Flore', 'Canopée', 'FALSE'),
	(21, 0, 'Strate', 'Flore', 'Petits Arbres', 'FALSE'),
	(22, 0, 'Strate', 'Flore', 'Arbustive', 'FALSE'),
	(23, 0, 'Strate', 'Flore', 'Herbacée Haute', 'FALSE'),
	(24, 0, 'Strate', 'Flore', 'Herbacée Basse', 'FALSE'),
	(25, 0, 'Strate', 'Flore', 'Couvre Sol', 'FALSE'),
	(26, 0, 'Strate', 'Flore', 'Rhizosphère', 'FALSE'),
	(27, 0, 'Strate', 'Flore', 'Grimpante', 'FALSE'),
	(28, 0, 'Racines', 'Flore', 'Profondes', 'FALSE'),
	(153, 0, 'Racines', 'Flore', 'Profondeur Moyenne', 'FALSE'),
    (29, 0, 'Racines', 'Flore', 'Superficielles', 'FALSE'),
    (30, 0, 'Racines', 'Flore', 'Rhizomes', 'FALSE'),
    (31, 0, 'Croissance', 'Flore', 'Lente', 'FALSE'),
    (32, 0, 'Croissance', 'Flore', 'Normale', 'FALSE'),
    (33, 0, 'Croissance', 'Flore', 'Rapide', 'FALSE'),
	(34, 0, 'Azote', 'Flore', 'Fixateur', 'FALSE'),
	(35, 0, 'Azote', 'Flore', 'Neutre', 'FALSE'),
	(36, 0, 'Azote', 'Flore', 'Dévoreur', 'FALSE'),
	(171, 0, 'Azote', 'Flore', 'Inhibiteur', 'FALSE'),
	(37, 0, 'Nutriment', 'Flore', 'Fixateur', 'FALSE'),
	(38, 0, 'Nutriment', 'Flore', 'Neutre', 'FALSE'),
	(39, 0, 'Nutriment', 'Flore', 'Dévoreur', 'FALSE'),
	(67, 0, 'Climat', 'Condition_Climatique', 'Océanique', 'TRUE'),
    (68, 0, 'Climat', 'Condition_Climatique', 'Semi-Océanique', 'TRUE'),
    (69, 0, 'Climat', 'Condition_Climatique', 'Montagnard', 'TRUE'),
    (70, 0, 'Climat', 'Condition_Climatique', 'Méditerranéen', 'TRUE'),
    (71, 0, 'Climat', 'Condition_Climatique', 'Continental', 'TRUE'),
	(125, 0, 'Humidité', 'Sol', 'Sec', 'TRUE'), 
	(126, 0, 'Humidité', 'Sol', 'Drainé', 'TRUE'),
	(127, 0, 'Humidité', 'Sol', 'Humide', 'TRUE'),
	(128, 0, 'Humidité', 'Sol', 'Très Humide', 'TRUE'), 
	(129, 0, 'Humidité', 'Sol', 'Aquatique', 'TRUE'),
	(135, 0, 'Arrosage', 'Utilisation', 'Faible','TRUE'),
    (136, 0, 'Arrosage', 'Utilisation', 'Modéré','TRUE'),
    (137, 0, 'Arrosage', 'Utilisation', 'Important','TRUE'),
	(151, 0, 'Température', 'Condition_Climatique', '15/32', 'TRUE'),
	(152, 0, 'Température', 'Condition_Climatique', '10/40', 'TRUE'),
	(158, 0, 'Température', 'Condition_Climatique', '10/30', 'TRUE'),
	(163, 0, 'Température', 'Condition_Climatique', '5/35', 'TRUE'),
	(167, 0, 'Température', 'Condition_Climatique', '7/30', 'TRUE'),
	(172, 0, 'Température', 'Condition_Climatique', '-6/30', 'TRUE'),
	(176, 0, 'Température', 'Condition_Climatique', '5/25', 'TRUE'),
	(179, 0, 'Température', 'Condition_Climatique', '3/30', 'TRUE'),
	(183, 0, 'Température', 'Condition_Climatique', '10/', 'TRUE'),
	(186, 0, 'Température', 'Condition_Climatique', '-15/30', 'TRUE');  
	
-- Caractéristique sans booléen
INSERT INTO caracteristique (id, version, nom,type_carac, valeur )
    VALUES 
	
	(40, 0, 'Végétation', 'Flore', 'Vivace'), 
    (41, 0, 'Végétation', 'Flore', 'Annuelle'),
    (42, 0, 'Végétation', 'Flore', 'Bisannuelle'),
	(43, 0, 'Reproduction', 'Flore', 'AutoFertile'),
	(44, 0, 'Reproduction', 'Flore', 'AutoStérile'),
	(45, 0, 'Reproduction', 'Flore', 'Dioïque'),
	(164, 0, 'Reproduction', 'Flore', 'Allogame'),
	(187, 0, 'Reproduction', 'Flore', 'Hybride Stérile'),
	(46, 0, 'FloreFaune', 'Faune', 'Attraction'),
	(47, 0, 'FloreFaune', 'Faune', 'Répulsion'),
	(48, 0, 'FloreFaune', 'Faune', 'Pollinisateur'),
	(146, 0, 'FloreFaune', 'Faune', 'Source De Fourrage'),
	(49, 0, 'FauneFaune', 'Faune', 'Chasseur'),
	(50, 0, 'FauneFaune', 'Faune', 'Chassé'),
	(51, 0, 'UsageHumain', 'Utilisation', 'Médicinale'),
	(52, 0, 'UsageHumain', 'Utilisation', 'Bois' ),
	(53, 0, 'UsageHumain', 'Utilisation', 'Résine' ),
	(54, 0, 'UsageHumain', 'Utilisation', 'Ornementale' ),
	(55, 0, 'UsageHumain', 'Utilisation', 'Teinture' ),
	(56, 0, 'UsageHumain', 'Utilisation', 'Huile Essentielle' ),
	(57, 0, 'FloreEnvironnement', 'Flore', 'Contrôle Erosion' ),
	(58, 0, 'FloreEnvironnement', 'Flore', 'Barrière Chimique' ),
	(59, 0, 'FloreEnvironnement', 'Flore', 'Source De Paillage' ),
	(60, 0, 'FloreEnvironnement', 'Flore', 'Habitat Vie Sauvage' ),
	(61, 0, 'FloreEnvironnement', 'Flore', 'Répulsif Herbe' ),
	(62, 0, 'FloreEnvironnement', 'Flore', 'Répulsif Champignon' ),
	(63, 0, 'Espece', 'Flore', 'Fruits' ),
	(64, 0, 'Espece', 'Flore', 'Légumes' ),
	(65, 0, 'Espece', 'Flore', 'Aromatiques' ),
	(66, 0, 'Espece', 'Flore', 'Fleurs' ),
	(195, 0, 'Espece', 'Flore', 'Céréales'), 
	(72, 0, 'Comestible', 'Utilisation', 'Fruits(Arbustes)'),
    (73, 0, 'Comestible', 'Utilisation', 'Fruits(Arbres)'),
    (74, 0, 'Comestible', 'Utilisation', 'Légumes'),
    (75, 0, 'Comestible', 'Utilisation', 'Fleurs'), 
    (76, 0, 'Comestible', 'Utilisation', 'Aromatiques'),
	(145, 0, 'Comestible', 'Utilisation', 'Céréales'),
	(168, 0, 'Comestible', 'Utilisation', 'Racines'),	
    (77, 0, 'Plantation', 'Utilisation', 'Janvier'),  
    (78, 0, 'Plantation', 'Utilisation', 'Février'), 
    (79, 0, 'Plantation', 'Utilisation', 'Mars'), 
    (80, 0, 'Plantation', 'Utilisation', 'Avril'), 
	(81, 0, 'Plantation', 'Utilisation', 'Mai'),
	(82, 0, 'Plantation', 'Utilisation', 'Juin'),
	(83, 0, 'Plantation', 'Utilisation', 'Juillet'),
	(84, 0, 'Plantation', 'Utilisation', 'Août'),
	(85, 0, 'Plantation', 'Utilisation', 'Septembre'),
	(86, 0, 'Plantation', 'Utilisation', 'Octobre'),
	(87, 0, 'Plantation', 'Utilisation', 'Novembre'),
	(88, 0, 'Plantation', 'Utilisation', 'Décembre'),
	(101, 0, 'Récolte', 'Utilisation', 'Janvier'),  
    (102, 0, 'Récolte', 'Utilisation', 'Février'), 
    (103, 0, 'Récolte', 'Utilisation', 'Mars'), 
    (104, 0, 'Récolte', 'Utilisation', 'Avril'), 
	(105, 0, 'Récolte', 'Utilisation', 'Mai'),
	(106, 0, 'Récolte', 'Utilisation', 'Juin'),
	(107, 0, 'Récolte', 'Utilisation', 'Juillet'),
	(108, 0, 'Récolte', 'Utilisation', 'Août'),
	(109, 0, 'Récolte', 'Utilisation', 'Septembre'),
	(110, 0, 'Récolte', 'Utilisation', 'Octobre'),
	(111, 0, 'Récolte', 'Utilisation', 'Novembre'),
	(112, 0, 'Récolte', 'Utilisation', 'Décembre'),
	(130, 0, 'Remontant', 'Flore', 'Oui'), 
    (131, 0, 'Remontant', 'Flore', 'Non'), 
	(155, 0, 'HauteurAMaturite', 'Flore', '20'),
    (132, 0, 'HauteurAMaturite', 'Flore', '20/60'),
    (133, 0, 'HauteurAMaturite', 'Flore', '60/150'),
    (134, 0, 'HauteurAMaturite', 'Flore', '150'),
    (138, 0, 'RésistanceAuFroid', 'Condition_Climatique', 'Faible'),
    (139, 0, 'RésistanceAuFroid', 'Condition_Climatique', 'Modérée'),
    (140, 0, 'RésistanceAuFroid', 'Condition_Climatique', 'Importante'),
	(141, 0, 'Commentaires', 'Utilisation', ''),
	(142, 0, 'Famille', 'Flore', 'Poacées'),
	(148, 0, 'Famille', 'Flore', 'Fabacées'),--éloignés du 150--fixateur d'azote
	(150, 0, 'Famille', 'Flore', 'Alliacées'),--éloignés du 148--
	(154, 0, 'Famille', 'Flore', 'Cucurbitacées'),--besoin de bcp d'azote
	(160, 0, 'Famille', 'Flore', 'Solanacées'),
	(165, 0, 'Famille', 'Flore', 'Apiacées'),--se protègent réciproquement?
	(173, 0, 'Famille', 'Flore', 'Rosacées'),
	(177, 0, 'Famille', 'Flore', 'Brassicacées'),
	(180, 0, 'Famille', 'Flore', 'Lamiacées'),
	(143, 0, 'Diamètre', 'Flore', '0.30/0.40'),
	(144, 0, 'Hauteur', 'Flore', '1.5/5'),
	(149, 0, 'Hauteur', 'Flore', '0.30/5'),
	(156, 0, 'Hauteur', 'Flore', '0.15'),
	(157, 0, 'Diamètre', 'Flore', '1.5/4'),
	(161, 0, 'Hauteur', 'Flore', '0.45/5'),
	(162, 0, 'Diamètre', 'Flore', '0.60/2'),
	(166, 0, 'Hauteur', 'Flore', '0.30/0.60'),
	(169, 0, 'Hauteur', 'Flore', '0.45/1'),
	(170, 0, 'Diamètre', 'Flore', '0.25/0.30'),
	(174, 0, 'Hauteur', 'Flore', '0.15/0.45'),
	(178, 0, 'Diamètre', 'Flore', '0.50/0.80'),
	(181, 0, 'Hauteur', 'Flore', '0.15/1'),
	(182, 0, 'Diamètre', 'Flore', '0.10/0.70'),
	(184, 0, 'Hauteur', 'Flore', '0.40/0.60'),
	(185, 0, 'Diamètre', 'Flore', '0.20/0.50'),
	(188, 0,'Chassé','Faune','Puceron'),
	(189, 0,'Prédateur','Faune','Coccinelle'),
	(190, 0,'Chassé','Faune','Tetranychus urticae'),
	(191, 0,'Prédateur','Faune','Coléoptère'),
	(192, 0,'Prédateur','Faune','Trichogramme'),
	(193, 0,'Prédateur','Faune','Encarsia formosa'),
	(194, 0,'Chassé','Faune','Aleurodes'),
	(196, 0, 'NomLatin', 'Flore', 'Zea mays'), 
	(197, 0, 'NomLatin', 'Flore', 'Phaseolus vulgaris'),
	(198, 0, 'NomLatin', 'Flore', 'Cucurbita pepo'),
	(199, 0, 'NomLatin', 'Flore', 'Lycopersicon esculentum, Solanum esculentum'), 
	(200, 0, 'NomLatin', 'Flore', 'Daucus carota'), 
	(201, 0, 'NomLatin', 'Flore', 'Allium cepa'),
	(202, 0, 'NomLatin', 'Flore', 'Fragaria'), 
	(203, 0, 'NomLatin', 'Flore', 'Brassica oleacera var. botrytis'), 
	(204, 0, 'NomLatin', 'Flore', 'Ocimum basilicum'),
	(205, 0, 'NomLatin', 'Flore', 'Mentha'), 
	(206, 0, 'Descriptif', 'Web', 'Facile de culture et de croissance rapide, si on lui assure chaleur, lumière et humidité, le maïs présente de nombreux atouts nutritionnels. Il est aussi utile au jardin où il peut faire office de haie brise-vent, d''écran, de tuteur…'), 
	(207, 0, 'Descriptif', 'Web', 'Légume vert par excellence, aux qualités tant diététiques que gustatives, le haricot se décline en gousses croquantes ou en grains fondants et il nourrit le sol du jardin en même temps que le jardinier.'), 
	(208, 0, 'Descriptif', 'Web', 'Cultivées depuis au moins 8 000 ans en Amérique du Nord et en Amérique centrale, les courges ont développé une variabilité de formes et de couleurs remarquable. Consommés crus ou cuits, les fruits des courges ont un goût très fin.'), 
	(209, 0, 'Descriptif', 'Web', 'Cette plante annuelle aux multiples formes s’est imposée dans tous les potagers des campagnes comme des villes. La tomate est aujourd’hui le légume le plus consommé au monde alors qu’il a longtemps été considéré comme toxique.'), 
	(210, 0, 'Descriptif', 'Web', 'La carotte est le légume indispensable au potager. Riche en vitamines et en sels minéraux, elle se consomme crue ou cuite et est très goûteuse. De plus, la carotte est facile à entretenir, il ne vous reste plus qu''à la cultiver !'),
	(211, 0, 'Descriptif', 'Web', 'À la fois légume et aromate, l''oignon est indispensable dans notre cuisine. Facile à cultiver, il existe sous de multiples formes et couleurs, et se déguste frais ou sec. On lui prête en outre de nombreux bienfaits.'), 	
	(212, 0, 'Descriptif', 'Web', 'À croquer tout juste cueillie, en dessert, sorbet ou confiture, elle est plébiscitée par les enfants et les grands. Petite fraise des bois ou fraise cultivée, elle fait l’unanimité pour son parfum exquis. C''est aussi l''un des premiers fruits au jardin.'), 
	(213, 0, 'Descriptif', 'Web', 'Plébiscité pour sa saveur plutôt douce et sa belle pomme blanche, le chou-fleur est le chou préféré des Français. On trouve aujour''hui, des choux-fleurs à la pomme vert jaune spiralée très décorative, à pomme orange ou encore violette.'), 
	(214, 0, 'Descriptif', 'Web', 'Le basilic est une plante aromatique facile à cultiver en extérieur ou en intérieur, en pot ou en pleine terre. Très apprécié pour sa fraîcheur et sa saveur, il relève les plats de l''été. C''est un réel plaisir de le cueillir selon ses besoins.'), 
	(215, 0, 'Descriptif', 'Web', 'La menthe est une plante aromatique très odorante qui parfume délicatement nos différents plats, mais aussi le thé, les infusions et les desserts. Au potager, elle éloigne de nombreux insectes. De culture facile, elle demande peu d''entretien.'), 
	(216, 0, 'Image', 'Web', 'assets/images/mais_1.PNG'), 
	(217, 0, 'Image2', 'Web', 'assets/images/mais_2.PNG'),
	(218, 0, 'Image3', 'Web', 'assets/images/mais_3.jpg'),
	(219, 0, 'Image', 'Web', 'assets/images/haricot_1.PNG'), 
	(220, 0, 'Image2', 'Web', 'assets/images/haricot_2.PNG'),
	(221, 0, 'Image3', 'Web', 'assets/images/haricot_3.PNG'),
	(222, 0, 'Image', 'Web', 'assets/images/courge_1.jpg'), 
	(223, 0, 'Image2', 'Web', 'assets/images/courge_2.jpg'),
	(224, 0, 'Image3', 'Web', 'assets/images/courge_3.jpg'),
	(225, 0, 'Image', 'Web', 'assets/images/tomate_1.jpg'), 
	(226, 0, 'Image2', 'Web', 'assets/images/tomate_2.PNG'),
	(227, 0, 'Image3', 'Web', 'assets/images/tomate_3.PNG'),
	(228, 0, 'Image', 'Web', 'assets/images/carotte_1.PNG'), 
	(229, 0, 'Image2', 'Web', 'assets/images/carotte_2.jpg'),
	(230, 0, 'Image3', 'Web', 'assets/images/carotte_3.jpg'),
	(231, 0, 'Image', 'Web', 'assets/images/oignon_1.PNG'),
	(232, 0, 'Image2', 'Web', 'assets/images/oignon_2.PNG'),
	(233, 0, 'Image', 'Web', 'assets/images/fraise_1.png'),
	(234, 0, 'Image2', 'Web', 'assets/images/fraise_2.PNG'),
	(235, 0, 'Image3', 'Web', 'assets/images/fraise_3.PNG'),
	(236, 0, 'Image', 'Web', 'assets/images/chouFleur_1.jpg'),
	(237, 0, 'Image2', 'Web', 'assets/images/chouFleur_2.PNG'),
	(238, 0, 'Image3', 'Web', 'assets/images/chouFleur_3.PNG'),
	(239, 0, 'Image', 'Web', 'assets/images/basilic_1.jpg'),
	(240, 0, 'Image2', 'Web', 'assets/images/basilic_2.jpg'),
	(243, 0, 'Image', 'Web', 'assets/images/menthe_1.jpg'),
	(244, 0, 'Image2', 'Web', 'assets/images/menthe_2.PNG'), 
	(245, 0, 'Image', 'Web', 'assets/images/coccinelle.jpg'),
	(246, 0, 'NomLatin', 'Faune', 'Coccinellidae'),
	(247, 0, 'Image', 'Web', 'assets/images/abeille.jpg'),
	(248, 0, 'NomLatin', 'Faune', 'Apis mellifera'), 
	(249, 0, 'Image', 'Web', 'assets/images/etourneau.jpg'),
	(250, 0, 'NomLatin', 'Faune', 'Sturnus vulgaris'),
	(251, 0, 'Image', 'Web', 'assets/images/mesange.jpg'),
	(252, 0, 'NomLatin', 'Faune', 'Cyanistes caeruleus'),
	(253, 0, 'Image', 'Web', 'assets/images/papillon.jpg'),
	(254, 0, 'NomLatin', 'Faune', 'Lepidoptera'),
	(255, 0, 'Image', 'Web', 'assets/images/puceron.PNG'),
	(256, 0, 'NomLatin', 'Faune', 'Aphidoidea'),
	(257, 0, 'Image', 'Web', 'assets/images/souris.jpg'),
	(258, 0, 'NomLatin', 'Faune', 'Mus musculus'),
	(259, 0, 'Image', 'Web', 'assets/images/cetoine-doree.jpg'),
	(260, 0, 'NomLatin', 'Faune', 'Cetonia aurata'),
	(261, 0, 'Image', 'Web', 'assets/images/syrphe.jpg'),
	(262, 0, 'NomLatin', 'Faune', 'Syrphidae'),
	(263, 0, 'Image', 'Web', 'assets/images/carabe.jpg'),
	(264, 0, 'NomLatin', 'Faune', 'Carabus auratus'),
	(265, 0, 'Kompagne', 'Flore', 'Basilic'),
	(266, 0, 'Kompagne', 'Flore', 'Carotte'),
	(267, 0, 'Kompagne', 'Flore', 'Courge'),
	(268, 0, 'Kompagne', 'Flore', 'Chou-Fleur'),
	(269, 0, 'Kompagne', 'Flore', 'Fraise'),
	(270, 0, 'Kompagne', 'Flore', 'Haricot'),
	(271, 0, 'Kompagne', 'Flore', 'Maïs'),
	(272, 0, 'Kompagne', 'Flore', 'Menthe Poivrée'),
	(273, 0, 'Kompagne', 'Flore', 'Oignon'),
	(274, 0, 'Kompagne', 'Flore', 'Tomate'),
	(275, 0, 'Kompagne', 'Flore', 'Radis'),
	(276, 0, 'Kompagne', 'Flore', 'Laitue'),
	(277, 0, 'Kompagne', 'Flore', 'Bourrache'),
	(278, 0, 'Kompagne', 'Flore', 'Pomme de terre'),
	(279, 0, 'Kompagne', 'Flore', 'Betterave'),
	(280, 0, 'Kompagne', 'Flore', 'Framboise'),
	(281, 0, 'Ennemie', 'Flore', 'Basilic'),
	(282, 0, 'Ennemie', 'Flore', 'Carotte'),
	(283, 0, 'Ennemie', 'Flore', 'Courge'),
	(284, 0, 'Ennemie', 'Flore', 'Chou-Fleur'),
	(285, 0, 'Ennemie', 'Flore', 'Fraise'),
	(286, 0, 'Ennemie', 'Flore', 'Haricot'),
	(287, 0, 'Ennemie', 'Flore', 'Maïs'),
	(288, 0, 'Ennemie', 'Flore', 'Menthe Poivrée'),
	(289, 0, 'Ennemie', 'Flore', 'Oignon'),
	(290, 0, 'Ennemie', 'Flore', 'Tomate'),
	(291, 0, 'Ennemie', 'Flore', 'Radis'),
	(292, 0, 'Ennemie', 'Flore', 'Laitue'),
	(293, 0, 'Ennemie', 'Flore', 'Bourrache'),
	(294, 0, 'Ennemie', 'Flore', 'Pomme de terre'),
	(295, 0, 'Ennemie', 'Flore', 'Betterave'),
	(296, 0, 'Ennemie', 'Flore', 'Framboise'),
	(297, 0, 'Ennemie', 'Flore', 'Fenouil'),
	(298, 0, 'Ennemie', 'Flore', 'Poireau'),
	(299, 0, 'Ennemie', 'Flore', 'Ciboulette'),
	(300, 0, 'Ennemie', 'Flore', 'Asperge'),
	(301, 0, 'Ennemie', 'Flore', 'Concombre');



INSERT INTO compte_utilisateur (id, version, code_postal, complement, identifiant, informations_bancaires, mail, mot_de_passe, nom, prenom, rue, telephone, ville) 
	VALUES 
	(1,0, '33600', '', 'KevinBougis', 'Visa_Premier', 'kevin.bougis@gmail.com', 'cestmoilechef!', 'BOUGIS', 'Kévin','5 bis avenue Villemejan', '0625570704', 'PESSAC'), 
	(2,0, '33127', 'Maison D10', 'ManonCharles', 'Mastercard', 'charles.manon@yahoo.com', 'vivelehtml', 'CHARLES', 'Manon', '21 avenue Colonel Pierre Bourgoin', '0635244332', 'MARTIGNAS'), 
	(3,0, '33610', '', 'DamienDubreuil', 'Visa', 'dubreuil.damien@laposte.net', 'Admin_33!', 'DUBREUIL', 'Damien', '14 avenue du Parc', '0645872052', 'CANEJAN'), 
	(4,0, '33400', 'Résidence Emile Zola', 'CecileLarrouy', 'Mastercard', 'cecile.larrouy@outlook.fr', 'Gestion_npk!', 'LARROUY', 'Cécile', '93 Boulevard George V', '0608050400', 'TALENCE'),	
	(5,0, '33160', '', 'EricSultan', 'Visa_Premier', 'eric.sultan@gmail.com', 'aef52_Ui!', 'SULTAN', 'Eric', '4 rue de Corono', '0645104506', 'SAINT-MEDARD-EN-JALLES');
	

INSERT INTO commande (id, version, reference, total, type_envoi)
    VALUES 
    (1, 0, '1', 29.99, 'Colissimo'),
    (2, 0, '2', 12.99, 'MondialRelay');
	
		
INSERT INTO conseil (id, version, publication, nom, texte, theme)
	VALUES
	(1, 0, '2020-05-20','', '', '');
	
--max 95
INSERT INTO faune (id, version, nom_faune)
	VALUES 
	(1, 0, 'Abeille'), 
	(2, 0, 'Aleurode'),
	(3, 0, 'Altise'),
	(4, 0, 'Araignée'),
	(5, 0, 'Bombyle'),
	(6, 0, 'Bourdon'),
	(7, 0, 'Cétoine dorée'),
	(8, 0, 'Charançon'),
	(9, 0, 'Chenille'),
	(10, 0, 'Coccinelle'),-- Chasse le 30,45
	(11, 0, 'Coléoptère'),-- Chasse le 45
	(12, 0, 'Diptère'),
	(13, 0, 'Doryphore'),
	(14,0, 'Etourneau'),
	(15, 0, 'Fourmi'), 
	(16, 0, 'Frelon'),
	(17, 0, 'Gendarme'),
	(18, 0, 'Gobemouche'),
	(19, 0, 'Grillon'),
	(20, 0, 'Grimepreau'),
	(21, 0, 'Guêpe'),
	(22, 0, 'Limace'),
	(23, 0, 'Mésange'), 
	(24, 0, 'Moineau'), 
	(25, 0, 'Mouche'),
	(26, 0, 'Moustique'),
	(27, 0, 'Nématode'),
	(28, 0, 'Oedomère nombe'),
	(29, 0, 'Papillon'),
	(30, 0, 'Puceron'), 
	(31, 0, 'Punaise'),
	(32, 0, 'Scarabée'),
	(33, 0, 'Sitelle'),
	(34, 0, 'Sphinx Colibri'),
	(35, 0, 'Syrphe'),
	(36, 0, 'Teigne'),
	(37, 0, 'Troglodyte'),
	(38, 0, 'Vers'),
	(39,0,'Oscinie'),
	(40,0,'Pyrale du Maïs'),
	(41,0,'Trichogramme'),-- Chasse le 40
	(42,0,'Bruche'),
	(43,0,'Mouche des semis'),
	(44,0,'Escargot'),
	(45,0,'Tetranychus urticae'),
	(46,0,'Chrysomèle'),
	(47,0,'Corée marginée'),
	(48,0,'Piéride du chou'),
	(49,0,'Thrips'),
	(50,0,'Aleurodes'),
	(51,0,'Mineuse de la tomate'),
	(52,0,'Noctuelle de la tomate'),
	(53,0,'Encarsia formosa'),-- Chasse le 50
	(54,0,'Mouche de la carotte'),
	(55,0,'Noctuelle des moissons'),
	(56,0,'Noctuelle'),
	(57,0,'Mouche de l''oignon'),
	(58,0,'Teigne du poireau'),
	(59,0,'Scarabée japonais'),
	(60,0,'Carpocapse'),
	(61,0,'Lapin'),
	(62,0,'Punaise des courges'),
	(63,0,'Acarien'),
	(64,0,'Sphynx de la tomate'),
	(65,0,'Piéride de la rave'),
	(66,0,'Fausse-arpenteuse du chou'),
	(67,0,'Mouche du chou'),
	(68,0,'Souris'),
	(69,0,'Criocère de l''asperge'),
	(70,0,'Vers des choux'),
	(71,0,'Blatte'),
	(72,0,'Tique'),
	(73,0,'Poisson d''argent'),
	(74,0,'Poux'),
	(75,0,'Punaise des lits'),
	(76,0,'Puce'),
	(77,0,'Ver de l''épi du maïs'),
	(78,0,'Taupe'),
	(79,0,'Campagnol'),
	(80,0,'Marmotte'),
	(81,0,'Papillon de nuit'),
	(82,0,'Cicadelle'),
	(83,0,'Rongeur'),
	(84,0,'Chrysomèle du concombre'),
	(85,0,'Vers gris'),
	(86,0,'Taupin'),
	(87,0,'Blaniulus guttulatus'),
	(88,0,'Oiseau'),
	(89,0,'Loir'),
	(90,0,'Renard'),
	(91,0,'Blaireau'),
	(92,0,'Fouine'),
	(93,0,'Cécidomyie'),
	(94,0,'Mineuse du basilic'), 
	(95, 0, 'Carabe');
	
INSERT INTO favoris (id, version, nom)
		VALUES 
		(1, 0, '');
		
INSERT INTO flore (id, version, nom)
	VALUES 
	(1, 0, 'Abricot'), 
	(2, 0, 'Absinthe'),
	(3, 0, 'Achilée'),
	(4, 0, 'Ail'),
	(5, 0, 'Alysse'),
	(6, 0, 'Aneth'),
	(7, 0, 'Artichaut'),
	(8, 0, 'Asperge'),
	(9, 0, 'Aubergine'),
	(10, 0, 'Basilic'),
	(11, 0, 'Betterave'),
	(12, 0, 'Bette (Blette, Poirée)'),
	(13, 0, 'Bourrache'),
	(14,0, 'Camomille'),
	(15, 0, 'Capucine'), 
	(16, 0, 'Carotte'),
	(17, 0, 'Céleri'),
	(18, 0, 'Cerfeuil'),
	(19, 0, 'Chataigne'),
	(20, 0, 'Chou'),
	(21, 0, 'Chou-Fleur'),
	(22, 0, 'Chou-rave'),
	(23, 0, 'Chrysanthème'), 
	(24, 0, 'Ciboulette'), 
	(25, 0, 'Concombre'),
	(26, 0, 'Coriandre'),
	(27, 0, 'Cornichon'),
	(28, 0, 'Cosmos'),
	(29, 0, 'Courge'),
	(30, 0, 'Courgette'), 
	(31, 0, 'Cresson'),
	(32, 0, 'Echalotte'),
	(33, 0, 'Epinard'),
	(34, 0, 'Euphorne'),
	(35, 0, 'Fenouil'),
	(36, 0, 'Fève'),
	(37, 0, 'Figue'),
	(38, 0, 'Fraise'),
	(39, 0, 'Framboise'),
	(40, 0, 'Genêt'),
	(41, 0, 'Giroflée'),
	(42, 0, 'Groseille'),
	(43, 0, 'Haricot'),
	(44, 0, 'Hysope'),
	(45, 0, 'Jacinthe'),
	(46, 0, 'Laitue'),
	(47, 0, 'Lavande'),
	(48, 0, 'Lupin'),
	(49, 0, 'Mâche'),
	(50, 0, 'Maïs'),
	(51, 0, 'Melon'),
	(52, 0, 'Menthe Poivrée'),
	(53, 0, 'Merisier'),
	(54, 0, 'Micocoulier'),
	(55, 0, 'Moutarde'),
	(56, 0, 'Mûre'),
	(57, 0, 'Myosotis'),
	(58, 0, 'Navet'),
	(59, 0, 'Noisette'),
	(60, 0, 'Œillets d''Inde (Tagète Pétula)'),
	(61, 0, 'Oignon'),
	(62, 0, 'Origan '),
	(63, 0, 'Orme'),
	(64, 0, 'Panais'),
	(65, 0, 'Pastèque'),
	(66, 0, 'Pêche'),
	(67, 0, 'Persil'),
	(68, 0, 'Phacélie'),
	(69, 0, 'Poire'),
	(70, 0, 'Poireau'),
	(71, 0, 'Pois'),
	(72, 0, 'Poivrons'),
	(73, 0, 'Pomme'),
	(74, 0, 'Pomme de terre'),
	(75, 0, 'Primevère'),
	(76, 0, 'Prune'),
	(77, 0, 'Radis'),
	(78, 0, 'Raisin'),
	(79, 0, 'Romarin'),
	(80, 0, 'Rose'),
	(81, 0, 'Sarriette'),
	(82, 0, 'Sarrrasin'),
	(83, 0, 'Sauge'),
	(84, 0, 'Souci (Calendula)'),
	(85, 0, 'Sureau'),
	(86, 0, 'Tanaisie'),
	(87, 0, 'Thym'),
	(88, 0, 'Tomate'),
	(89, 0, 'Tournesol'),
	(90, 0, 'Armoise'),
	(91,0,'Mirabilis'),
	(92,0,'Cataire'),
	(93,0,'Citronnelle'),
	(94,0,'Lantana camara'),
	(95,0,'Dahlia'),
	(96,0,'Dauphinelle'),
	(97,0,'Eucalyptus'),
	(98,0,'Fritillaire impériale'),
	(99,0,'Géranium'),
	(100,0,'Mélisse'),
	(101,0,'Menthe verte'),
	(111,0,'Narcisse'),
	(102,0,'Jonquille'),
	(103,0,'Pétunia'),
	(104,0,'Ricin'),
	(105,0,'Rose d''Inde'),
	(106,0,'Rue'),
	(107,0,'Amarante épineuse'),
	(108,0,'Tabac'),
	(109,0,'Thym citron'),
	(110,0,'Trèfle');	
	
	-- max 539
	INSERT INTO referentiel_caracteristique (id, version, caracteristique_id,flore_id)
	VALUES
	-- Maïs--
	(1, 0, 2,50),
	(2, 0, 3,50),
	(3, 0, 6,50),
	(4, 0, 9,50),
	(5, 0, 12,50),
	(6, 0, 13,50),
	(7, 0, 23,50),
	(8, 0, 33,50),
	(9, 0, 36,50),
	(10, 0, 41,50),
	(11, 0, 54,50),
	(12, 0, 67,50),
	(13, 0, 68,50),
	(14, 0, 70,50),
	(15, 0, 71,50),
	(16, 0, 79,50),
	(396, 0, 80, 50),
	(397, 0, 81, 50),
	(398, 0, 82, 50),
	(18, 0, 107,50),
	(399, 0, 108,50),
	(400, 0, 109,50),
	(401, 0, 110,50),
	(20, 0, 126,50),
	(21, 0, 134,50),
	(22, 0, 136,50),
	(23, 0, 138,50),
	(24, 0, 142,50),
	(25, 0, 143,50),
	(26, 0, 144,50),
	(27, 0, 145,50),
	(28, 0, 146,50),
	(29, 0, 147,50),
	(30, 0, 152,50),
	(31, 0, 153,50),
	(59, 0, 164,50),
	(60, 0, 44,50),
	(339, 0, 196, 50),
	(349, 0, 206, 50), 
	(359, 0, 216, 50), 
	(360, 0, 217, 50), 
	(361, 0, 218, 50), 
	(386, 0, 195, 50),
	(490, 0, 270, 50),
	(491, 0, 267, 50),
	(492, 0, 278, 50), 
	(493, 0, 290, 50),  	
	
	-- Haricot--
	(32, 0, 2,43),
	(33, 0, 3,43),
	(34, 0, 6,43),
	(35, 0, 8,43),
	(36, 0, 13,43),
	(37, 0, 27,43),
	(38, 0, 33,43),
	(39, 0, 34,43),
	(40, 0, 41,43),
	(41, 0, 67,43),
	(42, 0, 68,43),
	(43, 0, 70,43),
	(44, 0, 71,43),
	(45, 0, 74,43),
	(46, 0, 80,43),
	(402, 0, 81,43),
	(403, 0, 82,43),
	(404, 0, 83,43),
	(405, 0, 84,43),
	(48, 0, 106,43),
	(406, 0, 107,43),
	(407, 0, 108,43),
	(408, 0, 109,43),
	(50, 0, 126,43),
	(51, 0, 134,43),
	(52, 0, 136,43),
	(53, 0, 138,43),
	(54, 0, 148,43),
	(55, 0, 149,43),
	(56, 0, 151,43),
	(57, 0, 153,43),
	(58, 0, 43,43),
	(340, 0, 197, 43),
	(350, 0, 207, 43), 
	(362, 0, 219, 43), 
	(363, 0, 220, 43), 
	(364, 0, 221, 43),
	(387, 0, 64, 43), 
	(494, 0, 266, 43),
	(495, 0, 267, 43),
	(496, 0, 271, 43),
	(497, 0, 289, 43),
	(498, 0, 299, 43),
	(499, 0, 295, 43),
	
	-- Courge--
	(61, 0, 2,29),
	(62, 0, 3,29),
	(63, 0, 4,29),
	(64, 0, 11,29),
	(65, 0, 13,29),
	(66, 0, 25,29),
	(67, 0, 33,29),
	(68, 0, 36,29),
	(69, 0, 39,29),
	(70, 0, 41,29),
	(71, 0, 43,29),
	(73, 0, 67,29),
	(74, 0, 68,29),
	(75, 0, 69,29),
	(76, 0, 70,29),
	(77, 0, 71,29),
	(78, 0, 74,29),
	(79, 0, 81,29),
	(409, 0, 82,29),
	(81, 0, 107,29),
	(410, 0, 108,29),
	(411, 0, 109,29),
	(412, 0, 110,29),
	(83, 0, 126,29),
	(84, 0, 132,29),
	(85, 0, 137,29),
	(86, 0, 138,29),
	(87, 0, 154,29),
	(88, 0, 155,29),
	(89, 0, 156,29),
	(90, 0, 157,29),
	(91, 0, 158,29),
	(92, 0, 159,29),
	(93, 0, 28,29),
	(341, 0, 198, 29),
	(351, 0, 208, 29), 
	(365, 0, 222, 29),
	(366, 0, 223, 29),
	(367, 0, 224, 29),	
	(388, 0, 64, 29), 
	(500, 0, 270, 29),
	(501, 0, 271, 29),
	(502, 0, 276, 29),
	(503, 0, 291, 29),
	(504, 0, 294, 29),
	(505, 0, 297, 29),
	
	-- Tomate--
	(94, 0, 2,88),
	(95, 0, 3,88),
	(96, 0, 4,88),
	(97, 0, 6,88),
	(98, 0, 7,88),
	(99, 0, 8,88),
	(100, 0, 11,88),
	(101, 0, 12,88),
	(102, 0, 13,88),
	(103, 0, 23,88),
	(104, 0, 33,88),
	(105, 0, 36,88),
	(106, 0, 39,88),
	(107, 0, 41,88),
	(108, 0, 43,88),
	(109, 0, 67,88),
	(110, 0, 68,88),
	(111, 0, 69,88),
	(112, 0, 70,88),
	(113, 0, 71,88),
	(114, 0, 74,88),
	(115, 0, 78,88),
	(413, 0, 79,88),
	(414, 0, 80,88),
	(415, 0, 81,88),
	(117, 0, 106,88),
	(416, 0, 107,88),
	(417, 0, 108,88),
	(418, 0, 109,88),
	(419, 0, 110,88),
	(119, 0, 126,88),
	(120, 0, 133,88),
	(121, 0, 134,88),
	(122, 0, 136,88),
	(123, 0, 138,88),
	(124, 0, 153,88),
	(125, 0, 159,88),
	(126, 0, 161,88),
	(127, 0, 162,88),
	(128, 0, 163,88),
	(195, 0, 175,88),
	(342, 0, 199, 88), 
	(352, 0, 209, 88), 
	(368, 0, 225, 88), 
	(369, 0, 226, 88),
	(370, 0, 227, 88),
	(389, 0, 63, 88),
	(506, 0, 265, 88),
	(507, 0, 266, 88),
	(508, 0, 273, 88),
	(509, 0, 294, 88),
	(510, 0, 295, 88),
	(511, 0, 301, 88),
	
	--Carotte--
	(129, 0, 2,16),
	(130, 0, 3,16),
	(131, 0, 5,16),
	(132, 0, 6,16),
	(133, 0, 9,16),
	(134, 0, 13,16),
	(135, 0, 14,16),
	(136, 0, 24,16),
	(137, 0, 31,16),
	(138, 0, 35,16),
	(139, 0, 38,16),
	(140, 0, 41,16),
	(141, 0, 42,16),
	(142, 0, 67,16),
	(143, 0, 68,16),
	(144, 0, 69,16),
	(145, 0, 70,16),
	(146, 0, 71,16),
	(147, 0, 78,16),
	(420, 0, 79,16),
	(421, 0, 80,16),
	(422, 0, 81,16),
	(423, 0, 82,16),
	(149, 0, 106,16),
	(424, 0, 107,16),
	(425, 0, 108,16),
	(426, 0, 109,16),
	(427, 0, 110,16),
	(428, 0, 111,16),
	(151, 0, 126,16),
	(152, 0, 132,16),
	(153, 0, 136,16),
	(154, 0, 140,16),
	(155, 0, 153,16),
	(156, 0, 159,16),
	(157, 0, 165,16),
	(158, 0, 166,16),
	(159, 0, 167,16),
	(160, 0, 168,16),
	(343, 0, 200, 16), 
	(353, 0, 210, 16),
	(371, 0, 228, 16), 
	(372, 0, 229, 16), 
	(373, 0, 230, 16), 
	(390, 0, 64, 16),
	(512, 0, 273, 16),
	(513, 0, 274, 16),
	(514, 0, 275, 16),
	(515, 0, 288, 16),
	(516, 0, 295, 16),
	
	--Oignon--
	(161, 0, 3,61),
	(162, 0, 4,61),
	(163, 0, 5,61),
	(164, 0, 6,61),
	(165, 0, 9,61),
	(166, 0, 13,61),
	(167, 0, 14,61),
	(168, 0, 23,61),
	(169, 0, 29,61),
	(170, 0, 32,61),
	(171, 0, 35,61),
	(172, 0, 39,61),
	(173, 0, 41,61),
	(174, 0, 42,61),
	(175, 0, 67,61),
	(176, 0, 68,61),
	(177, 0, 69,61),
	(178, 0, 70,61),
	(179, 0, 71,61),
	(180, 0, 78,61),
	(429, 0, 79, 61), 
	(430, 0, 80, 61), 
	(431, 0, 81, 61), 
	(432, 0, 84, 61), 
	(433, 0, 85, 61), 
	(434, 0, 86, 61),
	(435, 0, 87, 61), 	
	(184, 0, 105,61),
	(436, 0, 106, 61),
	(437, 0, 107, 61),
	(438, 0, 108, 61),
	(439, 0, 109, 61),
	(440, 0, 110, 61),
	(441, 0, 111, 61),
	(186, 0, 126,61),
	(187, 0, 135,61),
	(188, 0, 139,61),
	(189, 0, 140,61),
	(190, 0, 150,61),
	(191, 0, 168,61),
	(192, 0, 169,61),
	(193, 0, 170,61),
	(194, 0, 171,61),
	(196, 0, 175,61),
	(344, 0, 201, 61),
	(354, 0, 211, 61),
	(374, 0, 231, 61),
	(375, 0, 232, 61),
	(391, 0, 64, 61), 
	(517, 0, 266, 61),
	(518, 0, 276, 61),
	(519, 0, 279, 61),
	(520, 0, 286, 61),
	(521, 0, 294, 61),
	(522, 0, 300, 61),
	
	--Fraisier--
	(197, 0, 1,38),
	(198, 0, 2,38),
	(199, 0, 3,38),
	(200, 0, 6,38),
	(201, 0, 9,38),
	(202, 0, 13,38),
	(203, 0, 14,38),
	(204, 0, 25,38),
	(205, 0, 29,38),
	(206, 0, 32,38),
	(207, 0, 35,38),
	(208, 0, 38,38),
	(209, 0, 40,38),
	(210, 0, 67,38),
	(211, 0, 68,38),
	(212, 0, 69,38),
	(213, 0, 70,38),
	(214, 0, 71,38),
	(215, 0, 72,38),
	(216, 0, 79,38),
	(488, 0, 80,38),
	(442, 0, 84,38),
	(443, 0, 85,38),
	(444, 0, 86,38),
	(220, 0, 105,38),
	(445, 0, 106, 38),
	(446, 0, 107, 38),
	(447, 0, 108, 38),
	(448, 0, 109, 38),
	(449, 0, 110, 38),
	(222, 0, 126,38),
	(223, 0, 132,38),
	(224, 0, 136,38),
	(225, 0, 140,38),
	(226, 0, 143,38),
	(227, 0, 159,38),
	(228, 0, 173,38),
	(229, 0, 174,38),
	(345, 0, 202, 38),
	(355, 0, 212, 38),
	(376, 0, 233, 38), 
	(377, 0, 234, 38), 
	(378, 0, 235, 38), 
	(392, 0, 63, 38),
	(523, 0, 270, 38),
	(524, 0, 274, 38),
	(525, 0, 277, 38),
	(526, 0, 289, 38),
	(527, 0, 295, 38),
	(528, 0, 298, 38),
	
	--Chou-Fleur-
	(230, 0, 3,21),
	(231, 0, 4,21),
	(232, 0, 5,21),
	(233, 0, 7,21),
	(234, 0, 10,21),
	(235, 0, 11,21),
	(236, 0, 13,21),
	(237, 0, 14,21),
	(238, 0, 23,21),
	(239, 0, 32,21),
	(240, 0, 35,21),
	(241, 0, 41,21),
	(242, 0, 42,21),
	(243, 0, 43,21),
	(244, 0, 67,21),
	(245, 0, 68,21),
	(246, 0, 69,21),
	(247, 0, 70,21),
	(248, 0, 71,21),
	(249, 0, 74,21),
	(250, 0, 77,21),
	(450, 0, 78, 21),
	(451, 0, 79, 21),
	(452, 0, 80, 21),
	(453, 0, 81, 21),
	(454, 0, 82, 21),
	(455, 0, 83, 21),
	(456, 0, 84, 21),
	(457, 0, 85, 21),
	(252, 0, 101,21),
	(458, 0, 102,21),
	(459, 0, 103,21),
	(460, 0, 104,21),
	(461, 0, 105,21),
	(462, 0, 106,21),
	(463, 0, 107,21),
	(464, 0, 108,21),
	(465, 0, 109,21),
	(489, 0, 110,21),
	(466, 0, 111,21),
	(467, 0, 112,21),
	(254, 0, 126,21),
	(255, 0, 127,21),
	(256, 0, 132,21),
	(257, 0, 133,21),
	(258, 0, 137,21),
	(259, 0, 139,21),
	(260, 0, 153,21),
	(261, 0, 159,21),
	(262, 0, 164,21),
	(263, 0, 169,21),
	(264, 0, 175,21),
	(265, 0, 177,21),
	(266, 0, 178,21),
	(267, 0, 179,21),
	(346, 0, 203, 21), 
	(356, 0, 213, 21),
	(379, 0, 236, 21), 
	(380, 0, 237, 21), 
	(381, 0, 238, 21),
	(393, 0, 64, 21), 
	(529, 0, 270, 21), 
	(530, 0, 272, 21), 
	(531, 0, 285, 21), 
	(532, 0, 289, 21), 
	(533, 0, 290, 21), 
	
	--Basilic-
	(268, 0, 2,10),
	(269, 0, 3,10),
	(270, 0, 6,10),
	(271, 0, 11,10),
	(272, 0, 13,10),
	(273, 0, 14,10),
	(274, 0, 17,10),
	(275, 0, 24,10),
	(276, 0, 32,10),
	(277, 0, 35,10),
	(278, 0, 38,10),
	(279, 0, 41,10),
	(280, 0, 67,10),
	(281, 0, 68,10),
	(282, 0, 69,10),
	(283, 0, 70,10),
	(284, 0, 71,10),
	(285, 0, 76,10),
	(286, 0, 78,10),
	(468, 0, 79, 10),
	(469, 0, 80, 10),
	(470, 0, 81, 10),
	(471, 0, 82, 10),
	(472, 0, 83, 10),
	(288, 0, 106,10),
	(473, 0, 107,10),
	(474, 0, 108,10),
	(475, 0, 109,10),
	(476, 0, 110,10),
	(477, 0, 111,10),
	(290, 0, 126,10),
	(291, 0, 132,10),
	(292, 0, 133,10),
	(293, 0, 136,10),
	(294, 0, 138,10),
	(295, 0, 153,10),
	(296, 0, 159,10),
	(297, 0, 164,10),
	(298, 0, 180,10),
	(299, 0, 181,10),
	(300, 0, 182,10),
	(301, 0, 183,10),
	(347, 0, 204, 10), 
	(357, 0, 214, 10), 
	(382, 0, 239, 10), 
	(383, 0, 240, 10),
	(394, 0, 65, 10),
	(534, 0, 267, 10),	
	(535, 0, 268, 10),
	(536, 0, 274, 10),
	
	--Menthe Poivrée-
	(302, 0, 1,52),
	(303, 0, 2,52),
	(304, 0, 3,52),
	(305, 0, 7,52),
	(306, 0, 8,52),
	(307, 0, 10,52),
	(308, 0, 11,52),
	(309, 0, 13,52),
	(310, 0, 14,52),
	(311, 0, 17,52),
	(312, 0, 23,52),
	(313, 0, 30,52),
	(314, 0, 33,52),
	(315, 0, 35,52),
	(316, 0, 36,52),
	(317, 0, 39,52),
	(318, 0, 38,52),
	(319, 0, 40,52),
	(320, 0, 51,52),
	(321, 0, 56,52),
	(322, 0, 67,52),
	(323, 0, 68,52),
	(324, 0, 69,52),
	(325, 0, 70,52),
	(326, 0, 71,52),
	(327, 0, 76,52),
	(478, 0, 80, 52), 
	(479, 0, 81, 52),
	(480, 0, 103, 52),
	(481, 0, 104, 52),
	(482, 0, 105, 52),
	(483, 0, 106, 52),
	(484, 0, 107, 52),
	(485, 0, 108, 52),
	(486, 0, 109, 52),
	(487, 0, 110, 52),
	(328, 0, 126,52),
	(329, 0, 127,52),
	(330, 0, 132,52),
	(331, 0, 136,52),
	(332, 0, 140,52),
	(333, 0, 159,52),
	(334, 0, 180,52),
	(335, 0, 184,52),
	(336, 0, 185,52),
	(337, 0, 186,52),
	(338, 0, 187,52),
	(348, 0, 205, 52), 
	(358, 0, 215, 52),
	(384, 0, 243, 52), 
	(385, 0, 244, 52), 
	(395, 0, 65, 52),
	(537, 0, 268, 52),
	(538, 0, 280, 52),
	(539, 0, 282, 52);
	
	--liens faune-faune----(max 226)--
	INSERT INTO referentiel_faune (id, version, caracteristique_id,faune_id)
	VALUES
	--Coccinelle--predateur
	(197, 0,188,10),
	(198, 0,190,10),
	(207, 0, 245, 10),
	(208, 0, 246, 10),
	
	--Puceron--chassé
	(199, 0, 189, 30),
	(217, 0, 255, 30),
	(218, 0, 256, 30),
	
	--Tetranychus urticae--chassé
	(200, 0, 189, 45),
	(201, 0, 191, 45),
	(202, 0, 192, 45),
	
	--Coléoptère--prédateur
	(203, 0, 190, 11),
	
	--Trichogramme--prédateur
	(204, 0, 190, 41),
	
	--Encarsia formosa--prédateur
	(205, 0, 194, 53),
	
	--Aleurodes--chassé
	(206, 0, 193, 50), 
	
	--Abeille
	(209, 0, 247, 1),
	(210, 0, 248, 1),
	
	--Etourneau
	(211, 0, 249, 14),
	(212, 0, 250, 14),
	
	--Mesange
	(213, 0, 251, 23),
	(214, 0, 252, 23),
	
	--Papillon
	(215, 0, 253, 29),
	(216, 0, 254, 29),
	
	--Souris
	(219, 0, 257, 68),
	(220, 0, 258, 68),
	
	--Cétoine dorée
	(221, 0, 259, 7),
	(222, 0, 260, 7),
	
	--Syrphe
	(223, 0, 261, 35),
	(224, 0, 262, 35),
	
	--Carabe
	(225, 0, 263, 95),
	(226, 0, 264, 95);
	
	
	--lien faune-flore--
	INSERT INTO referentiel_faune (id, version, caracteristique_id,faune_id,flore_id)
	VALUES
	-- Maïs--nuisibles
	(1, 0,46,39,50),
	(2, 0,46,40,50),
	(3, 0,46,46,50),
	(40, 0,46,77,50),
	-- Haricot--nuisibles
	(4, 0,46,22,43),
	(5, 0,46,30,43),
	(6, 0,46,42,43),
	(7, 0,46,43,43),
	(8, 0,46,44,43),
	(9, 0,46,45,43),
	-- Courge--nuisibles
	(10, 0,46,22,29),
	(11, 0,46,44,29),
	(12, 0,46,47,29),
	--Menthe Poivrée--nuisibles
	(194, 0,46,9,52),
	(195, 0,46,27,52),
	(196, 0,46,63,52),
	--Menthe Poivrée--repulsif
	(13, 0,47,47,52),
	(14, 0,47,48,52),
	(15, 0,47,3,52),
	(16, 0,47,30,52),
	(17, 0,47,15,52),
	(42, 0,47,2,52),
	(43, 0,47,62,52),
	(44, 0,47,65,52),
	--Oeillet d'inde--repulsif
	(18, 0,47,47,60),
	(27, 0,47,27,60),
	(41, 0,47,2,60),
	--Bourrache--repulsif
	(19, 0,47,22,13),
	(45, 0,47,64,13),
	(46, 0,47,70,13),
	--Tomate--nuisibles
	(20, 0,46,22,88),
	(21, 0,46,27,88),
	(22, 0,46,30,88),
	(23, 0,46,49,88),
	(24, 0,46,50,88),
	(25, 0,46,51,88),
	(26, 0,46,52,88),
	(39, 0,46,64,88),
	--Tomate--nuisibles
	(139, 0,47,69,88),
	--Pois--répulsif
	(28, 0,47,48,71),
	--Carotte--nuisibles
	(29, 0,46,22,16),
	(30, 0,46,27,16),
	(31, 0,46,30,16),
	(32, 0,46,54,16),
	(33, 0,46,55,16),
	(34, 0,46,56,16),
	--Oignon--nuisibles
	(35, 0,46,27,61),
	(36, 0,46,57,61),
	(37, 0,46,58,61),
	--Oignon--Répulsif
	(38, 0,47,54,61),
	(47, 0,47,61,61),
	(48, 0,47,65,61),
	--Ail--Répulsif
	(49, 0,47,30,4),
	(50, 0,47,43,4),
	(51, 0,47,54,4),
	(52, 0,47,59,4),
	(53, 0,47,60,4),
	(54, 0,47,61,4),
	--Aneth--Répulsif
	(55, 0,47,30,6),
	(56, 0,47,62,6),
	(57, 0,47,63,6),
	(58, 0,47,64,6),
	(59, 0,47,65,6),
	--Armoise--Répulsif
	(60, 0,47,2,90),
	(61, 0,47,3,90),
	(62, 0,47,15,90),
	(63, 0,47,48,90),
	(64, 0,47,54,90),
	(65, 0,47,60,90),
	(66, 0,47,65,90),
	(67, 0,47,66,90),
	(68, 0,47,67,90),
	(69, 0,47,68,90),
	--Basilic--Nuisibles
	(190, 0,46,22,10),
	(191, 0,46,44,10),
	(192, 0,46,49,10),
	(193, 0,46,94,10),
	--Basilic--Répulsif
	(70, 0,47,2,10),
	(71, 0,47,25,10),
	(72, 0,47,26,10),
	(73, 0,47,54,10),
	(74, 0,47,69,10),
	--Cataire--Répulsif
	(75, 0,47,3,92),
	(76, 0,47,8,92),
	(77, 0,47,13,92),
	(78, 0,47,15,92),
	(79, 0,47,30,92),
	(80, 0,47,59,92),
	(81, 0,47,62,92),
	(82, 0,47,71,92),
	--Capucine--Répulsif
	(83, 0,47,2,15),
	(84, 0,47,11,15),
	(85, 0,47,30,15),
	(86, 0,47,62,15),
	--Ciboulette--Répulsif
	(87, 0,47,30,24),
	(88, 0,47,54,24),
	(89, 0,47,59,24),
	--Chrysanthème--Répulsif
	(90, 0,47,15,23),
	(91, 0,47,27,23),
	(92, 0,47,59,23),
	(93, 0,47,71,23),
	(94, 0,47,72,23),
	(95, 0,47,73,23),
	(96, 0,47,74,23),
	(97, 0,47,75,23),
	(98, 0,47,76,23),
	--Lantana camara--Répulsif
	(99, 0,47,26,94),
	--Coriandre--Répulsif
	(100, 0,47,13,26),
	(101, 0,47,30,26),
	(102, 0,47,63,26),
	--Cosmos--Répulsif
	(103, 0,47,77,28),
	--Dahlia--Répulsif
	(104, 0,47,27,95),
	--Dauphinelle--Répulsif
	(105, 0,47,30,96),
	--Eucalyptus--Répulsif
	(106, 0,47,13,97),
	(107, 0,47,30,97),
	--Fenouil--Répulsif
	(108, 0,47,22,35),
	(109, 0,47,30,35),
	(110, 0,47,44,35),
	--Fritillaire impériale--Répulsif
	(111, 0,47,61,98),
	(112, 0,47,68,98),
	(113, 0,47,78,98),
	(114, 0,47,79,98),
	(115, 0,47,80,98),
	--Laitue--Répulsif
	(116, 0,47,54,46),
	--Lavande--Répulsif
	(117, 0,47,25,47),
	(118, 0,47,26,47),
	(119, 0,47,76,47),
	(120, 0,47,81,47),
	--Mélisse--Répulsif
	(121, 0,47,26,100),
	--Mirabilis--Répulsif
	(122, 0,47,26,91),
	--Menthe verte--Répulsif
	(123, 0,47,11,101),
	(124, 0,47,15,101),
	(125, 0,47,30,101),
	(126, 0,47,62,101),
	(127, 0,47,76,101),
	(128, 0,47,81,101),
	(129, 0,47,83,101),
	--Narcisse--Répulsif
	(130, 0,47,78,111),
	--Jonquille--Répulsif
	(131, 0,47,78,102),
	--Persil--Répulsif
	(132, 0,47,69,67),
	--Pétunia--Répulsif
	(133, 0,47,30,103),
	(134, 0,47,62,103),
	(135, 0,47,64,103),
	(136, 0,47,69,103),
	(137, 0,47,82,103),
	--Poireau--Répulsif
	(138, 0,47,54,70),
	--Radis--Répulsif
	(140, 0,47,67,77),
	(141, 0,47,84,77),
	--Ricin--Répulsif
	(142, 0,47,78,104),
	--Romarin--Répulsif
	(143, 0,47,22,79),
	(144, 0,47,44,79),
	(145, 0,47,54,79),
	--Rose d'Inde--Répulsif
	(146, 0,47,61,105),
	--Rue--Répulsif
	(147, 0,47,3,106),
	(148, 0,47,84,106),
	--Amarante épineuse--Répulsif
	(149, 0,47,85,107),
	--Sarriette--Répulsif
	(150, 0,47,42,81),
	--Tabac--Répulsif
	(151, 0,47,3,108),
	--Tabac--Répulsif
	(152, 0,47,54,108),
	--Tanaisie--Répulsif
	(153, 0,47,11,86),
	(154, 0,47,15,86),
	(155, 0,47,25,86),
	(156, 0,47,48,86),
	(157, 0,47,62,86),
	(158, 0,47,65,86),
	(159, 0,47,85,86),
	--Thym--Répulsif
	(160, 0,47,2,87),
	(161, 0,47,64,87),
	(162, 0,47,65,87),
	(163, 0,47,67,87),
	(164, 0,47,77,87),
	--Trèfle--Répulsif
	(165, 0,47,30,110),
	(166, 0,47,86,110),
	--Fraise--nuisibles
	(167, 0,46,11,38),
	(168, 0,46,15,38),
	(169, 0,46,16,38),
	(170, 0,46,21,38),
	(171, 0,46,22,38),
	(172, 0,46,27,38),
	(173, 0,46,30,38),
	(174, 0,46,44,38),
	(175, 0,46,56,38),
	(176, 0,46,78,38),
	(177, 0,46,87,38),
	(178, 0,46,88,38),
	(179, 0,46,89,38),
	(180, 0,46,90,38),
	(181, 0,46,91,38),
	(182, 0,46,92,38),
	--Chou Fleur--nuisibles
	(183, 0,46,3,21),
	(184, 0,46,22,21),
	(185, 0,46,44,21),
	(186, 0,46,48,21),
	(187, 0,46,56,21),
	(188, 0,46,67,21),
	(189, 0,46,93,21);
	
ALTER SEQUENCE hibernate_sequence START 2000;

	