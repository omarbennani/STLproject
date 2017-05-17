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
  Declaration att_decl;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  boolean att_eval;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  String att_nomClasse;
  Expression att_support;
  private void regle85() throws Exception {

	//declaration
	S_Acces_MiniJava x_2 = new S_Acces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_85(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_85(x_2);
  }
  private void regle86() throws Exception {

	//declaration
	S_Appel_MiniJava x_2 = new S_Appel_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_86(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_86(x_2);
  }
private void action_auto_inh_85(S_Acces_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_2.att_support=this.att_support;
x_2.att_decl=this.att_decl;
x_2.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AppelOuAcces -> Acces #ast ;", e });
}
  }
private void action_auto_inh_86(S_Appel_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_2.att_support=this.att_support;
x_2.att_decl=this.att_decl;
x_2.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AppelOuAcces -> Appel #ast ;", e });
}
  }
private void action_ast_85(S_Acces_MiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AppelOuAcces -> Acces #ast ;", e });
}
  }
private void action_ast_86(S_Appel_MiniJava x_2) throws Exception {
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
        regle85 () ;
      break ;
      case LEX_MiniJava.token_crochet_ouvrant : // 55
        regle85 () ;
      break ;
      case LEX_MiniJava.token_multiplication : // 72
        regle85 () ;
      break ;
      case LEX_MiniJava.token_division : // 73
        regle85 () ;
      break ;
      case LEX_MiniJava.token_modulo : // 74
        regle85 () ;
      break ;
      case LEX_MiniJava.token_et : // 77
        regle85 () ;
      break ;
      case LEX_MiniJava.token_addition : // 69
        regle85 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle85 () ;
      break ;
      case LEX_MiniJava.token_ou : // 71
        regle85 () ;
      break ;
      case LEX_MiniJava.token_egalite : // 67
        regle85 () ;
      break ;
      case LEX_MiniJava.token_different : // 68
        regle85 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 59
        regle85 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 61
        regle85 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 60
        regle85 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 62
        regle85 () ;
      break ;
      case LEX_MiniJava.token_affectation : // 66
        regle85 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 58
        regle85 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 56
        regle85 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 64
        regle85 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 65
        regle85 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle85 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle86 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
