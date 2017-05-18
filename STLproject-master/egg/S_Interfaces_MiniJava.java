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
public class S_Interfaces_MiniJava {
LEX_MiniJava scanner;
  S_Interfaces_MiniJava() {
	}
  S_Interfaces_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Interface> att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  private void regle2() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_2();
  }
  private void regle1() throws Exception {

	//declaration
	S_Interface_MiniJava x_2 = new S_Interface_MiniJava(scanner,att_eval) ;
	S_Interfaces_MiniJava x_4 = new S_Interfaces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_1(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_tds_1(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_1(x_2, x_4);
  }
private void action_tds_1(S_Interface_MiniJava x_2, S_Interfaces_MiniJava x_4) throws Exception {
try {
// instructions
this.att_tdsInterface.register(x_2.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Interfaces -> Interface #tds Interfaces1 #ast ;", e });
}
  }
private void action_ast_1(S_Interface_MiniJava x_2, S_Interfaces_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_ast.addFirst(x_2.att_ast);
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Interfaces -> Interface #tds Interfaces1 #ast ;", e });
}
  }
private void action_ast_2() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Interface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Interfaces -> #ast ;", e });
}
  }
private void action_auto_inh_1(S_Interface_MiniJava x_2, S_Interfaces_MiniJava x_4) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Interfaces -> Interface #tds Interfaces1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_interface : // 94
        regle1 () ;
      break ;
      case LEX_MiniJava.token_classe : // 95
        regle2 () ;
      break ;
      case LEX_MiniJava.token_public : // 98
        regle2 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
