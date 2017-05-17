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
public class S_Bloc_MiniJava {
LEX_MiniJava scanner;
  S_Bloc_MiniJava() {
	}
  S_Bloc_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  SymbolTable att_tdsMethodes;
  String att_nomClasse;
  private void regle49() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Instructions_MiniJava x_4 = new S_Instructions_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_49(x_4);
	x_2.analyser(LEX_MiniJava.token_accolade_ouvrante);
if  (att_eval)	  action_inh_49(x_4);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_accolade_fermante);
if  (att_eval)	  action_ast_49(x_4);
  }
private void action_ast_49(S_Instructions_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createBlock(x_4.att_insts);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Bloc -> accolade_ouvrante #inh Instructions accolade_fermante #ast ;", e });
}
  }
private void action_auto_inh_49(S_Instructions_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAtt=this.att_tdsAtt;
x_4.att_factory=this.att_factory;
x_4.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Bloc -> accolade_ouvrante #inh Instructions accolade_fermante #ast ;", e });
}
  }
private void action_inh_49(S_Instructions_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tree= new ArrayList<Instruction>();
x_4.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Bloc -> accolade_ouvrante #inh Instructions accolade_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle49 () ;
  }
  }
