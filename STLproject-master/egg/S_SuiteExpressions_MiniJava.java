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
public class S_SuiteExpressions_MiniJava {
LEX_MiniJava scanner;
  S_SuiteExpressions_MiniJava() {
	}
  S_SuiteExpressions_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  private void regle61() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	S_SuiteExpressions_MiniJava x_4 = new S_SuiteExpressions_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_61(x_3, x_4);
	x_2.analyser(LEX_MiniJava.token_virgule);
	x_3.analyser() ;
	x_4.analyser() ;
if  (att_eval)	  action_ast_61(x_3, x_4);
  }
  private void regle62() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_62();
  }
private void action_ast_61(S_Expression_MiniJava x_3, S_SuiteExpressions_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_ast.addExpression(x_3.att_ast);
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteExpressions -> virgule Expression SuiteExpressions1 #ast ;", e });
}
  }
private void action_ast_62() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createExpressions();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteExpressions -> #ast ;", e });
}
  }
private void action_auto_inh_61(S_Expression_MiniJava x_3, S_SuiteExpressions_MiniJava x_4) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_4.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
x_4.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteExpressions -> virgule Expression SuiteExpressions1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_virgule : // 65
        regle61 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle62 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 58
        regle62 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
