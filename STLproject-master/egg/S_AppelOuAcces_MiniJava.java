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
public class S_AppelOuAcces_MiniJava {
LEX_MiniJava scanner;
  S_AppelOuAcces_MiniJava() {
	}
  S_AppelOuAcces_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  Expression att_ast;
  String att_identificateur_type;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  boolean att_eval;
  String att_identificateur;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  String att_nomClasse;
  Expression att_support;
  private void regle87() throws Exception {

	//declaration
	S_Acces_MiniJava x_3 = new S_Acces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_87(x_3);
if  (att_eval)	  action_inh_87(x_3);
	x_3.analyser() ;
if  (att_eval)	  action_ast_87(x_3);
  }
  private void regle88() throws Exception {

	//declaration
	S_Appel_MiniJava x_2 = new S_Appel_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_88(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_88(x_2);
  }
private void action_inh_87(S_Acces_MiniJava x_3) throws Exception {
try {
// locales
Declaration loc_d;
Optional<Declaration> loc_o;
VariableDeclaration loc_v;
Attribut loc_a;
// instructions
loc_a=null;
loc_v=null;
if (this.att_tds.contains(this.att_identificateur)){
loc_o=this.att_tds.get(this.att_identificateur);
loc_d=loc_o.get();
if (loc_d instanceof VariableDeclaration ){
loc_v=((VariableDeclaration)loc_d);
}

x_3.att_support=this.att_factory.createVariableUse(loc_v);
}
else if (this.att_tdsAttributs.contains(this.att_identificateur, this.att_nomClasse)){
loc_o=this.att_tdsAttributs.get(this.att_identificateur);
loc_d=loc_o.get();
if (loc_d instanceof Attribut ){
loc_a=((Attribut)loc_d);
}

x_3.att_support=this.att_factory.createAttributUse(loc_a);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_NOT_DEFINED_ATTRIBUT_OR_VARIABLE, MiniJavaMessages.NOT_DEFINED_ATTRIBUT_OR_VARIABLE,new Object[]{""+this.att_identificateur});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","AppelOuAcces -> #inh Acces #ast ;", e });
}
  }
private void action_auto_inh_87(S_Acces_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_identificateur_type=this.att_identificateur_type;
x_3.att_identificateur=this.att_identificateur;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AppelOuAcces -> #inh Acces #ast ;", e });
}
  }
private void action_auto_inh_88(S_Appel_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_2.att_identificateur_type=this.att_identificateur_type;
x_2.att_identificateur=this.att_identificateur;
x_2.att_support=this.att_support;
x_2.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AppelOuAcces -> Appel #ast ;", e });
}
  }
private void action_ast_87(S_Acces_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AppelOuAcces -> #inh Acces #ast ;", e });
}
  }
private void action_ast_88(S_Appel_MiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AppelOuAcces -> Appel #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_point : // 63
        regle87 () ;
      break ;
      case LEX_MiniJava.token_crochet_ouvrant : // 55
        regle87 () ;
      break ;
      case LEX_MiniJava.token_multiplication : // 72
        regle87 () ;
      break ;
      case LEX_MiniJava.token_division : // 73
        regle87 () ;
      break ;
      case LEX_MiniJava.token_modulo : // 74
        regle87 () ;
      break ;
      case LEX_MiniJava.token_et : // 77
        regle87 () ;
      break ;
      case LEX_MiniJava.token_addition : // 69
        regle87 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle87 () ;
      break ;
      case LEX_MiniJava.token_ou : // 71
        regle87 () ;
      break ;
      case LEX_MiniJava.token_egalite : // 67
        regle87 () ;
      break ;
      case LEX_MiniJava.token_different : // 68
        regle87 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 59
        regle87 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 61
        regle87 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 60
        regle87 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 62
        regle87 () ;
      break ;
      case LEX_MiniJava.token_affectation : // 66
        regle87 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 58
        regle87 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 56
        regle87 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 64
        regle87 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 65
        regle87 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle87 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle88 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
