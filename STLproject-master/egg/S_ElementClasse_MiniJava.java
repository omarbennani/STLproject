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
public class S_ElementClasse_MiniJava {
LEX_MiniJava scanner;
  S_ElementClasse_MiniJava() {
	}
  S_ElementClasse_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  ElementClasse att_ast;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  boolean att_eval;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  DroitAcces att_droit;
  String att_nomClasse;
  SymbolTable att_tdsMeth;
  private void regle30() throws Exception {

	//declaration
	S_Constructeur_MiniJava x_2 = new S_Constructeur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_30(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_30(x_2);
  }
  private void regle29() throws Exception {

	//declaration
	S_AttributOuMethode_MiniJava x_2 = new S_AttributOuMethode_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_29(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_29(x_2);
  }
  private void regle28() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_AttributOuMethode_MiniJava x_3 = new S_AttributOuMethode_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_28(x_3);
	x_2.analyser(LEX_MiniJava.token_statique);
	x_3.analyser() ;
if  (att_eval)	  action_ast_28(x_3);
  }
private void action_auto_inh_30(S_Constructeur_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_2.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ElementClasse -> Constructeur #ast ;", e });
}
  }
private void action_ast_28(S_AttributOuMethode_MiniJava x_3) throws Exception {
try {
// locales
ElementClasse loc_a;
// instructions
loc_a=x_3.att_ast;
loc_a.setStatic(true);
this.att_ast=loc_a;
if ((x_3.att_typeElementClasse==0)){
this.att_tdsAttributs.register(loc_a, this.att_nomClasse);
}
else {
this.att_tdsMethodes.registerM(loc_a, this.att_nomClasse);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementClasse -> statique AttributOuMethode #ast ;", e });
}
  }
private void action_ast_29(S_AttributOuMethode_MiniJava x_2) throws Exception {
try {
// locales
ElementClasse loc_a;
// instructions
loc_a=x_2.att_ast;
loc_a.setStatic(false);
this.att_ast=loc_a;
if ((x_2.att_typeElementClasse==0)){
this.att_tdsAttributs.register(loc_a, this.att_nomClasse);
}
else {
this.att_tdsMethodes.registerM(loc_a, this.att_nomClasse);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementClasse -> AttributOuMethode #ast ;", e });
}
  }
private void action_auto_inh_28(S_AttributOuMethode_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsMeth=this.att_tdsMeth;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_droit=this.att_droit;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ElementClasse -> statique AttributOuMethode #ast ;", e });
}
  }
private void action_ast_30(S_Constructeur_MiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
this.att_tdsMethodes.registerM(x_2.att_ast, this.att_nomClasse);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementClasse -> Constructeur #ast ;", e });
}
  }
private void action_auto_inh_29(S_AttributOuMethode_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_tdsMeth=this.att_tdsMeth;
x_2.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_2.att_droit=this.att_droit;
x_2.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ElementClasse -> AttributOuMethode #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_statique : // 101
        regle28 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 87
        regle29 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle29 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle29 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle29 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_MiniJava.token_crochet_ouvrant : // 55
            regle29 () ;
          break ;
          case LEX_MiniJava.token_identificateur : // 107
            regle29 () ;
          break ;
          case LEX_MiniJava.token_parenthese_ouvrante : // 57
            regle30 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_MiniJava.token_identificateur_type);
        }
      break ;
      case LEX_MiniJava.token_vide : // 90
        regle29 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
