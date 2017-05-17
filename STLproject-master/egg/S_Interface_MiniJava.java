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
public class S_Interface_MiniJava {
LEX_MiniJava scanner;
  S_Interface_MiniJava() {
	}
  S_Interface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Interface att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  private void regle3() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_HeritageInterface_MiniJava x_4 = new S_HeritageInterface_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_ElementsInterface_MiniJava x_7 = new S_ElementsInterface_MiniJava(scanner,att_eval) ;
	T_MiniJava x_8 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_3(x_3, x_4, x_7);
	x_2.analyser(LEX_MiniJava.token_interface);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_accolade_ouvrante);
if  (att_eval)	  action_tds_3(x_3, x_4, x_7);
	x_7.analyser() ;
	x_8.analyser(LEX_MiniJava.token_accolade_fermante);
if  (att_eval)	  action_ast_3(x_3, x_4, x_7);
  }
private void action_tds_3(T_MiniJava x_3, S_HeritageInterface_MiniJava x_4, S_ElementsInterface_MiniJava x_7) throws Exception {
try {
// instructions
x_7.att_tds= new SymbolTable();
x_7.att_identObjetCourant=x_3.att_txt;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Interface -> interface identificateur_type HeritageInterface accolade_ouvrante #tds ElementsInterface accolade_fermante #ast ;", e });
}
  }
private void action_auto_inh_3(T_MiniJava x_3, S_HeritageInterface_MiniJava x_4, S_ElementsInterface_MiniJava x_7) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_7.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_7.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_7.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_7.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tds=this.att_tds;
x_4.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Interface -> interface identificateur_type HeritageInterface accolade_ouvrante #tds ElementsInterface accolade_fermante #ast ;", e });
}
  }
private void action_ast_3(T_MiniJava x_3, S_HeritageInterface_MiniJava x_4, S_ElementsInterface_MiniJava x_7) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createInterface(x_3.att_txt, x_4.att_ast, x_7.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Interface -> interface identificateur_type HeritageInterface accolade_ouvrante #tds ElementsInterface accolade_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle3 () ;
  }
  }
