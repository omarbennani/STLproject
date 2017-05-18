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
public class S_SuiteNouveau_MiniJava {
LEX_MiniJava scanner;
  S_SuiteNouveau_MiniJava() {
	}
  S_SuiteNouveau_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  Type att_type;
  String att_nomClasse;
  private void regle81() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_81(x_3);
	x_2.analyser(LEX_MiniJava.token_crochet_ouvrant);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_crochet_fermant);
if  (att_eval)	  action_ast_81(x_3);
  }
  private void regle82() throws Exception {

	//declaration
	S_Arguments_MiniJava x_2 = new S_Arguments_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_82(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_82(x_2);
  }
private void action_ast_81(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createArrayAllocation(this.att_type, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteNouveau -> crochet_ouvrant Expression crochet_fermant #ast ;", e });
}
  }
private void action_ast_82(S_Arguments_MiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createObjet(this.att_type, x_2.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteNouveau -> Arguments #ast ;", e });
}
  }
private void action_auto_inh_81(S_Expression_MiniJava x_3) throws Exception {
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
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteNouveau -> crochet_ouvrant Expression crochet_fermant #ast ;", e });
}
  }
private void action_auto_inh_82(S_Arguments_MiniJava x_2) throws Exception {
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
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteNouveau -> Arguments #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_crochet_ouvrant : // 55
        regle81 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle82 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
