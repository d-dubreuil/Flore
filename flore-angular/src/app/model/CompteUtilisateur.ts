import {Historique} from './Historique';
import {Utilisateur} from './Utilisateur';
import {ReferentielUtilisateur} from './ReferentielUtilisateur';
import {Favoris} from './Favoris';
import {Jardin} from './Jardin';

export class CompteUtilisateur {
  id: number;
  version: number;
  identifiant: string;
  motDePasse: string;
  mail: string;
  nom: string;
  prenom: string;
  rue: string;
  complement: string;
  codePostal: string;
  ville: string;
  telephone: string;
  historiques: Array<Historique>;
  utilisateur: Utilisateur;
  referentielUtiliseurs: Array<ReferentielUtilisateur>;
  favoris: Array<Favoris>;
  jardin: Jardin;


  constructor(id?: number, version?: number, identifiant?: string,
              motDePasse?: string, mail?: string, nom?: string, prenom?: string,
              rue?: string, complement?: string, codePostal?: string,
              ville?: string, telephone?: string,
              historiques?: Array<Historique>, utilisateur?: Utilisateur,
              referentielUtiliseurs?: Array<ReferentielUtilisateur>,
              favoris?: Array<Favoris>, jardin?: Jardin) {
    this.id = id;
    this.version = version;
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
    this.mail = mail;
    this.nom = nom;
    this.prenom = prenom;
    this.rue = rue;
    this.complement = complement;
    this.codePostal = codePostal;
    this.ville = ville;
    this.telephone = telephone;
    this.historiques = historiques;
    this.utilisateur = utilisateur;
    this.referentielUtiliseurs = referentielUtiliseurs;
    this.favoris = favoris;
    this.jardin = jardin;
  }
}
