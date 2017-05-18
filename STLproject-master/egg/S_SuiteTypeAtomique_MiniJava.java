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
public class S_SuiteTypeAtomique_MiniJava {
LEX_MiniJava scanner;
  S_SuiteTypeAtomique_MiniJava() {
	}
  S_SuiteTypeAtomique_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Type att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  Type att_type;
  private void regle47() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_SuiteTypeAtomique_MiniJava x_5 = new S_SuiteTypeAtomique_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_47(x_5);
	x_2.analyser(LEX_MiniJava.token_crochet_ouvrant);
	x_3.analyser(LEX_MiniJava.token_crochet_fermant);
if  (att_eval)	  action_inh_47(x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_47(x_5);
  }
  private void regle48() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_48();
  }
private void action_ast_47(S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #inh SuiteTypeAtomique1 #ast ;", e });
}
  }
private void action_ast_48() throws Exception {
try {
// instructions
this.att_ast=this.att_type;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteTypeAtomique -> #ast ;", e });
}
  }
private void action_inh_47(S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_type=this.att_factory.createArrayType(this.att_type);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #inh SuiteTypeAtomique1 #ast ;", e });
}
  }
private void action_auto_inh_47(S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tds=this.att_tds;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #inh SuiteTypeAtomique1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_crochet_ouvrant : // 55
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_MiniJava.token_crochet_fermant : // 56
            regle47 () ;
          break ;
          case LEX_MiniJava.token_accolade_ouvrante : // 53
            regle48 () ;
          break ;
          case LEX_MiniJava.token_soustraction : // 70
            regle48 () ;
          break ;
          case LEX_MiniJava.token_negation : // 76
            regle48 () ;
          break ;
          case LEX_MiniJava.token_entier : // 106
            regle48 () ;
          break ;
          case LEX_MiniJava.token_vrai : // 78
            regle48 () ;
          break ;
          case LEX_MiniJava.token_faux : // 79
            regle48 () ;
          break ;
          case LEX_MiniJava.token_chaine : // 104
            regle48 () ;
          break ;
          case LEX_MiniJava.token_caractere : // 105
            regle48 () ;
          break ;
          case LEX_MiniJava.token_nouveau : // 83
            regle48 () ;
          break ;
          case LEX_MiniJava.token_parenthese_ouvrante : // 57
            regle48 () ;
          break ;
          case LEX_MiniJava.token_identificateur_type : // 108
            regle48 () ;
          break ;
          case LEX_MiniJava.token_identificateur : // 107
            regle48 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_MiniJava.token_crochet_ouvrant);
        }
      break ;
      case LEX_MiniJava.token_identificateur : // 107
        regle48 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle48 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
