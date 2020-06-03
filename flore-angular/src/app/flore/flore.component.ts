import {Component, OnInit} from '@angular/core';
import {Flore} from '../model/Flore';
import {FloreForm} from '../model/FloreForm';
import {FloreService} from '../services/flore.service';
import {CaracteristiqueService} from '../services/caracteristique.service';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-flore',
  templateUrl: './flore.component.html',
  styleUrls: ['./flore.component.scss']
})
export class FloreComponent implements OnInit {

  nomFlore:string='';
  floreList:Array<Flore>=new Array<Flore>();
  nomFloreList:Array<String>=new Array<String>();
  floreformulaire: FloreForm = new FloreForm();
  caracteristiques: Array<string> = new Array<string>();
  caracs: Array<string> = new Array<string>();
  caracEspece: string = 'Espece';
  caracRecolte: string = 'Récolte';
  caracPlanter: string = 'Plantation';
  caracRemontant: string = 'Remontant';
  caracPH: string = 'pH';
  caracHumidite: string = 'Humidité';
  caracTexture: string = 'Texture';
  caracArrosage: string = 'Arrosage';
  caracClimat: string = 'Climat';
  caracResistanceFroid: string = 'RésistanceAuFroid';
  caracResistanceVent:string='Vent';
  caracEnsoleillement: string = 'Ensoleillement';
  caracFloraison: string = 'Végétation';
  caracHauteur: string = 'HauteurAMaturite';
  caracRacine: string = 'Racines';
  caracCroissance: string = 'Croissance';
  caracAzote: string = 'Azote';
  caracNutriment: string = 'Nutriment';
  caracStrate: string = 'Strate';
  especeBoolean: boolean = false;
  fruitsBoolean: boolean = false;
  legumesBoolean: boolean = false;
  cerealesBoolean: boolean = false;
  fleursBoolean: boolean = false;
  arbresBoolean: boolean = false;
  aromatiquesBoolean: boolean = false;
  remontantOuiBoolean: boolean = false;
  remontantNonBoolean: boolean = false;
  remontantBoolean: boolean = false;
  acideBoolean: boolean = false;
  tresAcideBoolean: boolean = false;
  neutreBoolean: boolean = false;
  basiqueBoolean: boolean = false;
  phBoolean: boolean = false;
  secBoolean: boolean = false;
  humideBoolean: boolean = false;
  draineBoolean: boolean = false;
  aquatiqueBoolean: boolean = false;
  tresHumideBoolean: boolean = false;
  humiditeBoolean: boolean = false;
  limoneuxBoolean: boolean = false;
  sableuxBoolean: boolean = false;
  argileuxBoolean: boolean = false;
  argiloSableuxBoolean: boolean = false;
  argiloLimoneuxBoolean: boolean = false;
  limonoSableuxBoolean: boolean = false;
  equilibreBoolean: boolean = false;
  humifereBoolean: boolean = false;
  calcaireBoolean: boolean = false;
  textureBoolean: boolean = false;
  faibleBoolean: boolean = false;
  modereBoolean: boolean = false;
  importantBoolean: boolean = false;
  arrosageBoolean: boolean = false;
  continentalBoolean: boolean = false;
  montagnardBoolean: boolean = false;
  mediterraneenBoolean: boolean = false;
  semiOceaniqueBoolean: boolean = false;
  oceaniqueBoolean: boolean = false;
  climatBoolean: boolean = false;
  faibleresistanceBoolean: boolean = false;
  modereresistanceBoolean: boolean = false;
  hauteresistanceBoolean: boolean = false;
  resistanceFroidBoolean: boolean = false;
  pleineOmbreBoolean:boolean=false;
  pleinSoleilBoolean:boolean=false;
  soleilBoolean:boolean=false;
  miOmbreBoolean:boolean=false;
  ombreBoolean:boolean=false;
  ensoleillementBoolean:boolean=false;
  vivaceBoolean:boolean=false;
  annuelleBoolean:boolean=false;
  biannuelleBoolean:boolean=false;
  floraisonBoolean:boolean=false;
  trespetitBoolean:boolean=false;
  petitBoolean:boolean=false;
  moyenBoolean:boolean=false;
  grandBoolean:boolean=false;
  hauteurAMaturiteBoolean:boolean=false;
  profondesBoolean:boolean=false;
  profondeurMoyenneBoolean:boolean=false;
  rhizomesBoolean:boolean=false;
  superfilciellesBoolean:boolean=false;
  racinesBoolean:boolean=false;
  rapideBoolean:boolean=false;
  normaleBoolean:boolean=false;
  lenteBoolean:boolean=false;
  croissanceBoolean:boolean=false;
  fixateurAzoteBoolean:boolean=false;
  inhibiteurAzoteBoolean:boolean=false;
  devoreurAzoteBoolean:boolean=false;
  neutreAzoteBoolean:boolean=false;
  azoteBoolean:boolean=false;
  fixateurBoolean:boolean=false;
  devoreurBoolean:boolean=false;
  neutreNutrimentBoolean:boolean=false;
  nutrimentBoolean:boolean=false;
  herbaceeHauteBoolean:boolean=false;
  herbaceeBasseBoolean:boolean=false;
  arbustiveBoolean:boolean=false;
  petitsArbresBoolean:boolean=false;
  couvreSolBoolean:boolean=false;
  canopeeBoolean:boolean=false;
  grimpanteBoolean:boolean=false;
  rhizosphereBoolean:boolean=false;
  strateBoolean:boolean=false;
  janvierRecolteBoolean:boolean=false;
  fevrierRecolteBoolean:boolean=false;
  marsRecolteBoolean:boolean=false;
  avrilRecolteBoolean:boolean=false;
  maiRecolteBoolean:boolean=false;
  juinRecolteBoolean:boolean=false;
  juilletRecolteBoolean:boolean=false;
  aoutRecolteBoolean:boolean=false;
  septembreRecolteBoolean:boolean=false;
  octobreRecolteBoolean:boolean=false;
  novembreRecolteBoolean:boolean=false;
  decembreRecolteBoolean:boolean=false;
  recolteBoolean:boolean=false;
  janvierPlantationBoolean:boolean=false;
  fevrierPlantationBoolean:boolean=false;
  marsPlantationBoolean:boolean=false;
  avrilPlantationBoolean:boolean=false;
  maiPlantationBoolean:boolean=false;
  juinPlantationBoolean:boolean=false;
  juilletPlantationBoolean:boolean=false;
  aoutPlantationBoolean:boolean=false;
  septembrePlantationBoolean:boolean=false;
  octobrePlantationBoolean:boolean=false;
  novembrePlantationBoolean:boolean=false;
  decembrePlantationBoolean:boolean=false;
  plantationBoolean:boolean=false;
  tresResistantVentBoolean:boolean=false;
  assezResistantVentBoolean:boolean=false;
  peuReistantVentBoolean:boolean=false;
  briseVentBoolean:boolean=false;
  resistanceVentBoolean:boolean=false;


