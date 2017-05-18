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
public class S_Expressions_MiniJava {
LEX_MiniJava scanner;
  S_Expressions_MiniJava() {
	}
  S_Expressions_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expressions att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  String att_nomClasse;
  private void regle60() throws Exception {

	//declaration
	S_Expression_MiniJava x_2 = new S_Expression_MiniJava(scanner,att_eval) ;
	S_SuiteExpressions_MiniJava x_3 = new S_SuiteExpressions_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_60(x_2, x_3);
	x_2.analyser() ;
	x_3.analyser() ;
if  (att_eval)	  action_ast_60(x_2, x_3);
  }
private void action_ast_60(S_Expression_MiniJava x_2, S_SuiteExpressions_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_ast.addExpression(x_2.att_ast);
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Expressions -> Expression SuiteExpressions #ast ;", e });
}
  }
private void action_auto_inh_60(S_Expression_MiniJava x_2, S_SuiteExpressions_MiniJava x_3) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_3.att_tds=this.att_tds;
x_2.att_tdsAtt=this.att_tdsAtt;
x_3.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_3.att_factory=this.att_factory;
x_2.att_nomClasse=this.att_nomClasse;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Expressions -> Expression SuiteExpressions #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle60 () ;
  }
  }
