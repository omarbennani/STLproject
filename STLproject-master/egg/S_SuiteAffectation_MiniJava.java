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
public class S_SuiteAffectation_MiniJava {
LEX_MiniJava scanner;
  S_SuiteAffectation_MiniJava() {
	}
  S_SuiteAffectation_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  SymbolTableMethodes att_tdsMethodes;
  String att_nomClasse;
  private void regle66() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_66();
  }
  private void regle65() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_65(x_3);
	x_2.analyser(LEX_MiniJava.token_affectation);
	x_3.analyser() ;
if  (att_eval)	  action_ast_65(x_3);
  }
private void action_auto_inh_65(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteAffectation -> affectation Expression #ast ;", e });
}
  }
private void action_ast_65(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createAssignment(this.att_gauche, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteAffectation -> affectation Expression #ast ;", e });
}
  }
private void action_ast_66() throws Exception {
try {
// instructions
this.att_ast=this.att_gauche;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteAffectation -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_affectation : // 66
        regle65 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 58
        regle66 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 56
        regle66 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 64
        regle66 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 65
        regle66 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle66 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