  constructor(private floreService: FloreService, private caracteristiqueService: CaracteristiqueService, private titleService: Title, private router:Router, private commonService:CommonService) {
    this.titleService.setTitle("Flore");
    this.caracs.push(this.caracEspece);
    this.caracs.push(this.caracRecolte);
    this.caracs.push(this.caracPlanter);
    this.caracs.push(this.caracRemontant);
    this.caracs.push(this.caracPH);
    this.caracs.push(this.caracHumidite);
    this.caracs.push(this.caracTexture);
    this.caracs.push(this.caracArrosage);
    this.caracs.push(this.caracClimat);
    this.caracs.push(this.caracResistanceFroid);
    this.caracs.push(this.caracEnsoleillement);
    this.caracs.push(this.caracFloraison);
    this.caracs.push(this.caracHauteur);
    this.caracs.push(this.caracRacine);
    this.caracs.push(this.caracCroissance);
    this.caracs.push(this.caracAzote);
    this.caracs.push(this.caracNutriment);
    this.caracs.push(this.caracStrate);
    this.commonService.page ="flore";

    for(let flore of this.floreService.findAll()){
      if(this.filterCarac(flore,"NomLatin")!='non renseigné'){
        this.nomFloreList.push(flore.nom);
        this.floreList.push(flore);
      }
    }
  }

