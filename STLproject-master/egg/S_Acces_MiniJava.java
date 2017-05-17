package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Acces_MiniJava {
LEX_MiniJava scanner;
  S_Acces_MiniJava() {
	}
  S_Acces_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  Expression att_ast;
  Declaration att_decl;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  boolean att_eval;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  String att_nomClasse;
  Expression att_support;
  private void regle91() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Acces_MiniJava x_5 = new S_Acces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_91(x_3, x_5);
	x_2.analyser(LEX_MiniJava.token_crochet_ouvrant);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_crochet_fermant);
	x_5.analyser() ;
if  (att_eval)	  action_ast_91(x_3, x_5);
  }
  private void regle90() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_90();
  }
  private void regle89() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_AppelOuAcces_MiniJava x_5 = new S_AppelOuAcces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_89(x_3, x_5);
	x_2.analyser(LEX_MiniJava.token_point);
	x_3.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_inh_89(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_89(x_3, x_5);
  }
private void action_ast_90() throws Exception {
try {
// locales
// instructions
this.att_ast=this.att_support;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Acces -> #ast ;", e });
}
  }
private void action_auto_inh_89(T_MiniJava x_3, S_AppelOuAcces_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tds=this.att_tds;
x_5.att_tdsAtt=this.att_tdsAtt;
x_5.att_factory=this.att_factory;
x_5.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Acces -> point identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_ast_91(S_Expression_MiniJava x_3, S_Acces_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createAcces();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Acces -> crochet_ouvrant Expression crochet_fermant Acces1 #ast ;", e });
}
  }
private void action_inh_89(T_MiniJava x_3, S_AppelOuAcces_MiniJava x_5) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d1;
Declaration loc_d2;
VariableDeclaration loc_v;
Attribut loc_a;
Type loc_t;
String loc_s;
Classe loc_c;
Interface loc_i;
Methode loc_m;
// instructions
loc_a=null;
loc_v=null;
loc_m=null;
loc_d1=this.att_decl;
loc_s="erreur";
if (loc_d1 instanceof VariableDeclaration ){
loc_v=((VariableDeclaration)loc_d1);
}
else if (loc_d1 instanceof Attribut ){
loc_a=((Attribut)loc_d1);
}
else if (loc_d1 instanceof Methode ){
loc_m=((Methode)loc_d1);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Acces_idend_apOac, MiniJavaMessages.Acces_idend_apOac,new Object[]{""+" Declaration should be an attribute or a variableDeclaration "});


}
if ((loc_v!=null)){
loc_t=loc_v.getType();
}
else if ((loc_a!=null)){
loc_t=loc_a.getType();
}
else {
loc_t=loc_m.getType();
}
if (loc_t instanceof ClassTypeImpl ){
loc_c=((ClassTypeImpl)loc_t).getClasse();
loc_s=loc_c.getName();
}
else if (loc_t instanceof InterfaceTypeImpl ){
loc_i=((InterfaceTypeImpl)loc_t).getInterface();
loc_s=loc_i.getName();
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Acces_idend_apOac, MiniJavaMessages.Acces_idend_apOac,new Object[]{""+" Type should be Class or Interface "});


}
if (loc_s.equals("erreur")){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Acces_idend_apOac, MiniJavaMessages.Acces_idend_apOac,new Object[]{""+" s bad initialized "});

}

if (this.att_tdsAttributs.contains(x_3.att_txt, loc_s)){
loc_o=this.att_tdsAttributs.get(((loc_s+".")+x_3.att_txt));
loc_d2=loc_o.get();
x_5.att_decl=loc_d2;
x_5.att_support=this.att_factory.createAcces(this.att_support, loc_d2);
}
else if (this.att_tdsMethodes.contains(x_3.att_txt, loc_s)){
loc_o=this.att_tdsMethodes.get(((loc_s+".")+x_3.att_txt));
loc_d2=loc_o.get();
x_5.att_decl=loc_d2;
x_5.att_support=this.att_factory.createAcces(this.att_support, loc_d2);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Acces_idend_apOac, MiniJavaMessages.Acces_idend_apOac,new Object[]{""+(x_3.att_txt+" should be an attribute or a Method ")});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Acces -> point identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_auto_inh_91(S_Expression_MiniJava x_3, S_Acces_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_5.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
x_5.att_support=this.att_support;
x_5.att_decl=this.att_decl;
x_3.att_nomClasse=this.att_nomClasse;
x_5.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Acces -> crochet_ouvrant Expression crochet_fermant Acces1 #ast ;", e });
}
  }
private void action_ast_89(T_MiniJava x_3, S_AppelOuAcces_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Acces -> point identificateur #inh AppelOuAcces #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_point : // 63
        regle89 () ;
      break ;
      case LEX_MiniJava.token_multiplication : // 72
        regle90 () ;
      break ;
      case LEX_MiniJava.token_division : // 73
        regle90 () ;
      break ;
      case LEX_MiniJava.token_modulo : // 74
        regle90 () ;
      break ;
      case LEX_MiniJava.token_et : // 77
        regle90 () ;
      break ;
      case LEX_MiniJava.token_addition : // 69
        regle90 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle90 () ;
      break ;
      case LEX_MiniJava.token_ou : // 71
        regle90 () ;
      break ;
      case LEX_MiniJava.token_egalite : // 67
        regle90 () ;
      break ;
      case LEX_MiniJava.token_different : // 68
        regle90 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 59
        regle90 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 61
        regle90 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 60
        regle90 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 62
        regle90 () ;
      break ;
      case LEX_MiniJava.token_affectation : // 66
        regle90 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 58
        regle90 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 56
        regle90 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 64
        regle90 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 65
        regle90 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle90 () ;
      break ;
      case LEX_MiniJava.token_crochet_ouvrant : // 55
        regle91 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
