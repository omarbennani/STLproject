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
public class S_SuiteFacteur_MiniJava {
LEX_MiniJava scanner;
  S_SuiteFacteur_MiniJava() {
	}
  S_SuiteFacteur_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  Expression att_gauche;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  String att_nomClasse;
  private void regle74() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_74();
  }
  private void regle73() throws Exception {

	//declaration
	S_Multiplicatif_MiniJava x_2 = new S_Multiplicatif_MiniJava(scanner,att_eval) ;
	S_Facteur_MiniJava x_3 = new S_Facteur_MiniJava(scanner,att_eval) ;
	S_SuiteFacteur_MiniJava x_5 = new S_SuiteFacteur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_73(x_2, x_3, x_5);
	x_2.analyser() ;
	x_3.analyser() ;
if  (att_eval)	  action_gauche_73(x_2, x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_73(x_2, x_3, x_5);
  }
private void action_auto_inh_73(S_Multiplicatif_MiniJava x_2, S_Facteur_MiniJava x_3, S_SuiteFacteur_MiniJava x_5) throws Exception {
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
x_3.att_nomClasse=this.att_nomClasse;
x_5.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteFacteur -> Multiplicatif Facteur #gauche SuiteFacteur1 #ast ;", e });
}
  }
private void action_ast_73(S_Multiplicatif_MiniJava x_2, S_Facteur_MiniJava x_3, S_SuiteFacteur_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteFacteur -> Multiplicatif Facteur #gauche SuiteFacteur1 #ast ;", e });
}
  }
private void action_gauche_73(S_Multiplicatif_MiniJava x_2, S_Facteur_MiniJava x_3, S_SuiteFacteur_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_gauche=this.att_factory.createBinaryExpression(this.att_gauche, x_2.att_bin_op, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#gauche","SuiteFacteur -> Multiplicatif Facteur #gauche SuiteFacteur1 #ast ;", e });
}
  }
private void action_ast_74() throws Exception {
try {
// instructions
this.att_ast=this.att_gauche;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteFacteur -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_multiplication : // 72
        regle73 () ;
      break ;
      case LEX_MiniJava.token_division : // 73
        regle73 () ;
      break ;
      case LEX_MiniJava.token_modulo : // 74
        regle73 () ;
      break ;
      case LEX_MiniJava.token_et : // 77
        regle73 () ;
      break ;
      case LEX_MiniJava.token_addition : // 69
        regle74 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle74 () ;
      break ;
      case LEX_MiniJava.token_ou : // 71
        regle74 () ;
      break ;
      case LEX_MiniJava.token_egalite : // 67
        regle74 () ;
      break ;
      case LEX_MiniJava.token_different : // 68
        regle74 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 59
        regle74 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 61
        regle74 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 60
        regle74 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 62
        regle74 () ;
      break ;
      case LEX_MiniJava.token_affectation : // 66
        regle74 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 58
        regle74 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 56
        regle74 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 64
        regle74 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 65
        regle74 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle74 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
