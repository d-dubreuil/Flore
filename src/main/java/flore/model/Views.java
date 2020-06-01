package flore.model;

public class Views {
	public static class ViewCommon {}
	
	public static class ViewCaracteristique extends ViewCommon {}
	
	public static class ViewCaracteristiqueFlore extends ViewCaracteristique {}
	
	public static class ViewCommande extends ViewCommon {}
	
	public static class ViewCompteUtilisateur extends ViewCommon {}
	
	public static class ViewCompteClient extends ViewCompteUtilisateur {}
	
	public static class ViewCompteFournisseur extends ViewCompteUtilisateur {}
	
	public static class ViewConseil extends ViewCommon {}
	
	public static class ViewFaune extends ViewCommon {}
	
	public static class ViewFavoris extends ViewCommon {}
	
	public static class ViewFlore extends ViewCommon {}
	
	public static class ViewFloreWithRefCarac extends ViewFlore {}
	
	public static class ViewHistorique extends ViewCommon {}
	
	public static class ViewJardin extends ViewCommon {}
	
	public static class ViewPanier extends ViewCommon {}
	
	public static class ViewProduit extends ViewCommon {}
	
	public static class ViewPaiement extends ViewCommon {}
	
	public static class ViewReferentielCaracteristique extends ViewCommon {}
	
	public static class ViewReferentielFaune extends ViewCommon {}
	
	public static class ViewReferentielUtilisateur extends ViewCommon {}
	
	public static class ViewSelection extends ViewCommon {}
	
	public static class ViewUtilisateur extends ViewCommon {}
}
