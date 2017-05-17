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
public class S_Comparatif_MiniJava {
LEX_MiniJava scanner;
  S_Comparatif_MiniJava() {
	}
  S_Comparatif_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_MiniJava att_scanner;
  BinaryOperator att_bin_op;
  private void regle98() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_superieur_egal);
if  (att_eval)	  action_texte_98();
  }
  private void regle97() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_superieur);
if  (att_eval)	  action_texte_97();
  }
  private void regle96() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_inferieur_egal);
if  (att_eval)	  action_texte_96();
  }
  private void regle95() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_inferieur);
if  (att_eval)	  action_texte_95();
  }
  private void regle94() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_different);
if  (att_eval)	  action_texte_94();
  }
  private void regle93() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_egalite);
if  (att_eval)	  action_texte_93();
  }
private void action_texte_97() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Greater;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#texte","Comparatif -> superieur #texte ;", e });
}
  }
private void action_texte_96() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.LesserOrEqual;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#texte","Comparatif -> inferieur_egal #texte ;", e });
}
  }
private void action_texte_98() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.GreaterOrEqual;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#texte","Comparatif -> superieur_egal #texte ;", e });
}
  }
private void action_texte_93() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Equals;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#texte","Comparatif -> egalite #texte ;", e });
}
  }
private void action_texte_95() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Lesser;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#texte","Comparatif -> inferieur #texte ;", e });
}
  }
private void action_texte_94() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Different;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#texte","Comparatif -> different #texte ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_egalite : // 67
        regle93 () ;
      break ;
      case LEX_MiniJava.token_different : // 68
        regle94 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 59
        regle95 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 61
        regle96 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 60
        regle97 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 62
        regle98 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
