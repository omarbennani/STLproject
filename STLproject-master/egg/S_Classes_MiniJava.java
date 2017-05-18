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
public class S_Classes_MiniJava {
LEX_MiniJava scanner;
  S_Classes_MiniJava() {
	}
  S_Classes_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Classe> att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  private void regle14() throws Exception {

	//declaration
	S_Classe_MiniJava x_3 = new S_Classe_MiniJava(scanner,att_eval) ;
	S_Classes_MiniJava x_5 = new S_Classes_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_14(x_3, x_5);
if  (att_eval)	  action_inh_14(x_3, x_5);
	x_3.analyser() ;
if  (att_eval)	  action_tree_14(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_14(x_3, x_5);
  }
  private void regle15() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_15();
  }
private void action_ast_14(S_Classe_MiniJava x_3, S_Classes_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_ast.addFirst(x_3.att_ast);
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Classes -> #inh Classe #tree Classes1 #ast ;", e });
}
  }
private void action_ast_15() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Classe>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Classes -> #ast ;", e });
}
  }
private void action_inh_14(S_Classe_MiniJava x_3, S_Classes_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tdsMeth= new SymbolTableMethodes();
x_3.att_tdsAtt= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Classes -> #inh Classe #tree Classes1 #ast ;", e });
}
  }
private void action_auto_inh_14(S_Classe_MiniJava x_3, S_Classes_MiniJava x_5) throws Exception {
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
x_3.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Classes -> #inh Classe #tree Classes1 #ast ;", e });
}
  }
private void action_tree_14(S_Classe_MiniJava x_3, S_Classes_MiniJava x_5) throws Exception {
try {
// instructions
this.att_tdsClasses.register(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tree","Classes -> #inh Classe #tree Classes1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_classe : // 95
        regle14 () ;
      break ;
      case LEX_MiniJava.token_public : // 98
        regle15 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