  ngOnInit(): void {
  }

  list(): Array<Flore> {
    return this.floreService.findAll().sort(function(a,b) {
      return a.nom.localeCompare(b.nom);
    });
  }

  search() {
    //Remise à zéro des carac, du tableau et des boolean.
    this.caracteristiques = new Array<string>();
    this.caracEspece = 'Espece';
    this.caracRecolte = 'Récolte';
    this.caracPlanter = 'Plantation';
    this.caracRemontant = 'Remontant';
    this.caracPH = 'pH';
    this.caracHumidite = 'Humidité';
    this.caracTexture = 'Texture';
    this.caracArrosage = 'Arrosage';
    this.caracClimat = 'Climat';
    this.caracResistanceFroid = 'RésistanceAuFroid';
    this.caracResistanceVent='Vent';
    this.caracEnsoleillement = 'Ensoleillement';
    this.caracFloraison = 'Végétation';
    this.caracHauteur = 'HauteurAMaturite';
    this.caracRacine = 'Racines';
    this.caracCroissance = 'Croissance';
    this.caracAzote = 'Azote';
    this.caracNutriment = 'Nutriment';
    this.caracStrate = 'Strate';
    this.especeBoolean = false;
    this.remontantBoolean = false;
    this.phBoolean = false;
    this.humiditeBoolean = false;
    this.textureBoolean = false;
    this.arrosageBoolean=false;
    this.climatBoolean=false;
    this.resistanceFroidBoolean=false;
    this.ensoleillementBoolean=false;
    this.floraisonBoolean=false;
    this.hauteurAMaturiteBoolean=false;
    this.racinesBoolean=false;
    this.croissanceBoolean=false;
    this.azoteBoolean=false;
    this.nutrimentBoolean=false;
    this.strateBoolean=false;
    this.recolteBoolean=false;
    this.plantationBoolean=false;
    this.resistanceVentBoolean=false;


    //Création de la string sur la carac espèce pour la future requete (si nécessaire)
    if (this.fruitsBoolean) {
      this.caracEspece = this.caracEspece + ':Fruits';
      this.especeBoolean = true;
    }
    if (this.arbresBoolean) {
      this.caracEspece = this.caracEspece + ':Arbres';
      this.especeBoolean = true;
    }
    if (this.aromatiquesBoolean) {
      this.caracEspece = this.caracEspece + ':Aromatiques';
      this.especeBoolean = true;
    }
    if (this.legumesBoolean) {
      this.caracEspece = this.caracEspece + ':Légumes';
      this.especeBoolean = true;
    }
    if (this.cerealesBoolean) {
      this.caracEspece = this.caracEspece + ':Céréales';
      this.especeBoolean = true;
    }
    if (this.fleursBoolean) {
      this.caracEspece = this.caracEspece + ':Fleurs';
      this.especeBoolean = true;
    }
    if (this.especeBoolean) {
      this.caracteristiques.push(this.caracEspece);
    }

    //Création de la string sur la carac remontant pour la future requete (si nécessaire)
    if (this.remontantNonBoolean) {
      this.caracRemontant = this.caracRemontant + ':Non';
      this.remontantBoolean = true;
    }
    if (this.remontantOuiBoolean) {
      this.caracRemontant = this.caracRemontant + ':Oui';
      this.remontantBoolean = true;
    }
    if (this.remontantBoolean) {
      this.caracteristiques.push(this.caracRemontant);
    }

    //Création de la string sur la carac pH pour la future requete (si nécessaire)
    if (this.acideBoolean) {
      this.caracPH = this.caracPH + ':Acide';
      this.phBoolean = true;
    }
    if (this.tresAcideBoolean) {
      this.caracPH = this.caracPH + ':Très Acide';
      this.phBoolean = true;
    }
    if (this.neutreBoolean) {
      this.caracPH = this.caracPH + ':Neutre';
      this.phBoolean = true;
    }
    if (this.basiqueBoolean) {
      this.caracPH = this.caracPH + ':Basique';
      this.phBoolean = true;
    }
    if (this.phBoolean) {
      this.caracteristiques.push(this.caracPH);
    }

    //Création de la string sur la carac humidité pour la future requete (si nécessaire)
    if (this.secBoolean) {
      this.caracHumidite = this.caracHumidite + ':Sec';
      this.humiditeBoolean = true;
    }
    if (this.draineBoolean) {
      this.caracHumidite = this.caracHumidite + ':Drainé';
      this.humiditeBoolean = true;
    }
    if (this.humideBoolean) {
      this.caracHumidite = this.caracHumidite + ':Humide';
      this.humiditeBoolean = true;
    }
    if (this.tresHumideBoolean) {
      this.caracHumidite = this.caracHumidite + ':Très Humide';
      this.humiditeBoolean = true;
    }
    if (this.aquatiqueBoolean) {
      this.caracHumidite = this.caracHumidite + ':Aquatique';
      this.humiditeBoolean = true;
    }
    if (this.humiditeBoolean) {
      this.caracteristiques.push(this.caracHumidite);
    }

    //Création de la string sur la carac texture pour la future requete (si nécessaire)
    if (this.argileuxBoolean) {
      this.caracTexture = this.caracTexture + ':Argileux';
      this.textureBoolean = true;
    }
    if (this.limoneuxBoolean) {
      this.caracTexture = this.caracTexture + ':Limoneux';
      this.textureBoolean = true;
    }
    if (this.sableuxBoolean) {
      this.caracTexture = this.caracTexture + ':Sableux';
      this.textureBoolean = true;
    }
    if (this.argiloLimoneuxBoolean) {
      this.caracTexture = this.caracTexture + ':Argileux Limoneux';
      this.textureBoolean = true;
    }
    if (this.argiloSableuxBoolean) {
      this.caracTexture = this.caracTexture + ':Argileux Sableux';
      this.textureBoolean = true;
    }
    if (this.limonoSableuxBoolean) {
      this.caracTexture = this.caracTexture + ':Limoneux Sableux';
      this.textureBoolean = true;
    }
    if (this.equilibreBoolean) {
      this.caracTexture = this.caracTexture + ':Argileux Limoneux Sableux';
      this.textureBoolean = true;
    }
    if (this.humifereBoolean) {
      this.caracTexture = this.caracTexture + ':Humifère';
      this.textureBoolean = true;
    }
    if (this.calcaireBoolean) {
      this.caracTexture = this.caracTexture + ':Calcaire';
      this.textureBoolean = true;
    }
    if (this.textureBoolean) {
      this.caracteristiques.push(this.caracTexture);
    }

    //Création de la string sur la carac arrosage pour la future requete (si nécessaire)
    if (this.faibleBoolean) {
      this.caracArrosage = this.caracArrosage + ':Faible';
      this.arrosageBoolean = true;
    }
    if (this.modereBoolean) {
      this.caracArrosage = this.caracArrosage + ':Modéré';
      this.arrosageBoolean = true;
    }
    if (this.importantBoolean) {
      this.caracArrosage = this.caracArrosage + ':Important';
      this.arrosageBoolean = true;
    }
    if(this.arrosageBoolean){
      this.caracteristiques.push(this.caracArrosage)
    }

    //Création de la string sur la carac Climat pour la future requete (si nécessaire)
    if (this.continentalBoolean) {
      this.caracClimat = this.caracClimat + ':Continental';
      this.climatBoolean = true;
    }
    if (this.montagnardBoolean) {
      this.caracClimat = this.caracClimat + ':Montagnard';
      this.climatBoolean = true;
    }
    if (this.mediterraneenBoolean) {
      this.caracClimat = this.caracClimat + ':Méditerranéen';
      this.climatBoolean = true;
    }
    if (this.semiOceaniqueBoolean) {
      this.caracClimat = this.caracClimat + ':Semi-Océanique';
      this.climatBoolean = true;
    }
    if (this.oceaniqueBoolean) {
      this.caracClimat = this.caracClimat + ':Océanique';
      this.climatBoolean = true;
    }
    if (this.climatBoolean) {
      this.caracteristiques.push(this.caracClimat);
    }

    //Création de la string sur la carac resistance au froid pour la future requete (si nécessaire)
    if (this.faibleresistanceBoolean) {
      this.caracResistanceFroid = this.caracResistanceFroid + ':Faible';
      this.resistanceFroidBoolean = true;
    }
    if (this.modereresistanceBoolean) {
      this.caracResistanceFroid = this.caracResistanceFroid + ':Modéré';
      this.resistanceFroidBoolean = true;
    }
    if (this.hauteresistanceBoolean) {
      this.caracResistanceFroid = this.caracResistanceFroid + ':Important';
      this.resistanceFroidBoolean = true;
    }
    if (this.resistanceFroidBoolean) {
      this.caracteristiques.push(this.caracResistanceFroid);
    }

    //Création de la string sur la carac ensoleillement pour la future requete (si nécessaire)
    if (this.pleineOmbreBoolean) {
      this.caracEnsoleillement = this.caracEnsoleillement + ':Pleine Ombre';
      this.ensoleillementBoolean = true;
    }
    if (this.pleinSoleilBoolean) {
      this.caracEnsoleillement = this.caracEnsoleillement + ':Plein Soleil';
      this.ensoleillementBoolean = true;
    }
    if (this.soleilBoolean) {
      this.caracEnsoleillement = this.caracEnsoleillement + ':Soleil';
      this.ensoleillementBoolean = true;
    }
    if (this.miOmbreBoolean) {
      this.caracEnsoleillement = this.caracEnsoleillement + ':Mi Ombre';
      this.ensoleillementBoolean = true;
    }
    if (this.ombreBoolean) {
      this.caracEnsoleillement = this.caracEnsoleillement + ':Ombre';
      this.ensoleillementBoolean = true;
    }
    if (this.ensoleillementBoolean) {
      this.caracteristiques.push(this.caracEnsoleillement);
    }

    //Création de la string sur la carac floraison pour la future requete (si nécessaire)
    if (this.vivaceBoolean) {
      this.caracFloraison = this.caracFloraison + ':Vivace';
      this.floraisonBoolean = true;
    }
    if (this.annuelleBoolean) {
      this.caracFloraison = this.caracFloraison + ':Annuelle';
      this.floraisonBoolean = true;
    }
    if (this.biannuelleBoolean) {
      this.caracFloraison = this.caracFloraison + ':Bisannuelle';
      this.floraisonBoolean = true;
    }
    if(this.floraisonBoolean){
      this.caracteristiques.push(this.caracFloraison);
    }

    //Création de la string sur la carac hauteur a maturite pour la future requete (si nécessaire)
    if (this.trespetitBoolean) {
      this.caracHauteur = this.caracHauteur + ':20';
      this.hauteurAMaturiteBoolean = true;
    }
    if (this.petitBoolean) {
      this.caracHauteur = this.caracHauteur + ':20/60';
      this.hauteurAMaturiteBoolean = true;
    }
    if (this.moyenBoolean) {
      this.caracHauteur = this.caracHauteur + ':60/150';
      this.hauteurAMaturiteBoolean = true;
    }
    if (this.grandBoolean) {
      this.caracHauteur = this.caracHauteur + ':150';
      this.hauteurAMaturiteBoolean = true;
    }
    if(this.hauteurAMaturiteBoolean){
      this.caracteristiques.push(this.caracHauteur);
    }

    //Création de la string sur la carac racines pour la future requete (si nécessaire)
    if (this.profondesBoolean) {
      this.caracRacine = this.caracRacine + ':Profondes';
      this.racinesBoolean = true;
    }
    if (this.profondeurMoyenneBoolean) {
      this.caracRacine = this.caracRacine + ':Profondeur Moyenne';
      this.racinesBoolean = true;
    }
    if (this.rhizomesBoolean) {
      this.caracRacine = this.caracRacine + ':Rhizomes';
      this.racinesBoolean = true;
    }
    if (this.superfilciellesBoolean) {
      this.caracRacine = this.caracRacine + ':Superficielles';
      this.racinesBoolean = true;
    }
    if (this.racinesBoolean){
      this.caracteristiques.push(this.caracRacine);
    }

    //Création de la string sur la carac croissance pour la future requete (si nécessaire)
    if (this.rapideBoolean) {
      this.caracCroissance = this.caracCroissance + ':Rapide';
      this.croissanceBoolean = true;
    }
    if (this.normaleBoolean) {
      this.caracCroissance = this.caracCroissance + ':Normale';
      this.croissanceBoolean = true;
    }
    if (this.lenteBoolean) {
      this.caracCroissance = this.caracCroissance + ':Lente';
      this.croissanceBoolean = true;
    }
    if (this.croissanceBoolean){
      this.caracteristiques.push(this.caracCroissance);
    }

    //Création de la string sur la carac azote pour la future requete (si nécessaire)
    if (this.fixateurAzoteBoolean) {
      this.caracAzote = this.caracAzote + ':Fixateur';
      this.azoteBoolean = true;
    }
    if (this.inhibiteurAzoteBoolean) {
      this.caracAzote = this.caracAzote + ':Inhibiteur';
      this.azoteBoolean = true;
    }
    if (this.devoreurAzoteBoolean) {
      this.caracAzote = this.caracAzote + ':Dévoreur';
      this.azoteBoolean = true;
    }
    if (this.neutreAzoteBoolean) {
      this.caracAzote = this.caracAzote + ':Neutre';
      this.azoteBoolean = true;
    }
    if (this.azoteBoolean){
      this.caracteristiques.push(this.caracAzote);
    }

    //Création de la string sur la carac nutriment pour la future requete (si nécessaire)
    if (this.fixateurBoolean) {
      this.caracNutriment = this.caracNutriment + ':Fixateur';
      this.nutrimentBoolean = true;
    }
    if (this.devoreurBoolean) {
      this.caracNutriment = this.caracNutriment + ':Dévoreur';
      this.nutrimentBoolean = true;
    }
    if (this.neutreNutrimentBoolean) {
      this.caracNutriment = this.caracNutriment + ':Neutre';
      this.nutrimentBoolean = true;
    }
    if (this.nutrimentBoolean){
      this.caracteristiques.push(this.caracNutriment);
    }

    //Création de la string sur la carac strate pour la future requete (si nécessaire)
    if (this.herbaceeHauteBoolean) {
      this.caracStrate = this.caracStrate + ':Herbacée Haute';
      this.strateBoolean = true;
    }
    if (this.herbaceeBasseBoolean) {
      this.caracStrate = this.caracStrate + ':Herbacée Basse';
      this.strateBoolean = true;
    }
    if (this.arbustiveBoolean) {
      this.caracStrate = this.caracStrate + ':Arbustive';
      this.strateBoolean = true;
    }
    if (this.petitsArbresBoolean) {
      this.caracStrate = this.caracStrate + ':Petits Arbres';
      this.strateBoolean = true;
    }
    if (this.couvreSolBoolean) {
      this.caracStrate = this.caracStrate + ':Couvre Sol';
      this.strateBoolean = true;
    }
    if (this.canopeeBoolean) {
      this.caracStrate = this.caracStrate + ':Canopée';
      this.strateBoolean = true;
    }
    if (this.grimpanteBoolean) {
      this.caracStrate = this.caracStrate + ':Grimpante';
      this.strateBoolean = true;
    }
    if (this.rhizosphereBoolean) {
      this.caracStrate = this.caracStrate + ':Rhizosphère';
      this.strateBoolean = true;
    }
    if (this.strateBoolean){
      this.caracteristiques.push(this.caracStrate);
    }

    //Création de la string sur la carac recolte pour la future requete (si nécessaire)
    if (this.janvierRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Janvier';
      this.recolteBoolean = true;
    }
    if (this.fevrierRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Février';
      this.recolteBoolean = true;
    }
    if (this.marsRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Mars';
      this.recolteBoolean = true;
    }
    if (this.avrilRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Avril';
      this.recolteBoolean = true;
    }
    if (this.maiRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Mai';
      this.recolteBoolean = true;
    }
    if (this.juinRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Juin';
      this.recolteBoolean = true;
    }
    if (this.juilletRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Juillet';
      this.recolteBoolean = true;
    }
    if (this.aoutRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Août';
      this.recolteBoolean = true;
    }
    if (this.septembreRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Septembre';
      this.recolteBoolean = true;
    }
    if (this.octobreRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Octobre';
      this.recolteBoolean = true;
    }
    if (this.novembreRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Novembre';
      this.recolteBoolean = true;
    }
    if (this.decembreRecolteBoolean) {
      this.caracRecolte = this.caracRecolte + ':Décembre';
      this.recolteBoolean = true;
    }
    if (this.recolteBoolean){
      this.caracteristiques.push(this.caracRecolte);
    }

    //Création de la string sur la carac plantation pour la future requete (si nécessaire)
    if (this.janvierPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Janvier';
      this.plantationBoolean = true;
    }
    if (this.fevrierPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Février';
      this.plantationBoolean = true;
    }
    if (this.marsPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Mars';
      this.plantationBoolean = true;
    }
    if (this.avrilPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Avril';
      this.plantationBoolean = true;
    }
    if (this.maiPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Mai';
      this.plantationBoolean = true;
    }
    if (this.juinPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Juin';
      this.plantationBoolean = true;
    }
    if (this.juilletPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Juillet';
      this.plantationBoolean = true;
    }
    if (this.aoutPlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Août';
      this.plantationBoolean = true;
    }
    if (this.septembrePlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Septembre';
      this.plantationBoolean = true;
    }
    if (this.octobrePlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Octobre';
      this.plantationBoolean = true;
    }
    if (this.novembrePlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Novembre';
      this.plantationBoolean = true;
    }
    if (this.decembrePlantationBoolean) {
      this.caracPlanter = this.caracPlanter + ':Décembre';
      this.plantationBoolean = true;
    }
    if (this.plantationBoolean){
      this.caracteristiques.push(this.caracPlanter);
    }

    //Création de la string sur la carac arrosage pour la future requete (si nécessaire)
    if (this.assezResistantVentBoolean) {
      this.caracResistanceVent = this.caracResistanceVent + ':Assez Résistant';
      this.resistanceVentBoolean = true;
    }
    if (this.peuReistantVentBoolean) {
      this.caracResistanceVent = this.caracResistanceVent + ':Peu Résistant';
      this.resistanceVentBoolean = true;
    }
    if (this.tresResistantVentBoolean) {
      this.caracResistanceVent = this.caracResistanceVent + ':Très Résistant';
      this.resistanceVentBoolean = true;
    }
    if (this.briseVentBoolean) {
      this.caracResistanceVent = this.caracResistanceVent + ':Haie Brise-Vent';
      this.resistanceVentBoolean = true;
    }
    if (this.resistanceVentBoolean){
      this.caracteristiques.push(this.caracResistanceVent);
    }

    //Création de la query
    this.floreformulaire.caracteristiques = this.caracteristiques;
    this.floreService.findByFormulaire(this.floreformulaire).subscribe(resp => {
      this.floreService.flores = resp;
    }, error => console.log(error));
  }

  filterCarac(flore: Flore, nomCarac: string): string {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac) {
          return refCarac.caracteristique.valeur;
        }
      }
    }

    return 'non renseigné';
  }

  redirectToFicheFlore(flore:Flore){
    this.floreService.flore = flore;
    this.router.navigateByUrl('NPK/flore/fiche-flore');
  }



}
