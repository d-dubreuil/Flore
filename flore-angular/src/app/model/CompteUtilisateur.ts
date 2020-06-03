import {Historique} from './Historique';
import {Utilisateur} from './Utilisateur';
import {ReferentielUtilisateur} from './ReferentielUtilisateur';
import {Favoris} from './Favoris';
import {Jardin} from './Jardin';

export class CompteUtilisateur {
  id: number;
  version: number;
  disc:string;
  identifiant: string;
  motDePasse: string;
  mail: string;
  rue: string;
  complement: string;
  codePostal: string;
  ville: string;
  telephone: string;
  civilite:string;
  nom: string;
  prenom: string;
  denomination:string;
  statut:string;
  SIRET_SIREN:string;
  RCS:string;
  TVA:string;
  historiques: Array<Historique>;
  utilisateur: Utilisateur;
  referentielUtiliseurs: Array<ReferentielUtilisateur>;
  favoris: Array<Favoris>;
  jardin: Jardin;


  constructor(id?: number, version?: number,disc?:string, identifiant?: string,
              motDePasse?: string, mail?: string,
              rue?: string, complement?: string, codePostal?: string,
              ville?: string, telephone?: string,civilite?:string, nom?: string,
              prenom?: string,  denomination?:string,  statut?:string,  SIRET_SIREN?:string,
              RCS?:string,  TVA?:string,
              historiques?: Array<Historique>, utilisateur?: Utilisateur,
              referentielUtiliseurs?: Array<ReferentielUtilisateur>,
              favoris?: Array<Favoris>, jardin?: Jardin) {
    this.id = id;
    this.version = version;
    this.disc=disc;
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
    this.mail = mail;
    this.rue = rue;
    this.complement = complement;
    this.codePostal = codePostal;
    this.ville = ville;
    this.telephone = telephone;
    this.civilite=civilite;
    this.nom = nom;
    this.prenom = prenom;
    this.denomination=denomination;
    this.statut=statut;
    this.SIRET_SIREN=SIRET_SIREN;
    this.RCS=RCS;
    this.TVA=TVA;
    this.historiques = historiques;
    this.utilisateur = utilisateur;
    this.referentielUtiliseurs = referentielUtiliseurs;
    this.favoris = favoris;
    this.jardin = jardin;
  }
}
