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
public class S_DroitAcces_MiniJava {
LEX_MiniJava scanner;
  S_DroitAcces_MiniJava() {
	}
  S_DroitAcces_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  boolean att_eval;
  DroitAcces att_ast;
  LEX_MiniJava att_scanner;
  private void regle25() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_public);
if  (att_eval)	  action_ast_25();
  }
  private void regle26() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_protege);
if  (att_eval)	  action_ast_26();
  }
  private void regle27() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_prive);
if  (att_eval)	  action_ast_27();
  }
private void action_ast_25() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createDroitAcces(0);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","DroitAcces -> public #ast ;", e });
}
  }
private void action_ast_26() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createDroitAcces(1);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","DroitAcces -> protege #ast ;", e });
}
  }
private void action_ast_27() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createDroitAcces(2);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","DroitAcces -> prive #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_public : // 98
        regle25 () ;
      break ;
      case LEX_MiniJava.token_protege : // 99
        regle26 () ;
      break ;
      case LEX_MiniJava.token_prive : // 100
        regle27 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
