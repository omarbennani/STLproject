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
public class S_SuiteConditionnelle_MiniJava {
LEX_MiniJava scanner;
  S_SuiteConditionnelle_MiniJava() {
	}
  S_SuiteConditionnelle_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Block att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  String att_nomClasse;
  private void regle55() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_55();
  }
  private void regle56() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_4 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_56(x_4);
	x_2.analyser(LEX_MiniJava.token_sinon);
if  (att_eval)	  action_tds_56(x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_56(x_4);
  }
private void action_tds_56(S_Bloc_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteConditionnelle -> sinon #tds Bloc #ast ;", e });
}
  }
private void action_auto_inh_56(S_Bloc_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAtt=this.att_tdsAtt;
x_4.att_factory=this.att_factory;
x_4.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteConditionnelle -> sinon #tds Bloc #ast ;", e });
}
  }
private void action_ast_55() throws Exception {
try {
// instructions
this.att_ast=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteConditionnelle -> #ast ;", e });
}
  }
private void action_ast_56(S_Bloc_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteConditionnelle -> sinon #tds Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 87
        regle55 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle55 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle55 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle55 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle55 () ;
      break ;
      case LEX_MiniJava.token_accolade_ouvrante : // 53
        regle55 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle55 () ;
      break ;
      case LEX_MiniJava.token_negation : // 76
        regle55 () ;
      break ;
      case LEX_MiniJava.token_entier : // 106
        regle55 () ;
      break ;
      case LEX_MiniJava.token_vrai : // 78
        regle55 () ;
      break ;
      case LEX_MiniJava.token_faux : // 79
        regle55 () ;
      break ;
      case LEX_MiniJava.token_chaine : // 104
        regle55 () ;
      break ;
      case LEX_MiniJava.token_caractere : // 105
        regle55 () ;
      break ;
      case LEX_MiniJava.token_nouveau : // 83
        regle55 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle55 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 107
        regle55 () ;
      break ;
      case LEX_MiniJava.token_si : // 80
        regle55 () ;
      break ;
      case LEX_MiniJava.token_tant_que : // 84
        regle55 () ;
      break ;
      case LEX_MiniJava.token_afficher : // 82
        regle55 () ;
      break ;
      case LEX_MiniJava.token_retour : // 85
        regle55 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle55 () ;
      break ;
      case LEX_MiniJava.token_sinon : // 81
        regle56 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
